package com.haidaiban.foxlee.model.deal;

/**
 * Created by qixiaohui on 3/15/15.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Recommendations {

    @Expose
    private String image;
    @Expose
    private String deal;
    @Expose
    private String uid;
    @Expose
    private Integer order;
    @Expose
    private String title;
    @Expose
    private String style;
    @SerializedName("full_price")
    @Expose
    private String fullPrice;
    @SerializedName("discount_price")
    @Expose
    private String discountPrice;
    @Expose
    private String weblink;

    /**
     *
     * @return
     * The image
     */
    public String getImage() {
        return image;
    }

    /**
     *
     * @param image
     * The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     *
     * @return
     * The deal
     */
    public String getDeal() {
        return deal;
    }

    /**
     *
     * @param deal
     * The deal
     */
    public void setDeal(String deal) {
        this.deal = deal;
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
    public Integer getOrder() {
        return order;
    }

    /**
     *
     * @param order
     * The order
     */
    public void setOrder(Integer order) {
        this.order = order;
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
     * The fullPrice
     */
    public String getFullPrice() {
        return fullPrice;
    }

    /**
     *
     * @param fullPrice
     * The full_price
     */
    public void setFullPrice(String fullPrice) {
        this.fullPrice = fullPrice;
    }

    /**
     *
     * @return
     * The discountPrice
     */
    public String getDiscountPrice() {
        return discountPrice;
    }

    /**
     *
     * @param discountPrice
     * The discount_price
     */
    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    /**
     *
     * @return
     * The weblink
     */
    public String getWeblink() {
        return weblink;
    }

    /**
     *
     * @param weblink
     * The weblink
     */
    public void setWeblink(String weblink) {
        this.weblink = weblink;
    }

}
