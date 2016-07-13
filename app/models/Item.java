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
    
    public static Finder<Integer, Item> find 
        = new Finder<Integer, Item>(Item.class);
    
    /**
     * Getters for private fields.
     */
    
    /**
     * Get the item's ID
     * @return item's ID
     */
    public int getItemId() {
        return itemId;
    }
    /**
     * Get the sale's ID
     * @return sale's ID
     */
    public int getSaleId() {
        return saleId;
    }
    /**
     * Get the item's title
     * @return item's title
     */
    public String getTitle() {
        return title;
    }
    /**
     * Get the item's description
     * @return item's description
     */
    public String getDescription() {
        return description;
    }
    /**
     * Get the item's price
     * @return item's price
     */
    public double getPrice() {
        return price;
    }
    /**
     * Get the item's stock
     * @return item's stock
     */
    public int getStock() {
        return stock;
    }
    /**
     * Get the item's image as byte array
     * @return item's image as byte array
     */
    public byte[] getImage() {
        return image;
    }
    
    /**
     * Setters for private fields.
     */
    
    /**
     * Set the item ID
     * @param itemId the item's new ID
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    /**
     * Set the sale ID
     * @param saleId the sale's new ID
     */
    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }
    /**
     * Set the item's title
     * @param title the item's new title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Set the item's description
     * @param description the item's new description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Set the item's price
     * @param price the item's new price
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * Set the item's stock
     * @param stock the item's new stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    /**
     * Set the item's image
     * @param image the item's new image as byte array
     */
    public void setImage(byte[] image) {
        this.image = image;
    }
}