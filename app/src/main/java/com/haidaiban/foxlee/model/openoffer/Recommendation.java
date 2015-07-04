package com.haidaiban.foxlee.model.openoffer;

import com.google.gson.annotations.Expose;

/**
 * Created by qixiaohui on 7/4/15.
 */
public class Recommendation {
    @Expose
    private String image;
    @Expose
    private String uid;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
