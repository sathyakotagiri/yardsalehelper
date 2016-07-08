package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Item extends Model {
    
    @Id
    private int itemId;
    
    private int saleId;
    private String title;
    private String description;
    private double price;
    private int stock;
    @Lob
    private byte[] image;
    
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
    public byte[] getImage() {
        return image;
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
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }
}