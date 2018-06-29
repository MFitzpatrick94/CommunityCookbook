package controllers;


import models.Password;
import models.User;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

public class UserController extends ApplicationController
{
    private JPAApi jpaApi;
    private FormFactory formFactory;

    @Inject
    public UserController(JPAApi jpaApi, FormFactory formFactory)
    {
        this.jpaApi = jpaApi;
        this.formFactory = formFactory;
    }
    @Transactional()
    public Result getUser()
    {
        return ok(views.html.login.render());
    }
    @Transactional()
    public Result postUser()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String email = form.get("email");
        String password = form.get("password");

        String sql = "SELECT u FROM User u WHERE email = :email";

        List<User> users = jpaApi.em().createQuery(sql, User.class).
                setParameter("email", email).
                getResultList();

        if (users.size() == 1)
        {
            User loggedInUser = users.get(0);

            byte salt[] = loggedInUser.getSalt();
            byte hashedPassword[] = Password.hashPassword(password.toCharArray(), salt);

            if (Arrays.equals(hashedPassword, loggedInUser.getPassword()))
            {
                login(loggedInUser.getUserId());
                return redirect(routes.CategoryController.getCategory());
            }
        }
        else
        {
            try
            {
                byte salt[] = Password.getNewSalt();
                Password.hashPassword(password.toCharArray(), salt);
            }
            catch (Exception e)
            {

            }
        }
        return ok("Log In Failed");
    }

    @Transactional()
    public Result getNewUser()
    {
        return ok(views.html.createaccount.render());
    }


    @Transactional()
    public Result postNewUser()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String newUser = form.get("email");
        String password = form.get("password");

        User user = new User();
        user.setEmail(newUser);



        try
        {
            byte[] salt = Password.getNewSalt();
            byte[] hashedPassword = Password.hashPassword(password.toCharArray(), salt);
            password = null;

            user.setSalt(salt);
            user.setPassword(hashedPassword);

            jpaApi.em().persist(user);
        }
        catch (Exception e)
        {
            return ok("Failed to save user");
        }
        return redirect(routes.CategoryController.getCategory());
    }

}
