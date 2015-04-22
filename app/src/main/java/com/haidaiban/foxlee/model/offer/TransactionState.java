package com.haidaiban.foxlee.model.offer;

/**
 * Created by qixiaohui on 3/12/15.
 */

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class TransactionState {

    @SerializedName("agent_actions")
    @Expose
    private List<AgentAction> agentActions = new ArrayList<AgentAction>();
    @SerializedName("flow_type")
    @Expose
    private String flowType;
    @SerializedName("state_description")
    @Expose
    private String stateDescription;
    @SerializedName("customer_actions")
    @Expose
    private List<CustomerAction> customerActions = new ArrayList<CustomerAction>();
    @Expose
    private String state;
    private String 定金金额;
    private String 交易编号;

    public String get定金金额() {
        return 定金金额;
    }

    public void set定金金额(String 定金金额) {
        this.定金金额 = 定金金额;
    }

    public String get交易编号() {
        return 交易编号;
    }

    public void set交易编号(String 交易编号) {
        this.交易编号 = 交易编号;
    }

    /**
     *
     * @return
     * The agentActions
     */
    public List<AgentAction> getAgentActions() {
        return agentActions;
    }

    /**
     *
     * @param agentActions
     * The agent_actions
     */
    public void setAgentActions(List<AgentAction> agentActions) {
        this.agentActions = agentActions;
    }

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
     * The stateDescription
     */
    public String getStateDescription() {
        return stateDescription;
    }

    /**
     *
     * @param stateDescription
     * The state_description
     */
    public void setStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
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

}
