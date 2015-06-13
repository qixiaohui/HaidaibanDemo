package com.haidaiban.foxlee.model.profile;

/**
 * Created by tom on 5/25/15.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class UserProfile {

    @Expose
    private User user;
    @SerializedName("account_type")
    @Expose
    private String accountType;
    @Expose
    private Country country;
    @Expose
    private State state;
    @Expose
    private City city;
    @Expose
    private String icon;
    @SerializedName("icon_thumb")
    @Expose
    private String iconThumb;
    @Expose
    private String qq;
    @Expose
    private String weixin;
    @Expose
    private String weibo;
    @Expose
    private String wangwang;
    @Expose
    private String residence;
    @SerializedName("comment_count")
    @Expose
    private Integer commentCount;
    @SerializedName("shipping_address1")
    @Expose
    private ShippingAddress1 shippingAddress1;
    @SerializedName("shipping_address2")
    @Expose
    private Object shippingAddress2;
    @SerializedName("shipping_address3")
    @Expose
    private Object shippingAddress3;
    @Expose
    private String uid;
    @Expose
    private String nickname;
    @Expose
    private String signature;
    @Expose
    private String gender;
    @SerializedName("street_address")
    @Expose
    private Object streetAddress;
    @Expose
    private Object zip;
    @Expose
    private Object cell;
    @Expose
    private Object referrer;
    @SerializedName("last_login")
    @Expose
    private Object lastLogin;
    @SerializedName("is_gender_public")
    @Expose
    private Boolean isGenderPublic;
    @SerializedName("is_email_public")
    @Expose
    private Boolean isEmailPublic;
    @SerializedName("is_qq_public")
    @Expose
    private Boolean isQqPublic;
    @SerializedName("is_weixin_public")
    @Expose
    private Boolean isWeixinPublic;
    @SerializedName("is_weibo_public")
    @Expose
    private Boolean isWeiboPublic;
    @SerializedName("is_wangwang_public")
    @Expose
    private Boolean isWangwangPublic;
    @SerializedName("notification_offer_activity_date")
    @Expose
    private String notificationOfferActivityDate;
    @SerializedName("has_new_offer_activity")
    @Expose
    private Boolean hasNewOfferActivity;
    @SerializedName("notification_deal_date")
    @Expose
    private String notificationDealDate;
    @SerializedName("notification_state_date")
    @Expose
    private String notificationStateDate;
    @SerializedName("notification_offer_activity_switch")
    @Expose
    private Boolean notificationOfferActivitySwitch;
    @SerializedName("notification_deal_switch")
    @Expose
    private Boolean notificationDealSwitch;
    @SerializedName("notification_state_switch")
    @Expose
    private Boolean notificationStateSwitch;
    @SerializedName("quote_count")
    @Expose
    private Integer quoteCount;
    @SerializedName("order_count")
    @Expose
    private Integer orderCount;
    @SerializedName("offer_count")
    @Expose
    private Integer offerCount;
    @SerializedName("offer_accept_count")
    @Expose
    private Integer offerAcceptCount;
    @SerializedName("transaction_complete_count")
    @Expose
    private Integer transactionCompleteCount;
    @SerializedName("showoff_count")
    @Expose
    private Integer showoffCount;
    @SerializedName("feedback_count")
    @Expose
    private Integer feedbackCount;
    @SerializedName("is_residence_public")
    @Expose
    private Boolean isResidencePublic;
    @SerializedName("agent_blacklist")
    @Expose
    private Object agentBlacklist;
    @SerializedName("notification_offer_date")
    @Expose
    private String notificationOfferDate;
    @SerializedName("notification_offer_switch")
    @Expose
    private Boolean notificationOfferSwitch;
    @SerializedName("default_shipping_address")
    @Expose
    private Integer defaultShippingAddress;
    @SerializedName("average_accept_rate")
    @Expose
    private Double averageAcceptRate;
    @SerializedName("average_complete_rate")
    @Expose
    private Double averageCompleteRate;
    @SerializedName("average_performance_index")
    @Expose
    private Integer averagePerformanceIndex;
    @SerializedName("total_offer_count")
    @Expose
    private Integer totalOfferCount;
    @SerializedName("total_offer_accept_count")
    @Expose
    private Integer totalOfferAcceptCount;
    @SerializedName("total_order_count")
    @Expose
    private Integer totalOrderCount;
    @SerializedName("total_quote_count")
    @Expose
    private Integer totalQuoteCount;
    @Expose
    private String timestamp;

    /**
     *
     * @return
     * The user
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     * The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     * The accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     *
     * @param accountType
     * The account_type
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     *
     * @return
     * The country
     */
    public Object getCountry() {
        return country;
    }

    /**
     *
     * @param country
     * The country
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     *
     * @return
     * The state
     */
    public Object getState() {
        return state;
    }

    /**
     *
     * @param state
     * The state
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     *
     * @return
     * The city
     */
    public Object getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    public void setCity(City city) {
        this.city = city;
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
     * The iconThumb
     */
    public String getIconThumb() {
        return iconThumb;
    }

    /**
     *
     * @param iconThumb
     * The icon_thumb
     */
    public void setIconThumb(String iconThumb) {
        this.iconThumb = iconThumb;
    }

    /**
     *
     * @return
     * The qq
     */
    public String getQq() {
        return qq;
    }

    /**
     *
     * @param qq
     * The qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     *
     * @return
     * The weixin
     */
    public String getWeixin() {
        return weixin;
    }

    /**
     *
     * @param weixin
     * The weixin
     */
    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    /**
     *
     * @return
     * The weibo
     */
    public String getWeibo() {
        return weibo;
    }

    /**
     *
     * @param weibo
     * The weibo
     */
    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    /**
     *
     * @return
     * The wangwang
     */
    public String getWangwang() {
        return wangwang;
    }

    /**
     *
     * @param wangwang
     * The wangwang
     */
    public void setWangwang(String wangwang) {
        this.wangwang = wangwang;
    }

    /**
     *
     * @return
     * The residence
     */
    public String getResidence() {
        return residence;
    }

    /**
     *
     * @param residence
     * The residence
     */
    public void setResidence(String residence) {
        this.residence = residence;
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
     * The shippingAddress1
     */
    public ShippingAddress1 getShippingAddress1() {
        return shippingAddress1;
    }

    /**
     *
     * @param shippingAddress1
     * The shipping_address1
     */
    public void setShippingAddress1(ShippingAddress1 shippingAddress1) {
        this.shippingAddress1 = shippingAddress1;
    }

    /**
     *
     * @return
     * The shippingAddress2
     */
    public Object getShippingAddress2() {
        return shippingAddress2;
    }

    /**
     *
     * @param shippingAddress2
     * The shipping_address2
     */
    public void setShippingAddress2(Object shippingAddress2) {
        this.shippingAddress2 = shippingAddress2;
    }

    /**
     *
     * @return
     * The shippingAddress3
     */
    public Object getShippingAddress3() {
        return shippingAddress3;
    }

    /**
     *
     * @param shippingAddress3
     * The shipping_address3
     */
    public void setShippingAddress3(Object shippingAddress3) {
        this.shippingAddress3 = shippingAddress3;
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
     * The nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     *
     * @param nickname
     * The nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     *
     * @return
     * The signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     *
     * @param signature
     * The signature
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     *
     * @return
     * The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     * The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     * The streetAddress
     */
    public Object getStreetAddress() {
        return streetAddress;
    }

    /**
     *
     * @param streetAddress
     * The street_address
     */
    public void setStreetAddress(Object streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     *
     * @return
     * The zip
     */
    public Object getZip() {
        return zip;
    }

    /**
     *
     * @param zip
     * The zip
     */
    public void setZip(Object zip) {
        this.zip = zip;
    }

    /**
     *
     * @return
     * The cell
     */
    public Object getCell() {
        return cell;
    }

    /**
     *
     * @param cell
     * The cell
     */
    public void setCell(Object cell) {
        this.cell = cell;
    }

    /**
     *
     * @return
     * The referrer
     */
    public Object getReferrer() {
        return referrer;
    }

    /**
     *
     * @param referrer
     * The referrer
     */
    public void setReferrer(Object referrer) {
        this.referrer = referrer;
    }

    /**
     *
     * @return
     * The lastLogin
     */
    public Object getLastLogin() {
        return lastLogin;
    }

    /**
     *
     * @param lastLogin
     * The last_login
     */
    public void setLastLogin(Object lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     *
     * @return
     * The isGenderPublic
     */
    public Boolean getIsGenderPublic() {
        return isGenderPublic;
    }

    /**
     *
     * @param isGenderPublic
     * The is_gender_public
     */
    public void setIsGenderPublic(Boolean isGenderPublic) {
        this.isGenderPublic = isGenderPublic;
    }

    /**
     *
     * @return
     * The isEmailPublic
     */
    public Boolean getIsEmailPublic() {
        return isEmailPublic;
    }

    /**
     *
     * @param isEmailPublic
     * The is_email_public
     */
    public void setIsEmailPublic(Boolean isEmailPublic) {
        this.isEmailPublic = isEmailPublic;
    }

    /**
     *
     * @return
     * The isQqPublic
     */
    public Boolean getIsQqPublic() {
        return isQqPublic;
    }

    /**
     *
     * @param isQqPublic
     * The is_qq_public
     */
    public void setIsQqPublic(Boolean isQqPublic) {
        this.isQqPublic = isQqPublic;
    }

    /**
     *
     * @return
     * The isWeixinPublic
     */
    public Boolean getIsWeixinPublic() {
        return isWeixinPublic;
    }

    /**
     *
     * @param isWeixinPublic
     * The is_weixin_public
     */
    public void setIsWeixinPublic(Boolean isWeixinPublic) {
        this.isWeixinPublic = isWeixinPublic;
    }

    /**
     *
     * @return
     * The isWeiboPublic
     */
    public Boolean getIsWeiboPublic() {
        return isWeiboPublic;
    }

    /**
     *
     * @param isWeiboPublic
     * The is_weibo_public
     */
    public void setIsWeiboPublic(Boolean isWeiboPublic) {
        this.isWeiboPublic = isWeiboPublic;
    }

    /**
     *
     * @return
     * The isWangwangPublic
     */
    public Boolean getIsWangwangPublic() {
        return isWangwangPublic;
    }

    /**
     *
     * @param isWangwangPublic
     * The is_wangwang_public
     */
    public void setIsWangwangPublic(Boolean isWangwangPublic) {
        this.isWangwangPublic = isWangwangPublic;
    }

    /**
     *
     * @return
     * The notificationOfferActivityDate
     */
    public String getNotificationOfferActivityDate() {
        return notificationOfferActivityDate;
    }

    /**
     *
     * @param notificationOfferActivityDate
     * The notification_offer_activity_date
     */
    public void setNotificationOfferActivityDate(String notificationOfferActivityDate) {
        this.notificationOfferActivityDate = notificationOfferActivityDate;
    }

    /**
     *
     * @return
     * The hasNewOfferActivity
     */
    public Boolean getHasNewOfferActivity() {
        return hasNewOfferActivity;
    }

    /**
     *
     * @param hasNewOfferActivity
     * The has_new_offer_activity
     */
    public void setHasNewOfferActivity(Boolean hasNewOfferActivity) {
        this.hasNewOfferActivity = hasNewOfferActivity;
    }

    /**
     *
     * @return
     * The notificationDealDate
     */
    public String getNotificationDealDate() {
        return notificationDealDate;
    }

    /**
     *
     * @param notificationDealDate
     * The notification_deal_date
     */
    public void setNotificationDealDate(String notificationDealDate) {
        this.notificationDealDate = notificationDealDate;
    }

    /**
     *
     * @return
     * The notificationStateDate
     */
    public String getNotificationStateDate() {
        return notificationStateDate;
    }

    /**
     *
     * @param notificationStateDate
     * The notification_state_date
     */
    public void setNotificationStateDate(String notificationStateDate) {
        this.notificationStateDate = notificationStateDate;
    }

    /**
     *
     * @return
     * The notificationOfferActivitySwitch
     */
    public Boolean getNotificationOfferActivitySwitch() {
        return notificationOfferActivitySwitch;
    }

    /**
     *
     * @param notificationOfferActivitySwitch
     * The notification_offer_activity_switch
     */
    public void setNotificationOfferActivitySwitch(Boolean notificationOfferActivitySwitch) {
        this.notificationOfferActivitySwitch = notificationOfferActivitySwitch;
    }

    /**
     *
     * @return
     * The notificationDealSwitch
     */
    public Boolean getNotificationDealSwitch() {
        return notificationDealSwitch;
    }

    /**
     *
     * @param notificationDealSwitch
     * The notification_deal_switch
     */
    public void setNotificationDealSwitch(Boolean notificationDealSwitch) {
        this.notificationDealSwitch = notificationDealSwitch;
    }

    /**
     *
     * @return
     * The notificationStateSwitch
     */
    public Boolean getNotificationStateSwitch() {
        return notificationStateSwitch;
    }

    /**
     *
     * @param notificationStateSwitch
     * The notification_state_switch
     */
    public void setNotificationStateSwitch(Boolean notificationStateSwitch) {
        this.notificationStateSwitch = notificationStateSwitch;
    }

    /**
     *
     * @return
     * The quoteCount
     */
    public Integer getQuoteCount() {
        return quoteCount;
    }

    /**
     *
     * @param quoteCount
     * The quote_count
     */
    public void setQuoteCount(Integer quoteCount) {
        this.quoteCount = quoteCount;
    }

    /**
     *
     * @return
     * The orderCount
     */
    public Integer getOrderCount() {
        return orderCount;
    }

    /**
     *
     * @param orderCount
     * The order_count
     */
    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    /**
     *
     * @return
     * The offerCount
     */
    public Integer getOfferCount() {
        return offerCount;
    }

    /**
     *
     * @param offerCount
     * The offer_count
     */
    public void setOfferCount(Integer offerCount) {
        this.offerCount = offerCount;
    }

    /**
     *
     * @return
     * The offerAcceptCount
     */
    public Integer getOfferAcceptCount() {
        return offerAcceptCount;
    }

    /**
     *
     * @param offerAcceptCount
     * The offer_accept_count
     */
    public void setOfferAcceptCount(Integer offerAcceptCount) {
        this.offerAcceptCount = offerAcceptCount;
    }

    /**
     *
     * @return
     * The transactionCompleteCount
     */
    public Integer getTransactionCompleteCount() {
        return transactionCompleteCount;
    }

    /**
     *
     * @param transactionCompleteCount
     * The transaction_complete_count
     */
    public void setTransactionCompleteCount(Integer transactionCompleteCount) {
        this.transactionCompleteCount = transactionCompleteCount;
    }

    /**
     *
     * @return
     * The showoffCount
     */
    public Integer getShowoffCount() {
        return showoffCount;
    }

    /**
     *
     * @param showoffCount
     * The showoff_count
     */
    public void setShowoffCount(Integer showoffCount) {
        this.showoffCount = showoffCount;
    }

    /**
     *
     * @return
     * The feedbackCount
     */
    public Integer getFeedbackCount() {
        return feedbackCount;
    }

    /**
     *
     * @param feedbackCount
     * The feedback_count
     */
    public void setFeedbackCount(Integer feedbackCount) {
        this.feedbackCount = feedbackCount;
    }

    /**
     *
     * @return
     * The isResidencePublic
     */
    public Boolean getIsResidencePublic() {
        return isResidencePublic;
    }

    /**
     *
     * @param isResidencePublic
     * The is_residence_public
     */
    public void setIsResidencePublic(Boolean isResidencePublic) {
        this.isResidencePublic = isResidencePublic;
    }

    /**
     *
     * @return
     * The agentBlacklist
     */
    public Object getAgentBlacklist() {
        return agentBlacklist;
    }

    /**
     *
     * @param agentBlacklist
     * The agent_blacklist
     */
    public void setAgentBlacklist(Object agentBlacklist) {
        this.agentBlacklist = agentBlacklist;
    }

    /**
     *
     * @return
     * The notificationOfferDate
     */
    public String getNotificationOfferDate() {
        return notificationOfferDate;
    }

    /**
     *
     * @param notificationOfferDate
     * The notification_offer_date
     */
    public void setNotificationOfferDate(String notificationOfferDate) {
        this.notificationOfferDate = notificationOfferDate;
    }

    /**
     *
     * @return
     * The notificationOfferSwitch
     */
    public Boolean getNotificationOfferSwitch() {
        return notificationOfferSwitch;
    }

    /**
     *
     * @param notificationOfferSwitch
     * The notification_offer_switch
     */
    public void setNotificationOfferSwitch(Boolean notificationOfferSwitch) {
        this.notificationOfferSwitch = notificationOfferSwitch;
    }

    /**
     *
     * @return
     * The defaultShippingAddress
     */
    public Integer getDefaultShippingAddress() {
        return defaultShippingAddress;
    }

    /**
     *
     * @param defaultShippingAddress
     * The default_shipping_address
     */
    public void setDefaultShippingAddress(Integer defaultShippingAddress) {
        this.defaultShippingAddress = defaultShippingAddress;
    }

    /**
     *
     * @return
     * The averageAcceptRate
     */
    public Double getAverageAcceptRate() {
        return averageAcceptRate;
    }

    /**
     *
     * @param averageAcceptRate
     * The average_accept_rate
     */
    public void setAverageAcceptRate(Double averageAcceptRate) {
        this.averageAcceptRate = averageAcceptRate;
    }

    /**
     *
     * @return
     * The averageCompleteRate
     */
    public Double getAverageCompleteRate() {
        return averageCompleteRate;
    }

    /**
     *
     * @param averageCompleteRate
     * The average_complete_rate
     */
    public void setAverageCompleteRate(Double averageCompleteRate) {
        this.averageCompleteRate = averageCompleteRate;
    }

    /**
     *
     * @return
     * The averagePerformanceIndex
     */
    public Integer getAveragePerformanceIndex() {
        return averagePerformanceIndex;
    }

    /**
     *
     * @param averagePerformanceIndex
     * The average_performance_index
     */
    public void setAveragePerformanceIndex(Integer averagePerformanceIndex) {
        this.averagePerformanceIndex = averagePerformanceIndex;
    }

    /**
     *
     * @return
     * The totalOfferCount
     */
    public Integer getTotalOfferCount() {
        return totalOfferCount;
    }

    /**
     *
     * @param totalOfferCount
     * The total_offer_count
     */
    public void setTotalOfferCount(Integer totalOfferCount) {
        this.totalOfferCount = totalOfferCount;
    }

    /**
     *
     * @return
     * The totalOfferAcceptCount
     */
    public Integer getTotalOfferAcceptCount() {
        return totalOfferAcceptCount;
    }

    /**
     *
     * @param totalOfferAcceptCount
     * The total_offer_accept_count
     */
    public void setTotalOfferAcceptCount(Integer totalOfferAcceptCount) {
        this.totalOfferAcceptCount = totalOfferAcceptCount;
    }

    /**
     *
     * @return
     * The totalOrderCount
     */
    public Integer getTotalOrderCount() {
        return totalOrderCount;
    }

    /**
     *
     * @param totalOrderCount
     * The total_order_count
     */
    public void setTotalOrderCount(Integer totalOrderCount) {
        this.totalOrderCount = totalOrderCount;
    }

    /**
     *
     * @return
     * The totalQuoteCount
     */
    public Integer getTotalQuoteCount() {
        return totalQuoteCount;
    }

    /**
     *
     * @param totalQuoteCount
     * The total_quote_count
     */
    public void setTotalQuoteCount(Integer totalQuoteCount) {
        this.totalQuoteCount = totalQuoteCount;
    }

    /**
     *
     * @return
     * The timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     *
     * @param timestamp
     * The timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
