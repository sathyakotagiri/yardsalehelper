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
    public int getUserID() {
        return userID;
    }
    public int getTransTotal() {
        return transTotal;
    }

    /**
     * Setters for private fields.
     */
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public void setTransTotal(int transTotal) {
        this.transTotal = transTotal;
    }
}