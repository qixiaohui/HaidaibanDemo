package com.haidaiban.foxlee.model.offer;

/**
 * Created by tom on 4/21/15.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class NextState_ {

    @Expose
    private String flow;
    @Expose
    private String description;
    @Expose
    private String name;

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

}
