package controllers;

import play.mvc.Controller;

public class ApplicationController extends Controller
{
    public void login(int userId)
    {
        session().put("loggedin", "" + userId);
    }

    public void logout()
    {
        session().clear();
    }

    public boolean isLoggedIn()
    {
        boolean loggedIn = false;

        if ((session().get("loggedin") != null))
        {
            loggedIn = true;
        }

        return loggedIn;
    }

    public int getLoggedInUserId()
    {
        return Integer.parseInt(session().get("loggedin"));
    }
}
