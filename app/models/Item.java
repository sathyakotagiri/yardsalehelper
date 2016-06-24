-package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item extends Model {
    
    @Id
    private int saleId;
    
    private int itemId;
    private String title;
    private String description;
    private double price;
    private int stock;
    
    public static Finder<String, Item> find = new Finder<String, Item>(Item.class);
    
    /**
     * Getters for private fields.
     */
    public int getSaleId() {
        return saleId;
    }
    public int getItemId() {
        return itemId;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }
    
    /**
     * Setters for private fields.
     */
    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String Description) {
        this.description = description;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
}