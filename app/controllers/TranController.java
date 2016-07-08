package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;

import models.User;
import models.Item;
import models.Transaction;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

import com.google.common.base.Splitter;

import views.html.customer.*;

public class TranController extends Controller {
    
    /**
     * Parse a user's final cart and add transaction
     */
    public Result parseCart() {
        Map<Item, Integer> receiptItems = new HashMap<Item, Integer>(); 
        
        User user = User.find.byId(session().get("username"));
        List<Item> userCart = user.getCart();
//        userCart.clear();
        
        String cartStr = Form.form().bindFromRequest().get("cart");
        String type = Form.form().bindFromRequest().get("paymentType");
        double total = Double.parseDouble(Form.form().bindFromRequest().get("total"));
        
        System.out.println(cartStr);
        System.out.println(type);
        System.out.println(total);
        
        Map<String, String> cart = splitToMap(cartStr);
        for (Map.Entry<String, String> entry : cart.entrySet()) {
            int id = Integer.parseInt(entry.getKey());
            int quantity = Integer.parseInt(entry.getValue());
            
            Item item = Item.find.byId(id);
            receiptItems.put(item, quantity);
        }
        
        user.save();
        return ok("Okokok");
    }
    
    /**
     * Split the input string into a map
     */
    private Map<String, String> splitToMap(String in) {
        return Splitter.on(" ").withKeyValueSeparator("=").split(in);
    }
    
    /**
     * Render the receipt
     * @(items: Map[Item, Integer])(paymentType: String)(total: Double)
     */
    public Result generateReceipt() {
        System.out.println("Testing");
        return ok(receipt.render()).as("text/html");
    }
}