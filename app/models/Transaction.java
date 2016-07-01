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

    public static Finder<Integer, Transaction> find = new Finder(Transaction.class);

    /**
     * Getters for private fields.
     */
    public int getTransactionId() {
        return transactionId;
    }
    public String getCustomerId() {
        return customerId;
    }
    public double getTotal() {
        return total;
    }

    /**
     * Setters for private fields.
     */
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public void setTotal(double total) {
        this.total = total;
    }
}