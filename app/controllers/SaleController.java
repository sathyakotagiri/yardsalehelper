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
     * Get a specific item given id
     */
    public Result getItem(int id) {
        Item entry = Item.find.byId(id);
        Sale sale = Sale.find.byId(entry.getSaleId());
        return ok(item.render(sale, entry));
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
    
    /**
     * Update an item
     */
    public Result editItem() {
        String title = Form.form().bindFromRequest().get("title");
        String description = Form.form().bindFromRequest().get("description");
        String priceStr = Form.form().bindFromRequest().get("price");
        String stockStr = Form.form().bindFromRequest().get("stock");
        int itemId = Integer.parseInt(Form.form().bindFromRequest().get("itemId"));
        
        Item item = Item.find.byId(itemId);
        
        if (!title.isEmpty()) item.setTitle(title);
        if (!description.isEmpty()) item.setDescription(description);
        if (!priceStr.isEmpty()) item.setPrice(Double.parseDouble(priceStr));
        if (!stockStr.isEmpty()) item.setStock(Integer.parseInt(stockStr));
        item.save();
        
        return ok("Item updated successfully.");
    }
}