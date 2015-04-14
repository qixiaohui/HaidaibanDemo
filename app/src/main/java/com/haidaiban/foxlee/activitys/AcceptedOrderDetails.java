package com.haidaiban.foxlee.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.offer.Result;

/**
 * Created by tom on 4/13/15.
 */
public class AcceptedOrderDetails extends Activity{

    private TextView tx_persion_name;
    private TextView tx_persion_adds;
    private TextView tx_persion_phone;


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

        tx_persion_name.setText(acceptedOffer.getCustomer().getUsername());
    }

    private void initView() {
        tx_persion_adds  = (TextView) findViewById(R.id.tx_d1_consignee_add);
        tx_persion_name  = (TextView) findViewById(R.id.tx_d1_consignee_name);
        tx_persion_phone  = (TextView) findViewById(R.id.tx_d1_consignee_phone);

    }
}
