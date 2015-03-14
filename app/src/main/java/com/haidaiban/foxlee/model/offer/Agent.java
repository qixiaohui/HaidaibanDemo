package com.haidaiban.foxlee.model.offer;

/**
 * Created by qixiaohui on 3/12/15.
 */

    import javax.annotation.Generated;
    import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Agent {

    @Expose
    private Integer user;
    @Expose
    private String icon;
    @Expose
    private String username;

    /**
     *
     * @return
     * The user
     */
    public Integer getUser() {
        return user;
    }

    /**
     *
     * @param user
     * The user
     */
    public void setUser(Integer user) {
        this.user = user;
    }

    /**
     *
     * @return
     * The icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     *
     * @param icon
     * The icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
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

}