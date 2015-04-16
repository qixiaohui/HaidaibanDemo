package com.haidaiban.foxlee.activitys;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.Util.Utility;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.offer.Counterquote;
import com.haidaiban.foxlee.model.offer.Result;

import java.text.ParseException;

/**
 * Created by tom on 4/13/15.
 */
public class AcceptedOrderDetails extends Activity{

    private TextView tx_persion_name;
    private TextView tx_persion_adds;
    private TextView tx_persion_phone;
    private TextView orderNumber;
    private TextView lastUpdate;
    private Result orderDetail;
    private TextView orderStatus;
    private TextView updateDateTable;
    private TextView statusTable;
    private TextView moreTable;
    private LinearLayout orderInfoContainer;
    private com.haidaiban.foxlee.model.quotelist.Result quoteListResult;
    Button refillQuote;
    Intent intent;

    private Result acceptedOffer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d0offer_details);
        acceptedOffer = DataHolder.getAcceptedOffer();

        initView();
        setData();
    }

    private void setData() {
        orderDetail = DataHolder.getAcceptedOffer();
        orderNumber.append(orderDetail.getOrder());

        try {
            String time = Utility.getTimeSpan(orderDetail.getLastUpdate());
            lastUpdate.append(time);
            updateDateTable.setText(time);
        }catch (ParseException e){

        }

        tx_persion_name.setText(acceptedOffer.getCustomer().getUsername());
        orderStatus.append(": "+acceptedOffer.getTransactionState().getState());
        statusTable.setText(acceptedOffer.getTransactionState().getState());
        moreTable.setText(Html.fromHtml("定金金额:<br/>"+acceptedOffer.getDownPayment()));

        for(Counterquote counterquote:acceptedOffer.getCounterquotes()){
            LinearLayout linearLayout = new LinearLayout(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.setLayoutParams(layoutParams);
            TextView name = new TextView(this);
            name.setTextSize(12);
            name.setTextColor(getResources().getColor(R.color.black));
            name.setText(counterquote.getTitle());
            name.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams textParam = new LinearLayout.LayoutParams(Utility.getWindowSize(getApplicationContext())[0]/3, ViewGroup.LayoutParams.WRAP_CONTENT);
            textParam.weight = 1.0f;
            textParam.setMargins(0,5,0,5);
            name.setLayoutParams(textParam);
            TextView quantity = new TextView(this);
            quantity.setTextSize(12);
            quantity.setTextColor(getResources().getColor(R.color.black));
            quantity.setText(counterquote.getQuantity() == null ? "" : Integer.toString(counterquote.getQuantity()));
            quantity.setGravity(Gravity.CENTER);
            quantity.setLayoutParams(textParam);
            TextView style = new TextView(this);
            style.setTextSize(12);
            style.setTextColor(getResources().getColor(R.color.black));
            style.setText(counterquote.getStyle());
            style.setGravity(Gravity.CENTER);
            style.setLayoutParams(textParam);
            linearLayout.addView(name);
            linearLayout.addView(quantity);
            linearLayout.addView(style);
            orderInfoContainer.addView(linearLayout);
        }


        refillQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), Activity_PriceFill.class);
                quoteListResult = new com.haidaiban.foxlee.model.quotelist.Result();
                quoteListResult.setTitle(acceptedOffer.getCounterquotes().get(0).getTitle());
                quoteListResult.setQuantity(
                        acceptedOffer.getCounterquotes().get(0).getQuantity()==null?
                                1:
                                acceptedOffer.getCounterquotes().get(0).getQuantity());
                quoteListResult.setWebLink(acceptedOffer.getCounterquotes().get(0).getWebLink());
                quoteListResult.setCoupon(acceptedOffer.getCounterquotes().get(0).getCoupon());
                quoteListResult.setRemark(acceptedOffer.getCounterquotes().get(0).getRemark());
                DataHolder.setQuotelistResult(quoteListResult);
                intent.putExtra("flag",1);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        tx_persion_adds  = (TextView) findViewById(R.id.tx_d1_consignee_add);
        tx_persion_name  = (TextView) findViewById(R.id.tx_d1_consignee_name);
        tx_persion_phone  = (TextView) findViewById(R.id.tx_d1_consignee_phone);
        orderNumber = (TextView) findViewById(R.id.tx_title_ordernumber);
        lastUpdate = (TextView) findViewById(R.id.lastUpdate);
        orderStatus = (TextView) findViewById(R.id.orderStatus);
        updateDateTable = (TextView) findViewById(R.id.updateDate);
        statusTable = (TextView) findViewById(R.id.statusMethod);
        moreTable = (TextView) findViewById(R.id.more);
        orderInfoContainer = (LinearLayout) findViewById(R.id.orderInfoContainer);
        refillQuote = (Button) findViewById(R.id.refillQuote);
    }
}
