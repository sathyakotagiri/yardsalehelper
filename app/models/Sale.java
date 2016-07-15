package models;
import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Arrays;

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
        return Arrays.copyOf(image, image.length);
    }
    /**
     * Setters for private fields.
     */
    /**
     * Set the sale ID.
     * @param saleIdNew the sale's new ID.
     */
    public final void setSaleId(final int saleIdNew) {
        this.saleId = saleIdNew;
    }
    /**
     * Set the seller ID.
     * @param sellerIdNew the seller's new ID.
     */
    public final void setSellerId(final String sellerIdNew) {
        this.sellerId = sellerIdNew;
    }
    /**
     * Set the admin ID.
     * @param adminIdNew the admin's new ID.
     */
    public final void setAdminId(final String adminIdNew) {
        this.adminId = adminIdNew;
    }
    /**
     * Set the sale's title.
     * @param titleNew the sale's title.
     */
    public final void setTitle(final String titleNew) {
        this.title = titleNew;
    }
    /**
     * Set the sale's location.
     * @param locationNew the sale's location.
     */
    public final void setLocation(final String locationNew) {
        this.location = locationNew;
    }
    /**
     * Set the sale's size.
     * @param sizeNew the sale's size.
     */
    public final void setSize(final int sizeNew) {
        this.size = sizeNew;
    }
    /**
     * Set the sale's image.
     * @param imageNew the sale's image as byte array.
     */
    public final void setImage(final byte[] imageNew) {
        this.image = Arrays.copyOf(imageNew, imageNew.length);
    }
}
