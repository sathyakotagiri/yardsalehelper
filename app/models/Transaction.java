package models;
import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * Transaction entity.
 */
@Entity
public class Transaction extends Model {
    /**
     * Unique ID.
     */
    @Id
    private int transactionId;
    /**
     * Each customer is given an ID.
     */
    private String customerId;
    /**
     * The total of each sale.
     */
    private double total;
    /**
     * Finder hash map.
     */
    public static final Finder<Integer, Transaction> find
        = new Finder(Transaction.class);
    /**
     * Getters for private fields.
     */
    /**
     * Get the transaction's ID.
     * @return the transaction's ID.
     */
    public final int getTransactionId() {
        return transactionId;
    }
    /**
     * Get the customer's ID.
     * @return customer's ID.
     */
    public final String getCustomerId() {
        return customerId;
    }
    /**
     * Get the transactional total.
     * @return the transactional total.
     */
    public final double getTotal() {
        return total;
    }
    /**
     * Setters for private fields.
     */
    /**
     * Set the transaction's ID.
     * @param transactionId the transaction's new ID.
     */
    public final void setTransactionId(final int transactionId) {
        this.transactionId = transactionId;
    }
    /**
     * Set the customer's ID.
     * @param customerId the customer's new.
     */
    public final void setCustomerId(final String customerId) {
        this.customerId = customerId;
    }
    /**
     * Set the transaction total.
     * @param total the transaction total.
     */
    public final void setTotal(final double total) {
        this.total = total;
    }
}