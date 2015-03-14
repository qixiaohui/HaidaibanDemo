package com.haidaiban.foxlee.model.offer;

import java.util.List;


/**
 * Created by qixiaohui on 3/13/15.
 */
public class Offer {
    private int count;
    private Object next;
    private Object previous;
    private List<Result> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
