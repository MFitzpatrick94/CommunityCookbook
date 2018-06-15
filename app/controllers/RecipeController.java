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

        form.rawData().keySet();

        int categoryId = Integer.parseInt(form.get("categoryId"));
        String recipeName = form.get("recipeName");
        int amountId1= Integer.parseInt(form.get("amountId"));
        int measurementId1 = Integer.parseInt(form.get("measurementId"));
        String ingredientName1 = form.get("ingredientName1");
        String step = form.get("step");
        String authorName = form.get("authorName");
        String cookTime = form.get("cookTime");
        int stepNumber = Integer.parseInt(form.get("stepNumber"));

        Recipe addRecipe = new Recipe();
        addRecipe.setRecipeName(recipeName);
        addRecipe.setCategoryId(categoryId);
        addRecipe.setAuthor(authorName);
        addRecipe.setCookTime(cookTime);


        jpaApi.em().persist(addRecipe);

        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName(ingredientName1);
        ingredient.setAmountId(amountId1);
        ingredient.setMeasurementId(measurementId1);
        ingredient.setRecipeId(addRecipe.getRecipeId());

        Directions directions = new Directions();
        directions.setStep(step);
        directions.setStepNumber(stepNumber);
        directions.setRecipeId(addRecipe.getRecipeId());

        jpaApi.em().persist(ingredient);
        jpaApi.em().persist(directions);


        return redirect(routes.CategoryController.getCategory());
    }
}
