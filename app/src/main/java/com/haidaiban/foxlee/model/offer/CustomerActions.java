package com.haidaiban.foxlee.model.offer;

import android.hardware.Camera;

import java.util.List;

/**
 * Created by tom on 4/11/15.
 */
public class CustomerActions {
    private String description;
    private List<Parameters> parameters;
    private String name;
    private NextState nextState;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Parameters> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameters> parameters) {
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NextState getNextState() {
        return nextState;
    }

    public void setNextState(NextState nextState) {
        this.nextState = nextState;
    }
}
