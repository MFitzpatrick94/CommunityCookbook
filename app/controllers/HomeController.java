package controllers;

import models.User;
import play.db.jpa.Transactional;
import play.mvc.*;

import views.html.*;


public class HomeController extends Controller {

    public Result index()
    {
        return ok(index.render());
    }


  /*  @Transactional()
    public Result addUser()
    {
        String email = "what@blah.com";
        String password = "why";
        User user = new User();

    }
*/
}

