package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends Model {
    
    @Id
    private String username;
    
    private String pwd;
    private String email;
    private String name;
    private String phone;
    private String address;
    
    public static Finder<String, User> find = new Finder<String, User>(User.class);
    
    public String getUsername() {
        return username;
    }
    public String getPwd() {
        return pwd;
    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}