package com.haidaiban.foxlee.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.haidaiban.foxlee.fragments.R;


/**
 * Created by jili on 3/13/15.
 */
public class Activity_PriceFill extends Activity {

    private Button btn_addNewOrder;
    private Button btn_perViewOrder;



    private EditText et_item_name;
    private EditText et_item_number;
    private EditText et_item_photos;
    private EditText et_item_moreInfo;
    private EditText et_item_link;
    private EditText et_item_official_price;
    private EditText et_item_coupon;

    private RadioButton rbbtn_tax_yes;
    private RadioButton rbbtn_tax_no;
    private RadioButton rbbtn_tax_anyway;

    private RadioButton rbbtn_shipping_yes;
    private RadioButton rbbtn_shipping_no;
    private RadioButton rbbtn_shipping_anyway;

    private RadioGroup rg_tax;
    private RadioGroup rg_shipping;

//    private RadioButton rbtn_tax_yes;
//    private RadioButton rbtn_tax_no;
//    private RadioButton rbtn_tax_anyway;
//
//    private RadioButton rbtn_shipping_yes;
//    private RadioButton rbtn_shipping_no;
//    private RadioButton rbtn_shipping_anyway;
      private RadioButton rbtn_Tax;
      private RadioButton rbtn_Shipping;

    String item_Name;
    String item_Number;
    String item_Photo;
    String item_MoreInfo;
    String item_Link;
    String item_OfficePrice;
    String item_Coupon;


    String str_yes = "yes";
    String str_No  =  "no";
    String str_Anyway= "anyway";
    String shipping_result = str_Anyway;
    String tax_result = str_Anyway;





    public Activity_PriceFill() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pricefill_layout);
        initView();
        getInputFromEdit();


        tax_result = getTaxRadioBtn();
        shipping_result= getShippingRadioBtn();

        btn_addNewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /***
                 * TO-DO :   sent string to server ,把得到的输入信息 发给服务器
                 */

            }
        });
        btn_perViewOrder.setOnClickListener(new View.OnClickListener() {

            /***
             *  TO-DO : 跳转至 perview ，查看询价单
             */

            @Override

            public void onClick(View v) {

            }
        });


    }

    private void getInputFromEdit() {
        item_Name = et_item_name.getText().toString();
        item_Number = et_item_number.getText().toString();
        //To-Do img 需要上传图片
        item_Photo = et_item_photos.getText().toString();

        item_MoreInfo = et_item_moreInfo.getText().toString();
        item_Link = et_item_link.getText().toString();
        item_OfficePrice = et_item_official_price.getText().toString();
        item_Coupon = et_item_coupon.getText().toString();



    }

    /***
     *  得到 Tax Radiobutton 结果
     */

    private String  getShippingRadioBtn() {
       int  selected = rg_shipping.getCheckedRadioButtonId();
        switch (selected){
            case R.id.radioButton_shipping_yes :
                shipping_result = str_yes;
                break;
            case R.id.radioButton_shipping_no :
                shipping_result = str_No;
                break;
            case R.id.radioButton_shipping_anyway :
                shipping_result = str_Anyway ;
            break ;


        }

       return shipping_result;
    }

    /**
     *  得到 Shipping RadioButton 结果
     */
    private String  getTaxRadioBtn() {

        int  selected = rg_tax.getCheckedRadioButtonId();
        switch (selected){
            case R.id.radioButton_tax_yes :
                tax_result = str_yes;
                break;
            case R.id.radioButton_tax_no :
                tax_result = str_No;
                break;
            case R.id.radioButton_tax_anyway :
                tax_result = str_Anyway ;
                break ;


        }

        return tax_result;
    }

    private void initView() {
        // add new item and perview btn
        btn_addNewOrder = (Button) findViewById(R.id.btn_ap_addnewitem);
        btn_perViewOrder= (Button) findViewById(R.id.btn_ap_perview);


        et_item_name = (EditText) findViewById(R.id.et_ap_name);
        et_item_number = (EditText) findViewById(R.id.et_ap_number);
        et_item_photos = (EditText) findViewById(R.id.et_ap_photos);
        et_item_moreInfo = (EditText) findViewById(R.id.et_ap_moreinfo);
        et_item_link = (EditText) findViewById(R.id.et_ap_link);
        et_item_official_price = (EditText) findViewById(R.id.et_ap_ofprice);
        et_item_coupon = (EditText) findViewById(R.id.et_ap_coupon);
        // radio buttons
        rg_tax = (RadioGroup) findViewById(R.id.radiogrouptax);
        rg_shipping = (RadioGroup) findViewById(R.id.radiogroupShipping);

        rbbtn_tax_yes = (RadioButton) findViewById(R.id.radioButton_tax_yes);
        rbbtn_tax_no = (RadioButton) findViewById(R.id.radioButton_tax_no);
        rbbtn_tax_anyway = (RadioButton) findViewById(R.id.radioButton_tax_anyway);

        rbbtn_shipping_yes = (RadioButton) findViewById(R.id.radioButton_shipping_yes);
        rbbtn_shipping_no = (RadioButton) findViewById(R.id.radioButton_shipping_no);
        rbbtn_shipping_anyway = (RadioButton) findViewById(R.id.radioButton_shipping_anyway);

    }
}
