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
public class TransactionState {

    @SerializedName("flow_type")
    @Expose
    private String flowType;
    @Expose
    private String state;
    @SerializedName("agent_actions")
    @Expose
    private List<Object> agentActions = new ArrayList<Object>();
    @SerializedName("customer_actions")
    @Expose
    private List<CustomerAction> customerActions = new ArrayList<CustomerAction>();

    /**
     *
     * @return
     * The flowType
     */
    public String getFlowType() {
        return flowType;
    }

    /**
     *
     * @param flowType
     * The flow_type
     */
    public void setFlowType(String flowType) {
        this.flowType = flowType;
    }

    /**
     *
     * @return
     * The state
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     * The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     * The agentActions
     */
    public List<Object> getAgentActions() {
        return agentActions;
    }

    /**
     *
     * @param agentActions
     * The agent_actions
     */
    public void setAgentActions(List<Object> agentActions) {
        this.agentActions = agentActions;
    }

    /**
     *
     * @return
     * The customerActions
     */
    public List<CustomerAction> getCustomerActions() {
        return customerActions;
    }

    /**
     *
     * @param customerActions
     * The customer_actions
     */
    public void setCustomerActions(List<CustomerAction> customerActions) {
        this.customerActions = customerActions;
    }

}
