package controllers;

import models.*;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public class CategoryController extends Controller
{
    private JPAApi jpaApi;
    private FormFactory formFactory;

    @Inject
    public CategoryController(JPAApi jpaApi, FormFactory formFactory)
    {
        this.jpaApi = jpaApi;
        this.formFactory = formFactory;
    }

    @Transactional(readOnly = true)
    public Result getCategory()
    {
        String sql = "SELECT c from Category c";
        List<Category> categories = jpaApi.em().createQuery(sql, Category.class).getResultList();
        return ok(views.html.category.render(categories));
    }

    @Transactional(readOnly = true)
    public Result getBreakfast()
    {

        String sql = "SELECT r FROM Recipe r WHERE categoryId = 1";

        List<Recipe> breakfasts = jpaApi.em().createQuery(sql, Recipe.class).getResultList();

        return ok(views.html.breakfast.render(breakfasts));
    }

    @Transactional(readOnly = true)
    public Result getAppetizer()
    {
        String sql = "SELECT r FROM Recipe r WHERE categoryId = 2";

        List<Recipe> appetizers = jpaApi.em().createQuery(sql, Recipe.class).getResultList();

        return ok(views.html.appetizer.render(appetizers));
    }

    @Transactional(readOnly = true)
    public Result getSaladSoup()
    {
        String sql = "SELECT r FROM Recipe r WHERE categoryId = 3";

        List<Recipe> saladSoups = jpaApi.em().createQuery(sql, Recipe.class).getResultList();

        return ok(views.html.saladsoup.render(saladSoups));
    }

    @Transactional(readOnly = true)
    public Result getEntree()
    {
        String sql = "SELECT r FROM Recipe r WHERE categoryId = 4";

        List<Recipe> entrees = jpaApi.em().createQuery(sql, Recipe.class).getResultList();

        return ok(views.html.entree.render(entrees));
    }

    @Transactional(readOnly = true)
    public Result getDessert()
    {
        String sql = "SELECT r FROM Recipe r WHERE categoryId = 5";

        List<Recipe> desserts = jpaApi.em().createQuery(sql, Recipe.class).getResultList();

        return ok(views.html.dessert.render(desserts));
    }

    @Transactional(readOnly = true)
    public Result getDrink()
    {
        String sql = "SELECT r FROM Recipe r WHERE categoryId = 6";

        List<Recipe> drinks = jpaApi.em().createQuery(sql, Recipe.class).getResultList();

        return ok(views.html.drink.render(drinks));
    }
}
