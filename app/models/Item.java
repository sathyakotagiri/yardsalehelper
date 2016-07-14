package models;
import com.avaje.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
/**
 * Entity of the database.
 */
@Entity
public class Item extends Model {
    /**
     * Unique ID.
     */
    @Id
    private int itemId;
    /**
     * Unique saleID.
     */
    private int saleId;
    /**
     * Title for each item.
     */
    private String title;
    /**
     * The description for the tiem.
     */
    private String description;
    /**
     * Price of the item.
     */
    private double price;
    /**
     * Number of pieces for each item.
     */
    private int stock;
    /**
     * For storing the image.
     */
    @Lob
    private byte[] image;
    /**
     * Finder hashmap.
     */
    public static final Finder<Integer, Item> find
            = new Finder<Integer, Item>(Item.class);
    /**
     * Getters for private fields.
     */
    /**
     * Get the item's ID.
     * @return item's ID.
     */
    public final int getItemId() {
        return itemId;
    }
    /**
     * Get the sale's ID.
     * @return sale's ID.
     */
    public final int getSaleId() {
        return saleId;
    }
    /**
     * Get the item's title.
     * @return item's title.
     */
    public final String getTitle() {
        return title;
    }
    /**
     * Get the item's description.
     * @return item's description.
     */
    public final String getDescription() {
        return description;
    }
    /**
     * Get the item's price.
     * @return item's price.
     */
    public final double getPrice() {
        return price;
    }
    /**
     * Get the item's stock.
     * @return item's stock.
     */
    public final int getStock() {
        return stock;
    }
    /**
     * Get the item's image as byte array.
     * @return item's image as byte array.
     */
    public final byte[] getImage() {
        return image;
    }
    /**
     * Setters for private fields.
     */
    /**
     * Set the item ID.
     * @param itemId the item's new ID.
     */
    public final void setItemId(final int itemId) {
        this.itemId = itemId;
    }
    /**
     * Set the sale ID.
     * @param saleId the sale's new ID.
     */
    public final void setSaleId(final int saleId) {
        this.saleId = saleId;
    }
    /**
     * Set the item's title.
     * @param title the item's new title.
     */
    public final void setTitle(final String title) {
        this.title = title;
    }
    /**
     * Set the item's description.
     * @param description the item's new description.
     */
    public final void setDescription(final String description) {
        this.description = description;
    }
    /**
     * Set the item's price.
     * @param price the item's new price.
     */
    public final void setPrice(final double price) {
        this.price = price;
    }
    /**
     * Set the item's stock.
     * @param stock the item's new stock.
     */
    public final void setStock(final int stock) {
        this.stock = stock;
    }
    /**
     * Set the item's image.
     * @param image the item's new image as byte array.
     */
    public final void setImage(final byte[] image) {
        this.image = image;
    }
}