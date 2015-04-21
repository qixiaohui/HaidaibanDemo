package com.haidaiban.foxlee.model.offer;

import java.util.List;

import javax.annotation.Generated;

/**
 * Created by tom on 4/11/15.
 */
@Generated("org.jsonschema2pojo")
public class AgentActions {
    private String description;
    private List<Parameters> parameterses;
    private List<NextState> nextStates;
    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Parameters> getParameterses() {
        return parameterses;
    }

    public void setParameterses(List<Parameters> parameterses) {
        this.parameterses = parameterses;
    }

    public List<NextState> getNextStates() {
        return nextStates;
    }

    public void setNextStates(List<NextState> nextStates) {
        this.nextStates = nextStates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
