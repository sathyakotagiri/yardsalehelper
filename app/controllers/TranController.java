package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;

import models.Transaction;
import models.User;
import models.Sale;
import models.Item;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.base.Splitter;

public class TranController extends Controller {
    
    /**
     * Save a new transaction to the database and decrease item quantities
     */
    public Result addTransaction() {
        String userId = session().get("username");
        User user = User.find.byId(userId);
        
        //clear user cart
        List<Item> userCart = user.getCart();
        userCart.clear();
        user.save();
        
        //decrease item quantities
        String cartStr = Form.form().bindFromRequest().get("cart");
        Map<String, String> cart = splitToMap(cartStr);
        for (Map.Entry<String, String> entry : cart.entrySet()) {
            int id = Integer.parseInt(entry.getKey());
            int quantity = Integer.parseInt(entry.getValue());
            
            Item item = Item.find.byId(id);
            int saleId = item.getSaleId();
            Sale sale = Sale.find.byId(saleId);
            item.setStock(item.getStock() - quantity);
            item.save();
            if (item.getStock() <= 0) {
                item.delete();
                sale.setSize(sale.getSize() - 1);
                sale.save();
                if (sale.getSize() <= 0) {
                    sale.delete();
                }
            }
        }
        
        //save the transaction
        Transaction transaction = new Transaction();
        double total = Double.parseDouble(Form.form().bindFromRequest().get("total"));

        transaction.setCustomerId(userId);
        transaction.setTotal(total);

        transaction.save();
        
        return ok("Transaction added.");
    }
    
    /**
     * Split the input string into a map
     */
    private Map<String, String> splitToMap(String in) {
        return Splitter.on(" ").withKeyValueSeparator("=").split(in);
    }
}