package controllers;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;

import models.User;
import models.Sale;
import models.Item;
import models.Transaction;

import java.util.List;

import views.html.user.admin;
import views.html.user.cart;
import views.html.user.profile;
import views.html.user.report;
import views.html.sale.sales;
/**
 * controller for user.
 */
public class UserController extends Controller {
    /**
     * Render list of sales on the user home page.
     * @return result of API call.
     */
    public final Result index() {
        List<Sale> list = Sale.findAll();
        return ok(sales.render(list));
    }
    /**
     * Password max length.
     */
    private static final int PWD = 8;
    /**
     * username variable.
     */
    private String uName = "username";
    /**
     * Render user profile.
     * @return result of API call.
     */
    public final Result profile() {
        User user = User.findById(session().get(uName));
        return ok(profile.render(user));
    }
    /**
     * Update user profile. Save information to the database.
     * if fields are updated and validated. Otherwise, do nothing.
     * @return result of API call.
     */
    public final Result editProfile() {
        String email = Form.form().bindFromRequest().get("email");
        String name = Form.form().bindFromRequest().get("name");
        String phone = Form.form().bindFromRequest().get("phone");
        String address = Form.form().bindFromRequest().get("address");
        boolean invalidEmail = email.indexOf('@') == -1
                || email.lastIndexOf('.') == -1
                || email.lastIndexOf('.') == email.length() - 1
                || email.lastIndexOf('.') - email.indexOf('@') <= 1;
        User user = User.findById(session().get(uName));
        if (!email.isEmpty() && !invalidEmail) {
            user.setEmail(email);
        }
        if (!name.isEmpty()) {
            user.setName(name);
        }
        if (!phone.isEmpty()) {
            user.setPhone(phone);
        }
        if (!address.isEmpty()) {
            user.setAddress(address);
        }
        user.save();
        session("name", user.getName());
        return redirect("/profile");
    }
    /**
     * Update user password. Save new password to the database if it is.
     * valid and old password is correct. Otherwise, return error message.
     * @return result of API call.
     */
    public final Result changePass() {
        String oldPass = Form.form().bindFromRequest().get("oldPass");
        String newPass = Form.form().bindFromRequest().get("newPass");
        User user = User.findById(session().get(uName));
        if (!user.getPwd().equals(oldPass)) {
            return ok("Current password is incorrect. "
                      + "Please check for errors.");
        } else if (newPass.length() < PWD) {
            return ok("New password must be at least 8 characters.");
        } else {
            user.setPwd(newPass);
            user.save();
            return ok("Password changed successfully!");
        }
    }
    /**
     * Render a user's current cart.
     * @return result of API call.
     */
    public final Result getCart() {
        User user = User.findById(session().get(uName));
        return ok(cart.render(user.getCart()));
    }
    /**
     * Add an item to cart.
     * @return result of API call.
     */
    public final Result addToCart() {
        int id = Integer.parseInt(Form.form().bindFromRequest().get("item"));
        User user = User.findById(session().get(uName));
        Item item = Item.findById(id);
        if (user.getCart().contains(item)) {
            return ok("Item already added to cart.");
        }
        user.getCart().add(item);
        user.save();
        return ok("Item added to cart.");
    }
    /**
     * Remove an item from cart.
     * @param id the id of the item to be removed from cart.
     * @return result of API call.
     */
    public final Result removeFromCart(final int id) {
        User user = User.findById(session().get(uName));
        Item item = Item.findById(id);
        user.getCart().remove(item);
        user.save();
        return ok("Item removed from cart");
    }
    /**
     * Show a list of accounts and respective statuses.
     * @return result of API call.
     */
    public final Result accounts() {
        List<User> users = User.findAll();
        return ok(admin.render(users));
    }
    /**
     * Lock/unlock a user account.
     * @param id the username of the user to be lock/unlock.
     * @return result of API call.
     */
    public final Result toggleStatus(final String id) {
        User user = User.findById(id);
        boolean status = user.getLocked();
        user.setLocked(!status);
        user.save();
        return ok("Account status updated");
    }
    /**
     * Show a list of transactions as financial report.
     * @return result of API call.
     */
    public final Result report() {
        List<Transaction> records = Transaction.findAll();
        double total = 0.0;
        for (Transaction record : records) {
            total += record.getTotal();
        }
        return ok(report.render(records, total));
    }
}
