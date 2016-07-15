package controllers;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.data.Form;

import models.User;
import models.Sale;
import models.Item;

import java.util.List;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import views.html.sale.catalog;
import views.html.sale.item;
import views.html.tag.tag;
import views.html.tag.itemTag;
import views.html.tag.catalogTags;
/**
 * Controller for a sale.
 */
public class SaleController extends Controller {
    /**
     * Get the catalog of a specific sale given the sale id.
     * @param id the id of the sale.
     * @return result of API call.
     */
    public final Result index(final int id) {
        Sale sale = Sale.findById(id);
        List<Item> list = Item.findBySale(id);
        return ok(catalog.render(sale, list));
    }
    /**
     * Get the image of a sale.
     * @param id the id of the sale.
     * @return result of API call.
     */
    public final Result getSaleImg(final int id) {
        Sale sale = Sale.findById(id);
        return ok(sale.getImage());
    }
    /**
     * Save a new sale to the database.
     * @return result of API call.
     */
    public final Result add() {
        Sale newSale = new Sale();
        String title = Form.form().bindFromRequest().get("title");
        String location = Form.form().bindFromRequest().get("location");
        MultipartFormData<File> body = request().body().asMultipartFormData();
        FilePart<File> imageFile = body.getFile("file");
        /**
         * Read the image file as byte array if image is uploaded.
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
        
        String newRoles = "Seller & Sale Admin";
        User user = User.findById(session().get("username"));
        user.setRoles(user.getRoles() + " & " + newRoles);
        user.save();
        
        return ok("Sale added successfully.");
    }
    /**
     * Close a sale.
     * @param id the id of the sale which is to be closed.
     * @return result of API call.
     */
    public final Result remove(final int id) {
        Sale sale = Sale.findById(id);
        List<Item> list = Item.findBySale(id);
        list.forEach((item) -> item.delete());
        sale.delete();
        
        User user = User.findById(session().get("username"));
        user.setRoles("Guest");
        user.save();
        
        return ok("Sale closed.");
    }
    /**
     * Get a specific item given id.
     * @param id the id of the item.
     * @return result of API call.
     */
    public final Result getItem(final int id) {
        Item entry = Item.findById(id);
        Sale sale = Sale.findById(entry.getSaleId());
        return ok(item.render(sale, entry));
    }
    /**
     * Get the image of an item.
     * @param id the id of the item.
     * @return result of API call.
     */
    public final Result getItemImg(final int id) {
        Item item = Item.findById(id);
        return ok(item.getImage());
    }
    /**
     * Add an item to the catalog of the chosen sale.
     * @return result of API call.
     */
    public final Result addItem() {
        Item newItem = new Item();
        String title = Form.form().bindFromRequest().get("title");
        String description = Form.form().bindFromRequest().get("description");
        String priceStr = Form.form().bindFromRequest().get("price");
        String stockStr = Form.form().bindFromRequest().get("stock");
        String idStr = Form.form().bindFromRequest().get("saleId");
        double price = Double.parseDouble(priceStr);
        int stock = Integer.parseInt(stockStr);
        int saleId = Integer.parseInt(idStr);
        MultipartFormData<File> body = request().body().asMultipartFormData();
        FilePart<File> imageFile = body.getFile("file");
        /**
         * Read the image file as byte array if image is uploaded.
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
        Sale sale = Sale.findById(saleId);
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
     * Update an item.
     * @return result of API call.
     */
    public final Result editItem() {
        String title = Form.form().bindFromRequest().get("title");
        String description = Form.form().bindFromRequest().get("description");
        String priceStr = Form.form().bindFromRequest().get("price");
        String stockStr = Form.form().bindFromRequest().get("stock");
        String idStr = Form.form().bindFromRequest().get("itemId");
        int itemId = Integer.parseInt(idStr);
        MultipartFormData<File> body = request().body().asMultipartFormData();
        FilePart<File> imageFile = body.getFile("file");
        Item item = Item.findById(itemId);
        /**
         * Read the image file as byte array if image is uploaded.
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
        if (!title.isEmpty()) {
            item.setTitle(title);
        }
        if (!description.isEmpty()) {
            item.setDescription(description);
        }
        if (!priceStr.isEmpty()) {
            item.setPrice(Double.parseDouble(priceStr));
        }
        if (!stockStr.isEmpty()) {
            item.setStock(Integer.parseInt(stockStr));
        }
        item.save();
        return ok("Item updated successfully.");
    }
    /**
     * Render the print tag page.
     * @return result of API call.
     */
    public final Result tag() {
        return ok(tag.render());
    }
    /**
     * Fetch information about an item and render the tag.
     * @param id the id of the item.
     * @return result of API call.
     */
    public final Result printTag(final int id) {
        Item item = Item.findById(id);
        if (item == null) {
            item = new Item();
        }
        return ok(itemTag.render(item));
    }
    /**
     * Fetch information about a catalog and render the tags.
     * @param id the id of the sale whose catalog is to be rendered.
     * @return result of API call.
     */
    public final Result printTags(final int id) {
        List<Item> list = Item.findBySale(id);
        return ok(catalogTags.render(list));
    }
}
