package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Sale extends Model {
    
    @Id
    private int saleId;
    
    private String sellerId;
    private String adminId;
    private String title;
    private String location;
    private int size;
    @Lob
    private byte[] image;
    
    public static Finder<Integer, Sale> find 
        = new Finder<Integer, Sale>(Sale.class);
    
    /**
     * Getters for private fields.
     */
    
    /**
     * Get the sale's ID
     * @return sale's ID
     */
    public int getSaleId() {
        return saleId;
    }
    /**
     * Get the seller's ID
     * @return seller's ID
     */
    public String getSellerId() {
        return sellerId;
    }
    /**
     * Get the admin's ID
     * @return admin's ID
     */
    public String getAdminId() {
        return adminId;
    }
    /**
     * Get the sale's title
     * @return sale's title
     */
    public String getTitle() {
        return title;
    }
    /**
     * Get the sale's location
     * @return sale's location
     */
    public String getLocation() {
        return location;
    }
    /**
     * Get the sale's size
     * @return sale's size
     */
    public int getSize() {
        return size;
    }
    /**
     * Get the sale's image as byte array
     * @return sale's image as byte array
     */
    public byte[] getImage() {
        return image;
    }
    
    /**
     * Setters for private fields.
     */
    
    /**
     * Set the sale ID
     * @param saleId the sale's new ID
     */
    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }
    /**
     * Set the seller ID
     * @param sellerId the seller's new ID
     */
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }
    /**
     * Set the admin ID
     * @param adminId the admin's new ID
     */
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    /**
     * Set the sale's title
     * @param title the sale's title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Set the sale's location
     * @param location the sale's location
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * Set the sale's size
     * @param size the sale's size
     */
    public void setSize(int size) {
        this.size = size;
    }
    /**
     * Set the sale's image
     * @param image the sale's image as byte array
     */
    public void setImage(byte[] image) {
        this.image = image;
    }
}