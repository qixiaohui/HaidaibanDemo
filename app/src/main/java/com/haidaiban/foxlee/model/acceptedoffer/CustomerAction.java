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
public class CustomerAction {

    @Expose
    private List<Object> parameters = new ArrayList<Object>();
    @Expose
    private String name;
    @Expose
    private String description;
    @SerializedName("next_state")
    @Expose
    private NextState nextState;

    /**
     *
     * @return
     * The parameters
     */
    public List<Object> getParameters() {
        return parameters;
    }

    /**
     *
     * @param parameters
     * The parameters
     */
    public void setParameters(List<Object> parameters) {
        this.parameters = parameters;
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

}
