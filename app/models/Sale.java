package models;
import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
/**
 * Sale entity type.
 */
@Entity
public class Sale extends Model {
    /**
     * Unique saleID.
     */
    @Id
    private int saleId;
    /**
     * Unique SellerID.
     */
    private String sellerId;
    /**
     * Unique adminId.
     */
    private String adminId;
    /**
     * Title for the sale.
     */
    private String title;
    /**
     * Location for the sale.
     */
    private String location;
    /**
     * The size of the sale.
     */
    private int size;
    /**
     * Lob for image.
     */
    @Lob
    private byte[] image;
    /**
     * Finder hash map.
     */
    public static final Finder<Integer, Sale> find
        = new Finder<Integer, Sale>(Sale.class);
    /**
     * Getters for private fields.
     */
    /**
     * Get the sale's ID.
     * @return sale's ID.
     */
    public final int getSaleId() {
        return saleId;
    }
    /**
     * Get the seller's ID.
     * @return seller's ID.
     */
    public final String getSellerId() {
        return sellerId;
    }
    /**
     * Get the admin's ID.
     * @return admin's ID.
     */
    public final String getAdminId() {
        return adminId;
    }
    /**
     * Get the sale's title.
     * @return sale's title.
     */
    public final String getTitle() {
        return title;
    }
    /**
     * Get the sale's location.
     * @return sale's location.
     */
    public final String getLocation() {
        return location;
    }
    /**
     * Get the sale's size.
     * @return sale's size.
     */
    public final int getSize() {
        return size;
    }
    /**
     * Get the sale's image as byte array.
     * @return sale's image as byte array.
     */
    public final byte[] getImage() {
        return image;
    }
    /**
     * Setters for private fields.
     */
    /**
     * Set the sale ID.
     * @param saleId the sale's new ID.
     */
    public final void setSaleId(final int saleId) {
        this.saleId = saleId;
    }
    /**
     * Set the seller ID.
     * @param sellerId the seller's new ID.
     */
    public final void setSellerId(final String sellerId) {
        this.sellerId = sellerId;
    }
    /**
     * Set the admin ID.
     * @param adminId the admin's new ID.
     */
    public final void setAdminId(final String adminId) {
        this.adminId = adminId;
    }
    /**
     * Set the sale's title.
     * @param title the sale's title.
     */
    public final void setTitle(final String title) {
        this.title = title;
    }
    /**
     * Set the sale's location.
     * @param location the sale's location.
     */
    public final void setLocation(final String location) {
        this.location = location;
    }
    /**
     * Set the sale's size.
     * @param size the sale's size.
     */
    public final void setSize(final int size) {
        this.size = size;
    }
    /**
     * Set the sale's image.
     * @param image the sale's image as byte array.
     */
    public final void setImage(final byte[] image) {
        this.image = image;
    }
}