package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;

import models.Sale;
import models.Item;

import java.util.List;

import views.html.sale.*;

public class SaleController extends Controller {
    
    /**
     * Get the catalog of a specific sale given the sale id
     */
    public Result index(int id) {
        Sale sale = Sale.find.byId(id);
        List<Item> list = Item.find.where().eq("saleId", id).findList();
        return ok(catalog.render(sale, list));
    }
    
    /**
     * Save a new sale to the database
     */
    public Result add() {        
        Sale newSale = new Sale();
        
        String title = Form.form().bindFromRequest().get("title");
        String location = Form.form().bindFromRequest().get("location");
        
        newSale.setTitle(title);
        newSale.setLocation(location);
        newSale.setSellerId(session().get("username"));
        newSale.setSize(0);
        
        newSale.save();
        return ok("Sale added successfully.");
    }
    
    /**
     * Add an item to the catalog of the chosen sale
     */
    public Result addItem() {
        Item newItem = new Item();
        
        String title = Form.form().bindFromRequest().get("title");
        String description = Form.form().bindFromRequest().get("description");
        double price = Double.parseDouble(Form.form().bindFromRequest().get("price"));
        int stock = Integer.parseInt(Form.form().bindFromRequest().get("stock"));
        int saleId = Integer.parseInt(Form.form().bindFromRequest().get("saleId"));
                
        newItem.setTitle(title);
        newItem.setDescription(description);
        newItem.setPrice(price);
        newItem.setStock(stock);
        newItem.setSaleId(saleId);
                
        newItem.save();
        return ok("Item added successfully.");
    }
    
}