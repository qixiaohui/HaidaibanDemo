package com.haidaiban.foxlee.model.order;

/**
 * Created by tom on 6/28/15.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class AcceptedOffer {

    @Expose
    private String agent;
    @Expose
    private String uid;

    /**
     *
     * @return
     * The agent
     */
    public String getAgent() {
        return agent;
    }

    /**
     *
     * @param agent
     * The agent
     */
    public void setAgent(String agent) {
        this.agent = agent;
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

}
