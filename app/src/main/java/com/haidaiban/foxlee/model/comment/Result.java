package com.haidaiban.foxlee.model.comment;

/**
 * Created by qixiaohui on 3/29/15.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Result {

    @Expose
    private User user;
    @Expose
    private Integer id;
    @SerializedName("content_type")
    @Expose
    private Integer contentType;
    @SerializedName("object_pk")
    @Expose
    private String objectPk;
    @Expose
    private String comment;
    @SerializedName("submit_date")
    @Expose
    private String submitDate;
    @SerializedName("is_removed")
    @Expose
    private Boolean isRemoved;

    /**
     *
     * @return
     * The user
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     * The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The contentType
     */
    public Integer getContentType() {
        return contentType;
    }

    /**
     *
     * @param contentType
     * The content_type
     */
    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    /**
     *
     * @return
     * The objectPk
     */
    public String getObjectPk() {
        return objectPk;
    }

    /**
     *
     * @param objectPk
     * The object_pk
     */
    public void setObjectPk(String objectPk) {
        this.objectPk = objectPk;
    }

    /**
     *
     * @return
     * The comment
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     * The comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     *
     * @return
     * The submitDate
     */
    public String getSubmitDate() {
        return submitDate;
    }

    /**
     *
     * @param submitDate
     * The submit_date
     */
    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    /**
     *
     * @return
     * The isRemoved
     */
    public Boolean getIsRemoved() {
        return isRemoved;
    }

    /**
     *
     * @param isRemoved
     * The is_removed
     */
    public void setIsRemoved(Boolean isRemoved) {
        this.isRemoved = isRemoved;
    }

}
