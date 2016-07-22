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
     * User roles.
     */
    private String roles;
    /**
     * User cart.
     */
    @ManyToMany
    private List<Item> cart = new ArrayList<Item>();
    /**
     * Finder.
     */
    private static Finder<String, User> find
        = new Finder<String, User>(User.class);
    /**
     * Find a user by username (ID).
     * @param id the user's username (ID)
     * @return the user found
     */
    public static User findById(final String id) {
        return find.byId(id);

    }
    /**
     * Find all users.
     * @return the user list found
     */
    public static List<User> findAll() {
        return find.all();

    }
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
     * Get the user's roles.
     * @return the user's roles.
     */
    public final String getRoles() {
        return roles;
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
     * @param usernameNew the user's new username.
     */
    public final void setUsername(final String usernameNew) {
        this.username = usernameNew;
    }
    /**
     * Set the user's password.
     * @param pwdNew the user's new password.
     */
    public final void setPwd(final String pwdNew) {
        this.pwd = pwdNew;
    }
    /**
     * Set the user's email.
     * @param emailNew the user's new email.
     */
    public final void setEmail(final String emailNew) {
        this.email = emailNew;
    }
    /**
     * Set the user's name.
     * @param nameNew the user's new name.
     */
    public final void setName(final String nameNew) {
        this.name = nameNew;
    }
    /**
     * Set the user's phone.
     * @param phoneNew the user's new phone.
     */
    public final void setPhone(final String phoneNew) {
        this.phone = phoneNew;
    }
    /**
     * Set the user's address.
     * @param addressNew the user's new address.
     */
    public final void setAddress(final String addressNew) {
        this.address = addressNew;
    }
    /**
     * Set the user's status.
     * @param lockedNew the user's status(locked/unlocked).
     */
    public final void setLocked(final boolean lockedNew) {
        this.locked = lockedNew;
    }
    /**
     * Set the user's status.
     * @param roles user roles
     */
    public final void setRoles(final String roles) {
        this.roles = roles;
    }
    /**
     * Set the user's cart.
     * @param cartNew the user's new cart.
     */
    public final void setCart(final List<Item> cartNew) {
        this.cart = cartNew;
    }
}
