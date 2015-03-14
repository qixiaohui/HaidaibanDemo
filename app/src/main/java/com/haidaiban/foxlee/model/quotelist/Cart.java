package com.haidaiban.foxlee.model.quotelist;

/**
 * Created by qixiaohui on 3/13/15.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Cart {

    @SerializedName("preferred_agent")
    @Expose
    private Object preferredAgent;
    @Expose
    private String uid;
    @Expose
    private String title;
    @SerializedName("last_update")
    @Expose
    private String lastUpdate;
    @SerializedName("submit_date")
    @Expose
    private Object submitDate;
    @SerializedName("is_submitted")
    @Expose
    private Boolean isSubmitted;
    @SerializedName("is_open")
    @Expose
    private Boolean isOpen;
    @SerializedName("redistribute_count")
    @Expose
    private Integer redistributeCount;
    @SerializedName("accept_count")
    @Expose
    private Integer acceptCount;
    @SerializedName("has_agent_activity")
    @Expose
    private Boolean hasAgentActivity;
    @SerializedName("has_customer_activity")
    @Expose
    private Boolean hasCustomerActivity;
    @SerializedName("last_activity_date")
    @Expose
    private Object lastActivityDate;
    @Expose
    private String remark;

    /**
     *
     * @return
     * The preferredAgent
     */
    public Object getPreferredAgent() {
        return preferredAgent;
    }

    /**
     *
     * @param preferredAgent
     * The preferred_agent
     */
    public void setPreferredAgent(Object preferredAgent) {
        this.preferredAgent = preferredAgent;
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
     * The submitDate
     */
    public Object getSubmitDate() {
        return submitDate;
    }

    /**
     *
     * @param submitDate
     * The submit_date
     */
    public void setSubmitDate(Object submitDate) {
        this.submitDate = submitDate;
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
     * The isOpen
     */
    public Boolean getIsOpen() {
        return isOpen;
    }

    /**
     *
     * @param isOpen
     * The is_open
     */
    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    /**
     *
     * @return
     * The redistributeCount
     */
    public Integer getRedistributeCount() {
        return redistributeCount;
    }

    /**
     *
     * @param redistributeCount
     * The redistribute_count
     */
    public void setRedistributeCount(Integer redistributeCount) {
        this.redistributeCount = redistributeCount;
    }

    /**
     *
     * @return
     * The acceptCount
     */
    public Integer getAcceptCount() {
        return acceptCount;
    }

    /**
     *
     * @param acceptCount
     * The accept_count
     */
    public void setAcceptCount(Integer acceptCount) {
        this.acceptCount = acceptCount;
    }

    /**
     *
     * @return
     * The hasAgentActivity
     */
    public Boolean getHasAgentActivity() {
        return hasAgentActivity;
    }

    /**
     *
     * @param hasAgentActivity
     * The has_agent_activity
     */
    public void setHasAgentActivity(Boolean hasAgentActivity) {
        this.hasAgentActivity = hasAgentActivity;
    }

    /**
     *
     * @return
     * The hasCustomerActivity
     */
    public Boolean getHasCustomerActivity() {
        return hasCustomerActivity;
    }

    /**
     *
     * @param hasCustomerActivity
     * The has_customer_activity
     */
    public void setHasCustomerActivity(Boolean hasCustomerActivity) {
        this.hasCustomerActivity = hasCustomerActivity;
    }

    /**
     *
     * @return
     * The lastActivityDate
     */
    public Object getLastActivityDate() {
        return lastActivityDate;
    }

    /**
     *
     * @param lastActivityDate
     * The last_activity_date
     */
    public void setLastActivityDate(Object lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
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

}
