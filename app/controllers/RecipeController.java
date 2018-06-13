package controllers;

import models.Amount;
import models.Category;
import models.Measurement;
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
}
