package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.data.Form;

import models.Sale;
import models.Item;

import java.util.List;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import views.html.sale.*;
import views.html.tag.*;

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
     * Get the image of a sale
     */
    public Result getSaleImg(int id) {
        Sale sale = Sale.find.byId(id);
        return ok(sale.getImage());
    }
    
    /**
     * Save a new sale to the database
     */
    public Result add() {        
        Sale newSale = new Sale();
        
        String title = Form.form().bindFromRequest().get("title");
        String location = Form.form().bindFromRequest().get("location");
        MultipartFormData<File> body = request().body().asMultipartFormData();
        FilePart<File> imageFile = body.getFile("file");
        
        /**
         * Read the image file as byte array if image is uploaded
         */
        if (imageFile != null) {
            File image = imageFile.getFile();
            byte[] imageData = new byte[(int) image.length()];
            try (FileInputStream ins = new FileInputStream(image)) {
                ins.read(imageData);
                newSale.setImage(imageData);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        
        newSale.setTitle(title);
        newSale.setLocation(location);
        newSale.setSellerId(session().get("username"));
        newSale.setAdminId(session().get("username"));
        newSale.setSize(0);
        
        newSale.save();
        return ok("Sale added successfully.");
    }
    
    /**
     * Close a sale
     */
    public Result remove(int id) {
        Sale sale = Sale.find.byId(id);
        List<Item> list = Item.find.where().eq("saleId", id).findList();
        list.forEach((item) -> item.delete());
        sale.delete();
        return ok("Sale closed.");
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
     * Get the image of an item
     */
    public Result getItemImg(int id) {
        Item item = Item.find.byId(id);
        return ok(item.getImage());
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
        MultipartFormData<File> body = request().body().asMultipartFormData();
        FilePart<File> imageFile = body.getFile("file");
        
        /**
         * Read the image file as byte array if image is uploaded
         */
        if (imageFile != null) {
            File image = imageFile.getFile();
            byte[] imageData = new byte[(int) image.length()];
            try (FileInputStream ins = new FileInputStream(image)) {
                ins.read(imageData);
                newItem.setImage(imageData);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        
        Sale sale = Sale.find.byId(saleId);
                
        newItem.setTitle(title);
        newItem.setDescription(description);
        newItem.setPrice(price);
        newItem.setStock(stock);
        newItem.setSaleId(saleId);
        sale.setSize(sale.getSize() + 1);
                
        newItem.save();
        sale.save();
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
        MultipartFormData<File> body = request().body().asMultipartFormData();
        FilePart<File> imageFile = body.getFile("file");
        
        Item item = Item.find.byId(itemId);
        
        /**
         * Read the image file as byte array if image is uploaded
         */
        if (imageFile != null) {
            File image = imageFile.getFile();
            byte[] imageData = new byte[(int) image.length()];
            try (FileInputStream ins = new FileInputStream(image)) {
                ins.read(imageData);
                item.setImage(imageData);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        
        if (!title.isEmpty()) item.setTitle(title);
        if (!description.isEmpty()) item.setDescription(description);
        if (!priceStr.isEmpty()) item.setPrice(Double.parseDouble(priceStr));
        if (!stockStr.isEmpty()) item.setStock(Integer.parseInt(stockStr));
        item.save();
        
        return ok("Item updated successfully.");
    }
    
    /**
     * Render the print tag page
     */
    public Result tag() {
        return ok(tag.render());
    }
    
    /**
     * Fetch information about an item and render the tag
     */
    public Result printTag(int id) {
        Item item = Item.find.byId(id);
        return ok(itemTag.render(item));
    }
    
    /**
     * Fetch information about a catalog and render the tags
     */
    public Result printTags(int id) {
        List<Item> list = Item.find.where().eq("saleId", id).findList();
        return ok(catalogTags.render(list));
    }
}