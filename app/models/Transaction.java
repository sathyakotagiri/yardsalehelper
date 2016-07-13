package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction extends Model {
    @Id
    private int transactionId;

    private String customerId;
    private double total;

    public static Finder<Integer, Transaction> find 
        = new Finder(Transaction.class);
    
    /**
     * Getters for private fields.
     */
    
    /**
     * Get the transaction's ID
     * @return the transaction's ID
     */
    public int getTransactionId() {
        return transactionId;
    }
    /**
     * Get the customer's ID
     * @return customer's ID
     */
    public String getCustomerId() {
        return customerId;
    }
    /**
     * Get the transactional total
     * @return the transactional total
     */
    public double getTotal() {
        return total;
    }

    /**
     * Setters for private fields.
     */
    
    /**
     * Set the transaction's ID
     * @param transactionId the transaction's new ID
     */
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    /**
     * Set the customer's ID
     * @param customerId the customer's new ID
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    /**
     * Set the transaction total
     * @param total the transaction total
     */
    public void setTotal(double total) {
        this.total = total;
    }
}