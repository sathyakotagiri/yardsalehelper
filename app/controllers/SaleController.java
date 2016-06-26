package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;

import models.Sale;

import views.html.user.sales;

public class SaleController extends Controller {
    
    private int idGenerator = 0;
    
    /**
     * Save a new sale to the database
     */
    public Result add() {        
        Sale newSale = new Sale();
        
        String title = Form.form().bindFromRequest().get("title");
        String location = Form.form().bindFromRequest().get("location");
        
        newSale.setTitle(title);
        newSale.setLocation(location);
        newSale.setSaleId(idGenerator++);
        newSale.setSellerId(session().get("username"));
        newSale.setSize(0);
        
        newSale.save();
        return ok("Sale added successfully.");
    }
    
}