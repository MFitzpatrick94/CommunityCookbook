package controllers;

import com.google.common.io.Files;
import models.*;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.io.File;
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
        Http.MultipartFormData<File> formData = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart<File> filePart = formData.getFile("photo");
        File file = filePart.getFile();
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
        if(file !=null)
        {
            try
            {
                addRecipe.setPicture(Files.toByteArray(file));
            }
            catch (Exception e)
            {
                //do nothing
            }
        }
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

    @Transactional(readOnly = true)
    public Result getRecipeDetails(Integer recipeId)
    {
        String sql = "SELECT r FROM Recipe r WHERE recipeId = :recipeId";

        Recipe recipe =  jpaApi.em().
                createQuery(sql, Recipe.class).
                setParameter("recipeId", recipeId).
                getSingleResult();

        String ingredientSQl = "SELECT NEW models.IngredientMeasurement(i.ingredientId, i.ingredientName, a.amountName, m.measurementName)" +
                "FROM Ingredient i " +
                "JOIN Amount a on i.amountId = a.amountId " +
                "JOIN Measurement m on i.measurementId = m. measurementId " +
                " WHERE recipeId = :recipeId ORDER BY i.ingredientId";

        List<IngredientMeasurement> ingredient = jpaApi.em().
                createQuery(ingredientSQl, IngredientMeasurement.class).
                setParameter("recipeId", recipeId).getResultList();

        String directionSQL = "SELECT d FROM Directions d WHERE recipeId = :recipeId ORDER BY d.stepNumber";

        List<Directions> directions = jpaApi.em().
                createQuery(directionSQL, Directions.class).
                setParameter("recipeId", recipeId).getResultList();


        return ok(views.html.recipedisplay.render(recipe, ingredient, directions));
    }

    @Transactional(readOnly = true)
    public Result getPicture(Integer recipeId)
    {
        String sql = "SELECT r FROM Recipe r " +
                "WHERE recipeId = :recipeId";

        Recipe recipe = jpaApi.em().createQuery(sql, Recipe.class).setParameter("recipeId", recipeId).getSingleResult();
        return ok(recipe.getPicture()).as("image/jpg");
    }
}


