package com.haidaiban.foxlee.model.profile;

/**
 * Created by tom on 5/25/15.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class User {

    @Expose
    private Integer id;
    @Expose
    private String username;
    @SerializedName("first_name")
    @Expose
    private Object firstName;
    @SerializedName("last_name")
    @Expose
    private Object lastName;
    @Expose
    private Object email;
    @SerializedName("date_joined")
    @Expose
    private String dateJoined;
    @SerializedName("last_login")
    @Expose
    private String lastLogin;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     * The firstName
     */
    public Object getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     * The first_name
     */
    public void setFirstName(Object firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     * The lastName
     */
    public Object getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     * The last_name
     */
    public void setLastName(Object lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     * The email
     */
    public Object getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(Object email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The dateJoined
     */
    public String getDateJoined() {
        return dateJoined;
    }

    /**
     *
     * @param dateJoined
     * The date_joined
     */
    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    /**
     *
     * @return
     * The lastLogin
     */
    public String getLastLogin() {
        return lastLogin;
    }

    /**
     *
     * @param lastLogin
     * The last_login
     */
    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

}
