package com.haidaiban.foxlee.model.offer;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class CustomerAction {

    @SerializedName("next_state")
    @Expose
    private NextState_ nextState;
    @Expose
    private String description;
    @Expose
    private String name;
    @Expose
    private List<Parameter_> parameters = new ArrayList<Parameter_>();

    /**
     *
     * @return
     * The nextState
     */
    public NextState_ getNextState() {
        return nextState;
    }

    /**
     *
     * @param nextState
     * The next_state
     */
    public void setNextState(NextState_ nextState) {
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
    public List<Parameter_> getParameters() {
        return parameters;
    }

    /**
     *
     * @param parameters
     * The parameters
     */
    public void setParameters(List<Parameter_> parameters) {
        this.parameters = parameters;
    }

}
