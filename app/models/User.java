package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.List;
import java.util.ArrayList;

@Entity
public class User extends Model {
    
    @Id
    private String username;
    
    private String pwd;
    private String email;
    private String name;
    private String phone;
    private String address;
    private boolean locked;
    
    @ManyToMany
    private List<Item> cart = new ArrayList<Item>();
    
    public static Finder<String, User> find 
        = new Finder<String, User>(User.class);
    
    /**
     * Getters for private fields.
     */
    
    /**
     * Get the user's username
     * @return the user's username
     */
    public String getUsername() {
        return username;
    }
    /**
     * Get the user's password
     * @return the user's password
     */
    public String getPwd() {
        return pwd;
    }
    /**
     * Get the user's email
     * @return the user's email
     */
    public String getEmail() {
        return email;
    }
    /**
     * Get the user's name
     * @return the user's name
     */
    public String getName() {
        return name;
    }
    /**
     * Get the user's phone
     * @return the user's phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * Get the user's address
     * @return the user's address
     */
    public String getAddress() {
        return address;
    }
    /**
     * Get the user's status (locked/unlocked)
     * @return the user's status (locked/unlocked)
     */
    public boolean getLocked() {
        return locked;
    }
    /**
     * Get the user's cart
     * @return the user's cart
     */
    public List<Item> getCart() {
        return cart;
    }
    
    /**
     * Setters for private fields.
     */
    
    /**
     * Set the user's username
     * @param username the user's new username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Set the user's password
     * @param pwd the user's new password
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    /**
     * Set the user's email
     * @param email the user's new email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Set the user's name
     * @param name the user's new name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Set the user's phone
     * @param phone the user's new phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * Set the user's address
     * @param address the user's new address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * Set the user's status
     * @param locked the user's status(locked/unlocked)
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    /**
     * Set the user's cart
     * @param cart the user's new cart
     */
    public void setCart(List<Item> cart) {
        this.cart = cart;
    }
}