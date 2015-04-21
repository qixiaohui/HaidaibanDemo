package com.haidaiban.foxlee.model.offer;

/**
 * Created by qixiaohui on 3/12/15.
 */

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class TransactionState {
    private String 定金金额;
    @Expose
    private List<CustomerActions> customerActions = new ArrayList<CustomerActions>();
    private String 交易编号;
    private List<AgentActions> agentActions = new ArrayList<AgentActions>();
    private String state;
    private String flowType;
    private String stateDescription;

    public String get定金金额() {
        return 定金金额;
    }

    public void set定金金额(String 定金金额) {
        this.定金金额 = 定金金额;
    }

    public List<CustomerActions> getCustomerActions() {
        return customerActions;
    }

    public void setCustomerActions(List<CustomerActions> customerActions) {
        this.customerActions = customerActions;
    }

    public String get交易编号() {
        return 交易编号;
    }

    public void set交易编号(String 交易编号) {
        this.交易编号 = 交易编号;
    }

    public List<AgentActions> getAgentActions() {
        return agentActions;
    }

    public void setAgentActions(List<AgentActions> agentActions) {
        this.agentActions = agentActions;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType;
    }

    public String getStateDescription() {
        return stateDescription;
    }

    public void setStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
    }
}
