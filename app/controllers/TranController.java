package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;

import models.User;
import models.Item;
import models.CartItem;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.base.Splitter;

import views.html.transaction.*;

public class TranController extends Controller {
    
    /**
     * Render payment page
     */
    public Result payment() {
        return ok(payment.render());
    }
    
    /**
     * Parse and store a user's final cart
     */
    public Result parseCart() throws CloneNotSupportedException {
        User user = User.find.byId(session().get("username"));
        List<CartItem> userCart = user.getCart();
        userCart.clear();
        
        String cartStr = Form.form().bindFromRequest().get("cart");
        Map<String, String> cart = splitToMap(cartStr);
        for (Map.Entry<String, String> entry : cart.entrySet()) {
            int id = Integer.parseInt(entry.getKey());
            int quantity = Integer.parseInt(entry.getValue());
            
            Item item = Item.find.byId(id);
            CartItem cartItem = new CartItem();
            cartItem = (CartItem) item.clone();
            cartItem.setQuantity(quantity);
            userCart.add(cartItem);
        }
        user.save();
        System.out.println("success");
        return redirect("/payment");
    }
    
    /**
     * Split the input string into a map
     */
    private Map<String, String> splitToMap(String in) {
        return Splitter.on(" ").withKeyValueSeparator("=").split(in);
    }
}