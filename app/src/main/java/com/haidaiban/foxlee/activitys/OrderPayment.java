package com.haidaiban.foxlee.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.config.Constants;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.openoffer.OpenOffer;
import com.squareup.picasso.Picasso;

/**
 * Created by qixiaohui on 7/4/15.
 */
public class OrderPayment extends Activity {
    private static OpenOffer openOffer;
    private static TextView sum;
    private static TextView agentName;
    private static ImageView icon;
    private static TextView payStore;
    private static TextView accountId;
    private static TextView storeLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderpayment);
        openOffer = DataHolder.getOpenOffer();
        initView();
        initData();
    }

    public void initView(){
        sum = (TextView) findViewById(R.id.sum);
        agentName = (TextView) findViewById(R.id.agentName);
        icon = (ImageView) findViewById(R.id.icon);
        payStore = (TextView) findViewById(R.id.payStore);
        accountId = (TextView) findViewById(R.id.accountID);
        storeLink = (TextView) findViewById(R.id.storeLink);
    }

    public void initData(){
        sum.setText("应付总额："+openOffer.getOfferPrice()+"(含定金￥"+openOffer.getDownPayment()+")");
        agentName.setText("代办："+openOffer.getAgent().getUsername());
        Picasso.with(this)
                .load(Constants.getLOGIN_URL() + openOffer.getAgent().getIcon())
                .resize(120, 120)
                .centerCrop()
                .into(icon);
        payStore.setText(openOffer.getExtPayDesc());
        accountId.setText(openOffer.getExtPayAcct());
        storeLink.setText(openOffer.getPaymentLink());
    }
}
