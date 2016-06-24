package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sale extends Model {
    
    @Id
    private int saleId;
    
    private String sellerId;
    private String title;
    private String location;
    private int size;
    
    /**
     * Getters for private fields.
     */
    public int getSaleId() {
        return saleId;
    }
    public String getSellerId() {
        return sellerId;
    }
    public String getTitle() {
        return title;
    }
    public String getLocation() {
        return location;
    }
    public int getSize() {
        return size;
    }
    
     /**
     * Setters for private fields.
     */
    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setSize(int size) {
        this.size = size;
    }
}