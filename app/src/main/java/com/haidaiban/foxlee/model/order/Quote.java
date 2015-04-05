package com.haidaiban.foxlee.model.order;

/**
 * Created by qixiaohui on 4/5/15.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Quote {

    @Expose
    private Integer customer;
    @Expose
    private Deal deal;
    @Expose
    private Object image0;
    @Expose
    private Object image1;
    @Expose
    private Object image2;
    @Expose
    private Object recommendation;
    @SerializedName("is_submitted")
    @Expose
    private Boolean isSubmitted;
    @Expose
    private String title;
    @SerializedName("web_link")
    @Expose
    private String webLink;
    @Expose
    private Object price;
    @Expose
    private String coupon;
    @Expose
    private String style;
    @Expose
    private Integer quantity;
    @Expose
    private Object shipping;
    @Expose
    private Object weight;
    @Expose
    private String custom;
    @SerializedName("direct_ship")
    @Expose
    private String directShip;
    @Expose
    private String remark;
    @Expose
    private String uid;
    @Expose
    private String order;
    @SerializedName("last_update")
    @Expose
    private String lastUpdate;
    @SerializedName("is_favorite")
    @Expose
    private Boolean isFavorite;

    /**
     *
     * @return
     * The customer
     */
    public Integer getCustomer() {
        return customer;
    }

    /**
     *
     * @param customer
     * The customer
     */
    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    /**
     *
     * @return
     * The deal
     */
    public Deal getDeal() {
        return deal;
    }

    /**
     *
     * @param deal
     * The deal
     */
    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    /**
     *
     * @return
     * The image0
     */
    public Object getImage0() {
        return image0;
    }

    /**
     *
     * @param image0
     * The image0
     */
    public void setImage0(Object image0) {
        this.image0 = image0;
    }

    /**
     *
     * @return
     * The image1
     */
    public Object getImage1() {
        return image1;
    }

    /**
     *
     * @param image1
     * The image1
     */
    public void setImage1(Object image1) {
        this.image1 = image1;
    }

    /**
     *
     * @return
     * The image2
     */
    public Object getImage2() {
        return image2;
    }

    /**
     *
     * @param image2
     * The image2
     */
    public void setImage2(Object image2) {
        this.image2 = image2;
    }

    /**
     *
     * @return
     * The recommendation
     */
    public Object getRecommendation() {
        return recommendation;
    }

    /**
     *
     * @param recommendation
     * The recommendation
     */
    public void setRecommendation(Object recommendation) {
        this.recommendation = recommendation;
    }

    /**
     *
     * @return
     * The isSubmitted
     */
    public Boolean getIsSubmitted() {
        return isSubmitted;
    }

    /**
     *
     * @param isSubmitted
     * The is_submitted
     */
    public void setIsSubmitted(Boolean isSubmitted) {
        this.isSubmitted = isSubmitted;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The webLink
     */
    public String getWebLink() {
        return webLink;
    }

    /**
     *
     * @param webLink
     * The web_link
     */
    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }

    /**
     *
     * @return
     * The price
     */
    public Object getPrice() {
        return price;
    }

    /**
     *
     * @param price
     * The price
     */
    public void setPrice(Object price) {
        this.price = price;
    }

    /**
     *
     * @return
     * The coupon
     */
    public String getCoupon() {
        return coupon;
    }

    /**
     *
     * @param coupon
     * The coupon
     */
    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    /**
     *
     * @return
     * The style
     */
    public String getStyle() {
        return style;
    }

    /**
     *
     * @param style
     * The style
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     *
     * @return
     * The quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     * The quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return
     * The shipping
     */
    public Object getShipping() {
        return shipping;
    }

    /**
     *
     * @param shipping
     * The shipping
     */
    public void setShipping(Object shipping) {
        this.shipping = shipping;
    }

    /**
     *
     * @return
     * The weight
     */
    public Object getWeight() {
        return weight;
    }

    /**
     *
     * @param weight
     * The weight
     */
    public void setWeight(Object weight) {
        this.weight = weight;
    }

    /**
     *
     * @return
     * The custom
     */
    public String getCustom() {
        return custom;
    }

    /**
     *
     * @param custom
     * The custom
     */
    public void setCustom(String custom) {
        this.custom = custom;
    }

    /**
     *
     * @return
     * The directShip
     */
    public String getDirectShip() {
        return directShip;
    }

    /**
     *
     * @param directShip
     * The direct_ship
     */
    public void setDirectShip(String directShip) {
        this.directShip = directShip;
    }

    /**
     *
     * @return
     * The remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     * @param remark
     * The remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     *
     * @return
     * The uid
     */
    public String getUid() {
        return uid;
    }

    /**
     *
     * @param uid
     * The uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     *
     * @return
     * The order
     */
    public String getOrder() {
        return order;
    }

    /**
     *
     * @param order
     * The order
     */
    public void setOrder(String order) {
        this.order = order;
    }

    /**
     *
     * @return
     * The lastUpdate
     */
    public String getLastUpdate() {
        return lastUpdate;
    }

    /**
     *
     * @param lastUpdate
     * The last_update
     */
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     *
     * @return
     * The isFavorite
     */
    public Boolean getIsFavorite() {
        return isFavorite;
    }

    /**
     *
     * @param isFavorite
     * The is_favorite
     */
    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

}
