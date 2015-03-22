package com.haidaiban.foxlee.activitys;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.quotelist.Result;
import com.haidaiban.foxlee.ui.MyCameraDialog;
import com.haidaiban.foxlee.webMethod.Webmethod;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


/**
 * Created by jili on 3/13/15.
 */
public class Activity_PriceFill extends Activity {

    private Button btn_addNewOrder;
    private Button btn_perViewOrder;

    private ImageButton btn_upload1 ;
    private ImageButton  btn_upload2 ;
    private ImageButton btn_upload3 ;

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

    Intent intent;
    Result quote;
    Webmethod webmethod;
    SubmitQuote submitQuote;

    public Activity_PriceFill() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pricefill_layout);
        initView();
        getInputFromEdit();
        webmethod = new Webmethod(getApplicationContext());

        intent = getIntent();



        if(intent.getIntExtra("flag",0)==1){
            try {
                byte[] data = Base64.decode(intent.getStringExtra("data"),Base64.NO_WRAP);
                ObjectInputStream ois = new ObjectInputStream(
                        new ByteArrayInputStream(data));
                quote = (Result) ois.readObject();
                ois.close();

                et_item_name.setText(quote.getTitle());
                et_item_number.setText(quote.getQuantity().toString());
                et_item_moreInfo.setText(quote.getRemark());
                et_item_link.setText(quote.getWebLink());
                et_item_official_price.setText(quote.getPrice()==null?"0":quote.getPrice().toString());
                et_item_coupon.setText(quote.getCoupon());
            }catch (IOException e){

            }catch (ClassNotFoundException e){

            }
        }


        tax_result = getTaxRadioBtn();
        shipping_result= getShippingRadioBtn();

        btn_addNewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /***
                 * TO-DO :   sent string to server ,把得到的输入信息 发给服务器
                 */
                quote.setTitle(et_item_name.getText().toString());
                quote.setQuantity(Integer.parseInt(et_item_number.getText().toString()));
                quote.setRemark(et_item_moreInfo.getText().toString());
                quote.setWebLink(et_item_link.getText().toString());
                quote.setPrice(et_item_official_price.getText().toString());
                quote.setCoupon(et_item_coupon.getText().toString());

                submitQuote = new SubmitQuote();
                submitQuote.execute();

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

        btn_upload1.setOnClickListener(new View.OnClickListener() {

            /***
             *  TO-DO : upload1
             */

            @Override

            public void onClick(View v) {


                new MyCameraDialog(Activity_PriceFill.this,R.style.CustomDialog).show();
            }
        });
        btn_upload2.setOnClickListener(new View.OnClickListener() {

            /***
             *  TO-DO : upload 2
             */

            @Override

            public void onClick(View v) {
                new MyCameraDialog(Activity_PriceFill.this,R.style.CustomDialog).show();

            }
        });

        btn_upload3.setOnClickListener(new View.OnClickListener() {

            /***
             *  TO-DO : upload3
             */

            @Override

            public void onClick(View v) {
                new MyCameraDialog(Activity_PriceFill.this,R.style.CustomDialog).show();

            }
        });



    }

    private void onpenDialog(Context context) {
        /***
         * open dialog
         */

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

        //imagebutton
        btn_upload1 = (ImageButton)findViewById(R.id.img_upoload1);
        btn_upload2 = (ImageButton)findViewById(R.id.img_upoload2);
        btn_upload3 = (ImageButton)findViewById(R.id.img_upoload3);



    }

    public class SubmitQuote extends AsyncTask<String,String,String>{
        @Override
        protected String doInBackground(String... params) {
            try {
                webmethod.updateQuote(quote);
            }catch (IOException e){

            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }








}
