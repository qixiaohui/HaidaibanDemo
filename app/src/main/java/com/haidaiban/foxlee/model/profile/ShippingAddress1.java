package com.haidaiban.foxlee.model.profile;

/**
 * Created by tom on 5/25/15.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class ShippingAddress1 {

    @Expose
    private String province;
    @Expose
    private String recipient;
    @Expose
    private String district;
    @Expose
    private Object city;
    @Expose
    private String cellphone;
    @Expose
    private String address;

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
     * The city
     */
    public Object getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    public void setCity(Object city) {
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

}
