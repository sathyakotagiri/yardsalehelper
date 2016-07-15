package models;
import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
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
     * Finder.
     */
     private static Finder<Integer, Transaction> find 
        = new Finder(Transaction.class);
    
    /**
     * Find all transactions
     * @return the transaction list found
     */
    public static List<Transaction> findAll() {
        List<Transaction> list = find.all();
        return list;
    }
    
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
     * @param transactionIdNew the transaction's new ID.
     */
    public final void setTransactionId(final int transactionIdNew) {
        this.transactionId = transactionIdNew;
    }
    /**
     * Set the customer's ID.
     * @param customerIdNew the customer's new.
     */
    public final void setCustomerId(final String customerIdNew) {
        this.customerId = customerIdNew;
    }
    /**
     * Set the transaction total.
     * @param totalNew the transaction total.
     */
    public final void setTotal(final double totalNew) {
        this.total = totalNew;
    }
}
