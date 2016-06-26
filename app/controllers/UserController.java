package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;

import models.User;
import models.Sale;

import java.util.List;

import views.html.user.*;

public class UserController extends Controller {
    
    /**
     * Render list of sales on the user home page
     */
    public Result index() {
        List<Sale> list = Sale.find.all();
        return ok(sales.render(list));
    }
    
    /**
     * Render user profile.
     */
    public Result profile() {
        User user = User.find.byId(session().get("username"));
        return ok(profile.render(user));
    }
    
    /**
     * Update user profile. Save information to the database
     * if fields are updated and validated. Otherwise, do nothing.
     */
    public Result editProfile() {
        String email = Form.form().bindFromRequest().get("email");
        String name = Form.form().bindFromRequest().get("name");
        String phone = Form.form().bindFromRequest().get("phone");
        String address = Form.form().bindFromRequest().get("address");
        
        boolean invalidEmail = email.indexOf("@") == -1 || email.lastIndexOf(".") == -1 || email.lastIndexOf(".") == email.length() - 1 || email.lastIndexOf(".") - email.indexOf("@") <= 1;
        User user = User.find.byId(session().get("username"));
        
        if (!email.isEmpty() && !invalidEmail) user.setEmail(email);
        if (!name.isEmpty()) user.setName(name);
        if (!phone.isEmpty()) user.setPhone(phone);
        if (!address.isEmpty()) user.setAddress(address);
        user.save();
        
        session("name", user.getName());
        return redirect("/profile");
    }
    
    /**
     * Update user password. Save new password to the database if it is
     * valid and old password is correct. Otherwise, return error message.
     */
    public Result changePass() {
        String oldPass = Form.form().bindFromRequest().get("oldPass");
        String newPass = Form.form().bindFromRequest().get("newPass");
        
        User user = User.find.byId(session().get("username"));
        
        if (!user.getPwd().equals(oldPass)) {
            return ok("Current password is incorrect. Please check for errors.");
        } else if (newPass.length() < 8) {
            return ok("New password must be at least 8 characters.");
        } else {
            user.setPwd(newPass);
            user.save();
            return ok("Password changed successfully!");
        }
    }
}