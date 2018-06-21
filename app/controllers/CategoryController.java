package controllers;

import models.Category;
import play.data.DynamicForm;
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
       // DynamicForm form = formFactory.form().bindFromRequest();
        String sql = "SELECT c from Category c";
        List<Category> categories = jpaApi.em().createQuery(sql, Category.class).getResultList();
        return ok(views.html.category.render(categories));
    }

}
