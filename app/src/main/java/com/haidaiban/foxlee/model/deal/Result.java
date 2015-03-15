package com.haidaiban.foxlee.model.deal;

/**
 * Created by qixiaohui on 3/15/15.
 */
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Result {

    @Expose
    private List<Object> recommendations = new ArrayList<Object>();
    @Expose
    private Publisher publisher;
    @Expose
    private String image;
    @SerializedName("like_count")
    @Expose
    private Integer likeCount;
    @SerializedName("read_count")
    @Expose
    private Integer readCount;
    @SerializedName("is_like")
    @Expose
    private Boolean isLike;
    @SerializedName("is_read")
    @Expose
    private Boolean isRead;
    @SerializedName("comment_count")
    @Expose
    private Integer commentCount;
    @Expose
    private Integer id;
    @Expose
    private String uid;
    @Expose
    private String title;
    @Expose
    private String creationDate;
    @Expose
    private String brand;
    @Expose
    private String store;
    @Expose
    private Integer category;
    @Expose
    private Integer subcategory;
    @Expose
    private String weblink;
    @Expose
    private String celebrity;
    @SerializedName("disc_main")
    @Expose
    private String discMain;
    @SerializedName("coupon_main")
    @Expose
    private String couponMain;
    @Expose
    private String instruction1;
    @Expose
    private String instruction2;
    @Expose
    private String instruction3;
    @SerializedName("disc_ship")
    @Expose
    private String discShip;
    @SerializedName("coupon_ship")
    @Expose
    private String couponShip;
    @SerializedName("instr_special")
    @Expose
    private String instrSpecial;
    @Expose
    private String duration;
    @Expose
    private Object startDate;
    @Expose
    private String endDate;
    @Expose
    private String tip;

    /**
     *
     * @return
     * The recommendations
     */
    public List<Object> getRecommendations() {
        return recommendations;
    }

    /**
     *
     * @param recommendations
     * The recommendations
     */
    public void setRecommendations(List<Object> recommendations) {
        this.recommendations = recommendations;
    }

    /**
     *
     * @return
     * The publisher
     */
    public Publisher getPublisher() {
        return publisher;
    }

    /**
     *
     * @param publisher
     * The publisher
     */
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

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
     * The likeCount
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     *
     * @param likeCount
     * The like_count
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     *
     * @return
     * The readCount
     */
    public Integer getReadCount() {
        return readCount;
    }

    /**
     *
     * @param readCount
     * The read_count
     */
    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    /**
     *
     * @return
     * The isLike
     */
    public Boolean getIsLike() {
        return isLike;
    }

    /**
     *
     * @param isLike
     * The is_like
     */
    public void setIsLike(Boolean isLike) {
        this.isLike = isLike;
    }

    /**
     *
     * @return
     * The isRead
     */
    public Boolean getIsRead() {
        return isRead;
    }

    /**
     *
     * @param isRead
     * The is_read
     */
    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    /**
     *
     * @return
     * The commentCount
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     *
     * @param commentCount
     * The comment_count
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

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
     * The creationDate
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     *
     * @param creationDate
     * The creationDate
     */
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     *
     * @return
     * The brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     *
     * @param brand
     * The brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     *
     * @return
     * The store
     */
    public String getStore() {
        return store;
    }

    /**
     *
     * @param store
     * The store
     */
    public void setStore(String store) {
        this.store = store;
    }

    /**
     *
     * @return
     * The category
     */
    public Integer getCategory() {
        return category;
    }

    /**
     *
     * @param category
     * The category
     */
    public void setCategory(Integer category) {
        this.category = category;
    }

    /**
     *
     * @return
     * The subcategory
     */
    public Integer getSubcategory() {
        return subcategory;
    }

    /**
     *
     * @param subcategory
     * The subcategory
     */
    public void setSubcategory(Integer subcategory) {
        this.subcategory = subcategory;
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

    /**
     *
     * @return
     * The celebrity
     */
    public String getCelebrity() {
        return celebrity;
    }

    /**
     *
     * @param celebrity
     * The celebrity
     */
    public void setCelebrity(String celebrity) {
        this.celebrity = celebrity;
    }

    /**
     *
     * @return
     * The discMain
     */
    public String getDiscMain() {
        return discMain;
    }

    /**
     *
     * @param discMain
     * The disc_main
     */
    public void setDiscMain(String discMain) {
        this.discMain = discMain;
    }

    /**
     *
     * @return
     * The couponMain
     */
    public String getCouponMain() {
        return couponMain;
    }

    /**
     *
     * @param couponMain
     * The coupon_main
     */
    public void setCouponMain(String couponMain) {
        this.couponMain = couponMain;
    }

    /**
     *
     * @return
     * The instruction1
     */
    public String getInstruction1() {
        return instruction1;
    }

    /**
     *
     * @param instruction1
     * The instruction1
     */
    public void setInstruction1(String instruction1) {
        this.instruction1 = instruction1;
    }

    /**
     *
     * @return
     * The instruction2
     */
    public String getInstruction2() {
        return instruction2;
    }

    /**
     *
     * @param instruction2
     * The instruction2
     */
    public void setInstruction2(String instruction2) {
        this.instruction2 = instruction2;
    }

    /**
     *
     * @return
     * The instruction3
     */
    public String getInstruction3() {
        return instruction3;
    }

    /**
     *
     * @param instruction3
     * The instruction3
     */
    public void setInstruction3(String instruction3) {
        this.instruction3 = instruction3;
    }

    /**
     *
     * @return
     * The discShip
     */
    public String getDiscShip() {
        return discShip;
    }

    /**
     *
     * @param discShip
     * The disc_ship
     */
    public void setDiscShip(String discShip) {
        this.discShip = discShip;
    }

    /**
     *
     * @return
     * The couponShip
     */
    public String getCouponShip() {
        return couponShip;
    }

    /**
     *
     * @param couponShip
     * The coupon_ship
     */
    public void setCouponShip(String couponShip) {
        this.couponShip = couponShip;
    }

    /**
     *
     * @return
     * The instrSpecial
     */
    public String getInstrSpecial() {
        return instrSpecial;
    }

    /**
     *
     * @param instrSpecial
     * The instr_special
     */
    public void setInstrSpecial(String instrSpecial) {
        this.instrSpecial = instrSpecial;
    }

    /**
     *
     * @return
     * The duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     *
     * @param duration
     * The duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     *
     * @return
     * The startDate
     */
    public Object getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate
     * The startDate
     */
    public void setStartDate(Object startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @return
     * The endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     *
     * @param endDate
     * The endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     *
     * @return
     * The tip
     */
    public String getTip() {
        return tip;
    }

    /**
     *
     * @param tip
     * The tip
     */
    public void setTip(String tip) {
        this.tip = tip;
    }

}
