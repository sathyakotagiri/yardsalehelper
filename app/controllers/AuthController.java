package controllers;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import play.data.FormFactory;

import javax.inject.Inject;

import models.User;

import views.html.auth.login;
import views.html.auth.signup;
/**
 * Controller for authenticating users.
 */
public class AuthController extends Controller {
    /**
     * form
     */
    @Inject
    private FormFactory formF;

    /**
     * bad login string
     */
    private String badLogin = "badLogin";
    /**
     * Render login page as home page.
     * @return result of API call
     */
    public final Result index() {
        return ok(login.render(""));
    }
    /**
     * Render signup page.
     * @return result of API call
     */
    public final Result signup() {
        return ok(signup.render(""));
    }
    /**
     * Authenticate user. Return response with message if authentication
     * fails. Otherwise redirect the user to the user home page.
     * @return result of API call
     */
    public final Result authenticate() {
        String username = Form.form().bindFromRequest().get("username");
        String pwd = Form.form().bindFromRequest().get("pwd");
        if (username.isEmpty() || pwd.isEmpty()) {
            return ok(login.render("Please complete all the fields."));
        }
        User user = User.find.byId(username);
        if (user == null) {
            return ok(login.render("User not found"));
        } else if (user.getLocked()) {
            return ok(login.render("Account locked. Please contact admin."));
        } else if (!user.getPwd().equals(pwd)) {
            String bad = session().get(badLogin);
            if (bad == null) {
                session(badLogin, "0");
            } else {
                int b = Integer.parseInt(bad) + 1;
                session(badLogin, Integer.toString(b));
            }
            if (Integer.parseInt(session().get(badLogin)) > 3) {
                user.setLocked(true);
                user.save();
                return ok(login.render("Account locked due to" 
                                       + "multiple failed login attempts. " 
                                       + "Please contact the admin."));
            }
            return ok(login.render("Authentication fails. " 
                                   + "Please check your credentials."));
        } else {
            session(badLogin, "0");
            session("username", username);
            session("name", user.getName());
            return redirect("/user");
        }
    }
    /**
     * User registration. 
     * Store new user if all the fields are complete and validated.
     * Otherwise, return response with message.
     * @return result of API call
     */
    public final Result register() {
        String username = Form.form().bindFromRequest().get("username");
        String pwd = Form.form().bindFromRequest().get("pwd");
        String email = Form.form().bindFromRequest().get("email");
        String name = Form.form().bindFromRequest().get("name");
        if (username.isEmpty() || pwd.isEmpty() 
            || email.isEmpty() || name.isEmpty()) {
            return ok(signup.render("Please complete all the fields."));
        }
        if (username.contains(" ")) {
            return ok(signup.render("Username cannot contain whitespace."));
        }
        if (pwd.length() < 8) {
            return ok(signup.render("Password must be at least 8 characters."));
        }
        if (email.indexOf(' ') != -1 || email.indexOf('@') == -1
            || email.lastIndexOf('.') == -1
            || email.lastIndexOf('.') == email.length() - 1
            || email.lastIndexOf('.') - email.indexOf('@') <= 1) {
            return ok(signup.render("Please enter a valid email."));
        }
        User user = User.find.byId(username);
        if (user != null) {
            return ok(signup.render("User already exists. "
                                    + "Please log in instead."));
        } else {
            Form<User> userForm = formF.form(User.class);
            User newUser = userForm.bindFromRequest().get();
            newUser.save();
            return ok(signup.render("Registration successful! " 
                                    + "Now you can log in."));
        }
    }
    /**
     * End current user session.
     * @return result of API call
     */
    public final Result logout() {
        session().clear();
        return redirect("/");
    }
}
