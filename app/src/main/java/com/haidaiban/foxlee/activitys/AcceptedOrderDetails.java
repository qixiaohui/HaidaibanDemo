package com.haidaiban.foxlee.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.Util.Utility;
import com.haidaiban.foxlee.fragments.R;
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
    }
}
