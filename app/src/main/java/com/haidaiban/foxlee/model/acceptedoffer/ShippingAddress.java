package com.haidaiban.foxlee.model.acceptedoffer;

/**
 * Created by qixiaohui on 7/2/15.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class ShippingAddress {

    @Expose
    private String city;
    @Expose
    private String cellphone;
    @Expose
    private String province;
    @Expose
    private String address;
    @Expose
    private String district;
    @Expose
    private String recipient;

    /**
     *
     * @return
     * The city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     * The cellphone
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     *
     * @param cellphone
     * The cellphone
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    /**
     *
     * @return
     * The province
     */
    public String getProvince() {
        return province;
    }

    /**
     *
     * @param province
     * The province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     *
     * @return
     * The address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     * The district
     */
    public String getDistrict() {
        return district;
    }

    /**
     *
     * @param district
     * The district
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     *
     * @return
     * The recipient
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     *
     * @param recipient
     * The recipient
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

}
