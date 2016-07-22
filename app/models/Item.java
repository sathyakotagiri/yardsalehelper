package models;
import com.avaje.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Arrays;
import java.util.List;

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
     * Finder.
     */
    private static Finder<Integer, Item> find
        = new Finder<Integer, Item>(Item.class);
    /**
     * Find an item by ID.
     * @param id the item's ID
     * @return the item found
     */
    public static Item findById(final int id) {
        return find.byId(id);

    }
    /**
     * Find items belonged to the same sale.
     * @param id the sale's ID
     * @return the item list found
     */
    public static List<Item> findBySale(final int id) {
        return find.where().eq("saleId", id).findList();

    }
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
        if (image == null) {
            return null;
        }
        return Arrays.copyOf(image, image.length);
    }
    /**
     * Setters for private fields.
     */
    /**
     * Set the item ID.
     * @param itemIdNew the item's new ID.
     */
    public final void setItemId(final int itemIdNew) {
        this.itemId = itemIdNew;
    }
    /**
     * Set the sale ID.
     * @param saleIdNew the sale's new ID.
     */
    public final void setSaleId(final int saleIdNew) {
        this.saleId = saleIdNew;
    }
    /**
     * Set the item's title.
     * @param titleNew the item's new title.
     */
    public final void setTitle(final String titleNew) {
        this.title = titleNew;
    }
    /**
     * Set the item's description.
     * @param descriptionNew the item's new description.
     */
    public final void setDescription(final String descriptionNew) {
        this.description = descriptionNew;
    }
    /**
     * Set the item's price.
     * @param priceNew the item's new price.
     */
    public final void setPrice(final double priceNew) {
        this.price = priceNew;
    }
    /**
     * Set the item's stock.
     * @param stockNew the item's new stock.
     */
    public final void setStock(final int stockNew) {
        this.stock = stockNew;
    }
    /**
     * Set the item's image.
     * @param newImage the new image for the item.
     */
    public final void setImage(final byte[] newImage) {
        this.image = Arrays.copyOf(newImage, newImage.length);
    }
}
