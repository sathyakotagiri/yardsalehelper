package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import models.User;

import views.html.user.*;

public class UserController extends Controller {
    
    public Result profile() {
        return ok(profile.render());
    }
    
}