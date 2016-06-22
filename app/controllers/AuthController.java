package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import play.data.FormFactory;

import javax.inject.Inject;

import models.User;

import views.html.auth.*;

public class AuthController extends Controller {
    @Inject
    FormFactory formF;
    
    /**
     * Render login page as home page.
     */
    public Result index() {
        return ok(login.render(""));
    }
    
    /**
     * Render signup page.
     */
    public Result signup() {
        return ok(signup.render(""));
    }
    
    /**
     * Authenticate user. Return response with message if authentication
     * fails. Otherwise redirect the user to the user home page.
     */
    public Result authenticate() {
        String username = Form.form().bindFromRequest().get("username");
        String pwd = Form.form().bindFromRequest().get("pwd");
        if (username.isEmpty() || pwd.isEmpty()) {
            return ok(login.render("Please complete all the fields."));
        }
        
        User user = User.find.byId(username);
        if (user == null) {
            return ok(login.render("User not found"));
        } else if (!user.getPwd().equals(pwd)) {
            return ok(login.render("Authentication fails. Please check your credentials."));
        } else {
            session("username", username);
            session("name", user.getName());
            return redirect("/user");
        }
    }
    
    /**
     * User registration. Store new user if all the fields are complete and validated.
     * Otherwise, return response with message.
     */
    public Result register() {
        String username = Form.form().bindFromRequest().get("username");
        String pwd = Form.form().bindFromRequest().get("pwd");
        String email = Form.form().bindFromRequest().get("email");
        String name = Form.form().bindFromRequest().get("name");
        if (username.isEmpty() || pwd.isEmpty() || email.isEmpty() || name.isEmpty()) {
            return ok(signup.render("Please complete all the fields."));
        }
        if (pwd.length() < 8) {
            return ok(signup.render("Password must be at least 8 characters."));
        }
        if (email.indexOf("@") == -1 || email.indexOf(".") == -1 || email.indexOf(".") == email.length() - 1 || email.indexOf(".") - email.indexOf("@") <= 1) {
            return ok(signup.render("Please enter a valid email."));
        }
        
        User user = User.find.byId(username);
        if (user != null) {
            return ok(signup.render("User already exists. Please log in instead."));
        } else {
            Form<User> userForm = formF.form(User.class);
            User newUser = userForm.bindFromRequest().get();
            newUser.save();
            return ok(signup.render("Registration successful! Now you can log in."));
        }
    }
    
    /**
     * End current user session.
     */
    public Result logout() {
        session().clear();
        return redirect("/");
    }
}