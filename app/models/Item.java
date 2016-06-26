package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item extends Model {
    
    @Id
    private int itemId;
    
    private int saleId;
    private String title;
    private String description;
    private double price;
    private int stock;
    
    public static Finder<Integer, Item> find = new Finder<Integer, Item>(Item.class);
    
    /**
     * Getters for private fields.
     */
    public int getItemId() {
        return itemId;
    }
    public int getSaleId() {
        return saleId;
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
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public void setSaleId(int saleId) {
        this.saleId = saleId;
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