package models;
import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.List;
import java.util.ArrayList;
/**
 * User entity.
 */
@Entity
public class User extends Model {
    /**
     * unique username.
     */
    @Id
    private String username;
    /**
     * Password variable.
     */
    private String pwd;
    /**
     * Email variable.
     */
    private String email;
    /**
     * Name variable.
     */
    private String name;
    /**
     * Phone variable.
     */
    private String phone;
    /**
     * Address variable.
     */
    private String address;
    /**
     * Boolean for lock and unlock.
     */
    private boolean locked;
    /**
     * List data structure.
     */
    @ManyToMany
    private List<Item> cart = new ArrayList<Item>();
    /**
     * Finder hash map.
     */
    public static final Finder<String, User> find
        = new Finder<String, User>(User.class);
    /**
     * Getters for private fields.
     */
    /**
     * Get the user's username.
     * @return the user's username.
     */
    public final String getUsername() {
        return username;
    }
    /**
     * Get the user's password.
     * @return the user's password.
     */
    public final String getPwd() {
        return pwd;
    }
    /**
     * Get the user's email.
     * @return the user's email.
     */
    public final String getEmail() {
        return email;
    }
    /**
     * Get the user's name.
     * @return the user's name.
     */
    public final String getName() {
        return name;
    }
    /**
     * Get the user's phone.
     * @return the user's phone.
     */
    public final String getPhone() {
        return phone;
    }
    /**
     * Get the user's address.
     * @return the user's address.
     */
    public final String getAddress() {
        return address;
    }
    /**
     * Get the user's status (locked/unlocked).
     * @return the user's status (locked/unlocked).
     */
    public final boolean getLocked() {
        return locked;
    }
    /**
     * Get the user's cart.
     * @return the user's cart.
     */
    public final List<Item> getCart() {
        return cart;
    }
    /**
     * Setters for private fields.
     */
    /**
     * Set the user's username.
     * @param username the user's new username.
     */
    public final void setUsername(final String username) {
        this.username = username;
    }
    /**
     * Set the user's password.
     * @param pwd the user's new password.
     */
    public final void setPwd(final String pwd) {
        this.pwd = pwd;
    }
    /**
     * Set the user's email.
     * @param email the user's new email.
     */
    public final void setEmail(final String email) {
        this.email = email;
    }
    /**
     * Set the user's name.
     * @param name the user's new name.
     */
    public final void setName(final String name) {
        this.name = name;
    }
    /**
     * Set the user's phone.
     * @param phone the user's new phone.
     */
    public final void setPhone(final String phone) {
        this.phone = phone;
    }
    /**
     * Set the user's address.
     * @param address the user's new address.
     */
    public final void setAddress(final String address) {
        this.address = address;
    }
    /**
     * Set the user's status.
     * @param locked the user's status(locked/unlocked).
     */
    public final void setLocked(final boolean locked) {
        this.locked = locked;
    }
    /**
     * Set the user's cart.
     * @param cart the user's new cart.
     */
    public final void setCart(final List<Item> cart) {
        this.cart = cart;
    }
}