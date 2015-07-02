package com.haidaiban.foxlee.model.acceptedoffer;

/**
 * Created by qixiaohui on 7/2/15.
 */
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AcceptedOffer {

    @Expose
    private String uid;
    @Expose
    private Agent agent;
    @Expose
    private Customer customer;
    @Expose
    private String order;
    @SerializedName("redistribute_count")
    @Expose
    private Integer redistributeCount;
    @SerializedName("offer_price")
    @Expose
    private String offerPrice;
    @SerializedName("price_adj")
    @Expose
    private String priceAdj;
    @SerializedName("down_payment")
    @Expose
    private String downPayment;
    @SerializedName("internal_pay")
    @Expose
    private Boolean internalPay;
    @SerializedName("external_pay")
    @Expose
    private Boolean externalPay;
    @SerializedName("payment_link")
    @Expose
    private String paymentLink;
    @SerializedName("ext_pay_desc")
    @Expose
    private String extPayDesc;
    @SerializedName("ext_pay_acct")
    @Expose
    private String extPayAcct;
    @SerializedName("agent_remark")
    @Expose
    private Object agentRemark;
    @SerializedName("common_remark")
    @Expose
    private Object commonRemark;
    @Expose
    private List<Counterquote> counterquotes = new ArrayList<Counterquote>();
    @Expose
    private String status;
    @SerializedName("customer_declined")
    @Expose
    private Boolean customerDeclined;
    @SerializedName("decline_message")
    @Expose
    private Object declineMessage;
    @SerializedName("create_date")
    @Expose
    private String createDate;
    @SerializedName("last_update")
    @Expose
    private String lastUpdate;
    @SerializedName("last_activity_date")
    @Expose
    private String lastActivityDate;
    @SerializedName("last_customer_activity_date")
    @Expose
    private String lastCustomerActivityDate;
    @SerializedName("last_agent_activity_date")
    @Expose
    private String lastAgentActivityDate;
    @SerializedName("has_agent_activity")
    @Expose
    private Boolean hasAgentActivity;
    @SerializedName("has_customer_activity")
    @Expose
    private Boolean hasCustomerActivity;
    @SerializedName("has_counter_quote_activity")
    @Expose
    private Boolean hasCounterQuoteActivity;
    @SerializedName("has_new_agent_msg")
    @Expose
    private Boolean hasNewAgentMsg;
    @SerializedName("has_new_customer_msg")
    @Expose
    private Boolean hasNewCustomerMsg;
    @SerializedName("has_new_price")
    @Expose
    private Boolean hasNewPrice;
    @SerializedName("transaction_state")
    @Expose
    private TransactionState transactionState;
    @SerializedName("shipping_address")
    @Expose
    private ShippingAddress shippingAddress;
    @SerializedName("is_content_locked")
    @Expose
    private Boolean isContentLocked;
    @SerializedName("is_preferred_agent")
    @Expose
    private Boolean isPreferredAgent;

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
     * The agent
     */
    public Agent getAgent() {
        return agent;
    }

    /**
     *
     * @param agent
     * The agent
     */
    public void setAgent(Agent agent) {
        this.agent = agent;
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
     * The offerPrice
     */
    public String getOfferPrice() {
        return offerPrice;
    }

    /**
     *
     * @param offerPrice
     * The offer_price
     */
    public void setOfferPrice(String offerPrice) {
        this.offerPrice = offerPrice;
    }

    /**
     *
     * @return
     * The priceAdj
     */
    public String getPriceAdj() {
        return priceAdj;
    }

    /**
     *
     * @param priceAdj
     * The price_adj
     */
    public void setPriceAdj(String priceAdj) {
        this.priceAdj = priceAdj;
    }

    /**
     *
     * @return
     * The downPayment
     */
    public String getDownPayment() {
        return downPayment;
    }

    /**
     *
     * @param downPayment
     * The down_payment
     */
    public void setDownPayment(String downPayment) {
        this.downPayment = downPayment;
    }

    /**
     *
     * @return
     * The internalPay
     */
    public Boolean getInternalPay() {
        return internalPay;
    }

    /**
     *
     * @param internalPay
     * The internal_pay
     */
    public void setInternalPay(Boolean internalPay) {
        this.internalPay = internalPay;
    }

    /**
     *
     * @return
     * The externalPay
     */
    public Boolean getExternalPay() {
        return externalPay;
    }

    /**
     *
     * @param externalPay
     * The external_pay
     */
    public void setExternalPay(Boolean externalPay) {
        this.externalPay = externalPay;
    }

    /**
     *
     * @return
     * The paymentLink
     */
    public String getPaymentLink() {
        return paymentLink;
    }

    /**
     *
     * @param paymentLink
     * The payment_link
     */
    public void setPaymentLink(String paymentLink) {
        this.paymentLink = paymentLink;
    }

    /**
     *
     * @return
     * The extPayDesc
     */
    public String getExtPayDesc() {
        return extPayDesc;
    }

    /**
     *
     * @param extPayDesc
     * The ext_pay_desc
     */
    public void setExtPayDesc(String extPayDesc) {
        this.extPayDesc = extPayDesc;
    }

    /**
     *
     * @return
     * The extPayAcct
     */
    public String getExtPayAcct() {
        return extPayAcct;
    }

    /**
     *
     * @param extPayAcct
     * The ext_pay_acct
     */
    public void setExtPayAcct(String extPayAcct) {
        this.extPayAcct = extPayAcct;
    }

    /**
     *
     * @return
     * The agentRemark
     */
    public Object getAgentRemark() {
        return agentRemark;
    }

    /**
     *
     * @param agentRemark
     * The agent_remark
     */
    public void setAgentRemark(Object agentRemark) {
        this.agentRemark = agentRemark;
    }

    /**
     *
     * @return
     * The commonRemark
     */
    public Object getCommonRemark() {
        return commonRemark;
    }

    /**
     *
     * @param commonRemark
     * The common_remark
     */
    public void setCommonRemark(Object commonRemark) {
        this.commonRemark = commonRemark;
    }

    /**
     *
     * @return
     * The counterquotes
     */
    public List<Counterquote> getCounterquotes() {
        return counterquotes;
    }

    /**
     *
     * @param counterquotes
     * The counterquotes
     */
    public void setCounterquotes(List<Counterquote> counterquotes) {
        this.counterquotes = counterquotes;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The customerDeclined
     */
    public Boolean getCustomerDeclined() {
        return customerDeclined;
    }

    /**
     *
     * @param customerDeclined
     * The customer_declined
     */
    public void setCustomerDeclined(Boolean customerDeclined) {
        this.customerDeclined = customerDeclined;
    }

    /**
     *
     * @return
     * The declineMessage
     */
    public Object getDeclineMessage() {
        return declineMessage;
    }

    /**
     *
     * @param declineMessage
     * The decline_message
     */
    public void setDeclineMessage(Object declineMessage) {
        this.declineMessage = declineMessage;
    }

    /**
     *
     * @return
     * The createDate
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     *
     * @param createDate
     * The create_date
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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
     * The lastCustomerActivityDate
     */
    public String getLastCustomerActivityDate() {
        return lastCustomerActivityDate;
    }

    /**
     *
     * @param lastCustomerActivityDate
     * The last_customer_activity_date
     */
    public void setLastCustomerActivityDate(String lastCustomerActivityDate) {
        this.lastCustomerActivityDate = lastCustomerActivityDate;
    }

    /**
     *
     * @return
     * The lastAgentActivityDate
     */
    public String getLastAgentActivityDate() {
        return lastAgentActivityDate;
    }

    /**
     *
     * @param lastAgentActivityDate
     * The last_agent_activity_date
     */
    public void setLastAgentActivityDate(String lastAgentActivityDate) {
        this.lastAgentActivityDate = lastAgentActivityDate;
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
     * The hasCounterQuoteActivity
     */
    public Boolean getHasCounterQuoteActivity() {
        return hasCounterQuoteActivity;
    }

    /**
     *
     * @param hasCounterQuoteActivity
     * The has_counter_quote_activity
     */
    public void setHasCounterQuoteActivity(Boolean hasCounterQuoteActivity) {
        this.hasCounterQuoteActivity = hasCounterQuoteActivity;
    }

    /**
     *
     * @return
     * The hasNewAgentMsg
     */
    public Boolean getHasNewAgentMsg() {
        return hasNewAgentMsg;
    }

    /**
     *
     * @param hasNewAgentMsg
     * The has_new_agent_msg
     */
    public void setHasNewAgentMsg(Boolean hasNewAgentMsg) {
        this.hasNewAgentMsg = hasNewAgentMsg;
    }

    /**
     *
     * @return
     * The hasNewCustomerMsg
     */
    public Boolean getHasNewCustomerMsg() {
        return hasNewCustomerMsg;
    }

    /**
     *
     * @param hasNewCustomerMsg
     * The has_new_customer_msg
     */
    public void setHasNewCustomerMsg(Boolean hasNewCustomerMsg) {
        this.hasNewCustomerMsg = hasNewCustomerMsg;
    }

    /**
     *
     * @return
     * The hasNewPrice
     */
    public Boolean getHasNewPrice() {
        return hasNewPrice;
    }

    /**
     *
     * @param hasNewPrice
     * The has_new_price
     */
    public void setHasNewPrice(Boolean hasNewPrice) {
        this.hasNewPrice = hasNewPrice;
    }

    /**
     *
     * @return
     * The transactionState
     */
    public TransactionState getTransactionState() {
        return transactionState;
    }

    /**
     *
     * @param transactionState
     * The transaction_state
     */
    public void setTransactionState(TransactionState transactionState) {
        this.transactionState = transactionState;
    }

    /**
     *
     * @return
     * The shippingAddress
     */
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    /**
     *
     * @param shippingAddress
     * The shipping_address
     */
    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     *
     * @return
     * The isContentLocked
     */
    public Boolean getIsContentLocked() {
        return isContentLocked;
    }

    /**
     *
     * @param isContentLocked
     * The is_content_locked
     */
    public void setIsContentLocked(Boolean isContentLocked) {
        this.isContentLocked = isContentLocked;
    }

    /**
     *
     * @return
     * The isPreferredAgent
     */
    public Boolean getIsPreferredAgent() {
        return isPreferredAgent;
    }

    /**
     *
     * @param isPreferredAgent
     * The is_preferred_agent
     */
    public void setIsPreferredAgent(Boolean isPreferredAgent) {
        this.isPreferredAgent = isPreferredAgent;
    }

}