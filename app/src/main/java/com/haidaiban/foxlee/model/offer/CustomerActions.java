package com.haidaiban.foxlee.model.offer;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class CustomerActions {

    @SerializedName("next_state")
    @Expose
    private NextState nextState;
    @Expose
    private String description;
    @Expose
    private String name;
    @Expose
    private List<Parameter> parameters = new ArrayList<Parameter>();

    /**
     *
     * @return
     * The nextState
     */
    public NextState getNextState() {
        return nextState;
    }

    /**
     *
     * @param nextState
     * The next_state
     */
    public void setNextState(NextState nextState) {
        this.nextState = nextState;
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

    /**
     *
     * @return
     * The parameters
     */
    public List<Parameter> getParameters() {
        return parameters;
    }

    /**
     *
     * @param parameters
     * The parameters
     */
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

}
