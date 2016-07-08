package models;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public class CartItem extends Item {

    private int quantity;
    
    public static Finder<Integer, CartItem> find = new Finder<Integer, CartItem>(CartItem.class);
    
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}