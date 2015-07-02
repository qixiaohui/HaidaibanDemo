package com.haidaiban.foxlee.model.acceptedoffer;

/**
 * Created by qixiaohui on 7/2/15.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class NextState {

    @Expose
    private String flow;
    @Expose
    private String name;
    @Expose
    private String description;

    /**
     *
     * @return
     * The flow
     */
    public String getFlow() {
        return flow;
    }

    /**
     *
     * @param flow
     * The flow
     */
    public void setFlow(String flow) {
        this.flow = flow;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
