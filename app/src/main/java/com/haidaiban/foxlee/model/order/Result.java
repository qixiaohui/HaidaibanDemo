package com.haidaiban.foxlee.model.order;

/**
 * Created by qixiaohui on 4/5/15.
 */
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Result {

    @SerializedName("preferred_agent")
    @Expose
    private Object preferredAgent;
    @Expose
    private List<Quote> quotes = new ArrayList<Quote>();
    @SerializedName("distribute_date")
    @Expose
    private Object distributeDate;
    @Expose
    private String uid;
    @Expose
    private Customer customer;
    @Expose
    private String title;
    @SerializedName("last_update")
    @Expose
    private String lastUpdate;
    @SerializedName("submit_date")
    @Expose
    private String submitDate;
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
    private String lastActivityDate;
    @Expose
    private String remark;
    @SerializedName("is_system_closed")
    @Expose
    private Boolean isSystemClosed;
    @SerializedName("close_task_eta")
    @Expose
    private Object closeTaskEta;
    @SerializedName("open_offers")
    @Expose
    private List<OpenOffer> openOffers = new ArrayList<OpenOffer>();

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
     * The quotes
     */
    public List<Quote> getQuotes() {
        return quotes;
    }

    /**
     *
     * @param quotes
     * The quotes
     */
    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    /**
     *
     * @return
     * The distributeDate
     */
    public Object getDistributeDate() {
        return distributeDate;
    }

    /**
     *
     * @param distributeDate
     * The distribute_date
     */
    public void setDistributeDate(Object distributeDate) {
        this.distributeDate = distributeDate;
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
     * The customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     *
     * @param customer
     * The customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
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
    public String getSubmitDate() {
        return submitDate;
    }

    /**
     *
     * @param submitDate
     * The submit_date
     */
    public void setSubmitDate(String submitDate) {
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
    public String getLastActivityDate() {
        return lastActivityDate;
    }

    /**
     *
     * @param lastActivityDate
     * The last_activity_date
     */
    public void setLastActivityDate(String lastActivityDate) {
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

    /**
     *
     * @return
     * The isSystemClosed
     */
    public Boolean getIsSystemClosed() {
        return isSystemClosed;
    }

    /**
     *
     * @param isSystemClosed
     * The is_system_closed
     */
    public void setIsSystemClosed(Boolean isSystemClosed) {
        this.isSystemClosed = isSystemClosed;
    }

    /**
     *
     * @return
     * The closeTaskEta
     */
    public Object getCloseTaskEta() {
        return closeTaskEta;
    }

    /**
     *
     * @param closeTaskEta
     * The close_task_eta
     */
    public void setCloseTaskEta(Object closeTaskEta) {
        this.closeTaskEta = closeTaskEta;
    }

    /**
     *
     * @return
     * The openOffers
     */
    public List<OpenOffer> getOpenOffers() {
        return openOffers;
    }

    /**
     *
     * @param openOffers
     * The open_offers
     */
    public void setOpenOffers(List<OpenOffer> openOffers) {
        this.openOffers = openOffers;
    }

}
