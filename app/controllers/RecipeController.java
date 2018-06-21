package controllers;

import models.*;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;

public class RecipeController extends Controller
{
    private JPAApi jpaApi;
    private FormFactory formFactory;

    @Inject
    public RecipeController(JPAApi jpaApi, FormFactory formFactory)
    {
        this.jpaApi = jpaApi;
        this.formFactory = formFactory;
    }


    @Transactional
    public Result getAddRecipe()
    {
        String sql = "SELECT c FROM Category c";
        String amountSQL = "SELECT a FROM Amount a";
        String measurementSQL = "SELECT m FROM Measurement m";

        List<Measurement> measurements = jpaApi.em().createQuery(measurementSQL, Measurement.class).getResultList();
        List<Amount> amounts = jpaApi.em().createQuery(amountSQL, Amount.class).getResultList();
        List<Category> categories = jpaApi.em().createQuery(sql, Category.class).getResultList();
        return ok(views.html.addrecipe.render(categories, amounts, measurements));
    }

    @Transactional
    public Result postAddRecipe()
    {
        DynamicForm form = formFactory.form().bindFromRequest();

        Set<String> formNames = form.rawData().keySet();

        int categoryId = Integer.parseInt(form.get("categoryId"));
        String recipeName = form.get("recipeName");
        String authorName = form.get("authorName");
        String cookTime = form.get("cookTime");


        Recipe addRecipe = new Recipe();
        addRecipe.setRecipeName(recipeName);
        addRecipe.setCategoryId(categoryId);
        addRecipe.setAuthor(authorName);
        addRecipe.setCookTime(cookTime);
        jpaApi.em().persist(addRecipe);

        for(String formName : formNames)
        {
            if(formName.startsWith("amountId"))
            {
                String rowNumber = formName.replace("amountId","");
                String amount= form.get(formName);
                int amountsId = Integer.parseInt(amount);
                String ingredientName= form.get("ingredientName" + rowNumber);
                String measurement = form.get("measurementId" + rowNumber);
                int measurements = Integer.parseInt(measurement);

                Ingredient ingredient = new Ingredient();
                ingredient.setIngredientName(ingredientName);
                ingredient.setAmountId(amountsId);
                ingredient.setMeasurementId(measurements);
                ingredient.setRecipeId(addRecipe.getRecipeId());
                jpaApi.em().persist(ingredient);
            }
        }


        for(String formName : formNames)
        {
            if(formName.startsWith("stepNumber"))
            {
                String rowNumber = formName.replace("stepNumber", "");
                String stepNumber = form.get(formName);
                int stepNumbers = Integer.parseInt(stepNumber);
                String step = form.get("step" + rowNumber);


                Directions directions = new Directions();
                directions.setStep(step);
                directions.setStepNumber(stepNumbers);
                directions.setRecipeId(addRecipe.getRecipeId());


                jpaApi.em().persist(directions);
            }
        }

        return redirect(routes.CategoryController.getCategory());
    }
}


