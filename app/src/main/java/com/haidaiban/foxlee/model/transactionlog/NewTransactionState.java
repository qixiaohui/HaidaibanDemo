package com.haidaiban.foxlee.model.transactionlog;

/**
 * Created by tom on 4/19/15.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class NewTransactionState {

    @SerializedName("flow_type")
    @Expose
    private String flowType;
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

}
