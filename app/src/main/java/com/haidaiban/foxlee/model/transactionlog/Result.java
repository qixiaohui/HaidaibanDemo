package com.haidaiban.foxlee.model.transactionlog;

/**
 * Created by tom on 4/19/15.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Result {

    @SerializedName("from_state")
    @Expose
    private String fromState;
    @SerializedName("is_customer")
    @Expose
    private Boolean isCustomer;
    @Expose
    private String action;
    @Expose
    private Parameters parameters;
    @SerializedName("new_transaction_state")
    @Expose
    private NewTransactionState newTransactionState;
    @Expose
    private String created;

    /**
     *
     * @return
     * The fromState
     */
    public String getFromState() {
        return fromState;
    }

    /**
     *
     * @param fromState
     * The from_state
     */
    public void setFromState(String fromState) {
        this.fromState = fromState;
    }

    /**
     *
     * @return
     * The isCustomer
     */
    public Boolean getIsCustomer() {
        return isCustomer;
    }

    /**
     *
     * @param isCustomer
     * The is_customer
     */
    public void setIsCustomer(Boolean isCustomer) {
        this.isCustomer = isCustomer;
    }

    /**
     *
     * @return
     * The action
     */
    public String getAction() {
        return action;
    }

    /**
     *
     * @param action
     * The action
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     *
     * @return
     * The parameters
     */
    public Parameters getParameters() {
        return parameters;
    }

    /**
     *
     * @param parameters
     * The parameters
     */
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    /**
     *
     * @return
     * The newTransactionState
     */
    public NewTransactionState getNewTransactionState() {
        return newTransactionState;
    }

    /**
     *
     * @param newTransactionState
     * The new_transaction_state
     */
    public void setNewTransactionState(NewTransactionState newTransactionState) {
        this.newTransactionState = newTransactionState;
    }

    /**
     *
     * @return
     * The created
     */
    public String getCreated() {
        return created;
    }

    /**
     *
     * @param created
     * The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

}
