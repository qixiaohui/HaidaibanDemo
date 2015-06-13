package com.haidaiban.foxlee.activitys;

import android.widget.EditText;

import com.haidaiban.foxlee.Base.BaseActivity;
import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.profile.UserProfile;

/**
 * Created by jili on 5/9/15.
 */
public class E1_MyAddress_Activity extends BaseActivity {
    private UserProfile userProfile;
    private EditText et_adds_province;
    private EditText et_adds_street;
    private EditText et_adds_details;
    private EditText et_adds_person;
    private EditText et_adds_person_phone_number;

    @Override
    protected void initView() {
        setContentView(R.layout.e1_myaddress);
        userProfile = DataHolder.getUserProfile();
        et_adds_province = (EditText) findViewById(R.id.et_adds_province);
        et_adds_street = (EditText) findViewById(R.id.et_adds_street);
        et_adds_details = (EditText) findViewById(R.id.et_adds_details);
        et_adds_person = (EditText) findViewById(R.id.et_adds_person);
        et_adds_person_phone_number = (EditText) findViewById(R.id.et_adds_person_phone_number);
        if(userProfile!=null && userProfile.getShippingAddress1()!=null){
            initData();
        }
    }

    @Override
    protected void initData() {

        if(userProfile.getShippingAddress1().getProvince()!=null){
            et_adds_province.setText(userProfile.getShippingAddress1().getProvince());
        }

        if(userProfile.getShippingAddress1().getCity()!=null){
            et_adds_province.append(userProfile.getShippingAddress1().getCity());
        }

        if(userProfile.getShippingAddress1().getDistrict()!=null){
            et_adds_province.append(userProfile.getShippingAddress1().getDistrict());
        }

        if(userProfile.getShippingAddress1().getAddress()!=null){
            et_adds_street.setText(userProfile.getShippingAddress1().getAddress());
        }

        if(userProfile.getShippingAddress1().getRecipient()!=null){
            et_adds_person.setText(userProfile.getShippingAddress1().getRecipient());
        }

        if(userProfile.getShippingAddress1().getCellphone()!=null){
            et_adds_person_phone_number.setText(userProfile.getShippingAddress1().getCellphone());
        }
    }
}
