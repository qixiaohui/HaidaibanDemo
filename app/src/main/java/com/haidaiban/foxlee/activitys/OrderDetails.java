package com.haidaiban.foxlee.activitys;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.config.Constants;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.order.Result;
import com.squareup.picasso.Picasso;

/**
 * Created by jili on 4/7/15.
 */
public class OrderDetails extends Activity {

    private static ActionBar actionBar;
    TextView tempOrder;
    TextView orderNumber;
    TextView updateTimer;
    ImageView orderImage;
    TextView orderStatus;
    Button terminateOrder;
    Result order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c1_orderdetail_layout);
        tempOrder = (TextView) findViewById(R.id.textView_temporder);
        orderNumber = (TextView) findViewById(R.id.textView_ordernumber);
        updateTimer = (TextView) findViewById(R.id.textView_updatetimer);
        orderImage = (ImageView) findViewById(R.id.c0_img);
        orderStatus = (TextView) findViewById(R.id.orderStatus);
        terminateOrder = (Button) findViewById(R.id.terminateOrder);

        loadData();
    }

    public void loadData(){
        order = DataHolder.getOrderResult();
        if(order.getIsSystemClosed()) {
            tempOrder.setText(getResources().getString(R.string.c_orderdetails_closed));
            tempOrder.setBackgroundColor(getResources().getColor(R.color.grey));
            orderStatus.setText(getResources().getString(R.string.orderClosed));
        }else{
            if(order.getOpenOffers().size()>0){
                tempOrder.setText(getResources().getString(R.string.c_orderdetails_accepted));
                tempOrder.setBackgroundColor(getResources().getColor(R.color.green));
                orderStatus.setText(getResources().getString(R.string.orderAccepted_1)
                        +order.getOpenOffers().get(0).getAgent()
                        +getResources().getString(R.string.orderAccepted_2));
            }else {
                tempOrder.setText(getResources().getString(R.string.c_orderdetails_waiting));
                tempOrder.setBackgroundColor(getResources().getColor(R.color.blue));
                orderStatus.setText(getResources().getString(R.string.c_orderdetails_18hours_1)
                        +getResources().getString(R.string.c_orderdetails_18hours_2));
            }
        }
        orderNumber.setText(order.getQuotes().get(0).getOrder());
        if(order.getQuotes().get(0).getDeal()==null){
            Picasso.with(this)
                    .load(R.drawable.productnoimage)
                    .centerCrop()
                    .resize(140, 140)
                    .into(orderImage);
        }else {
            Picasso.with(this)
                    .load(Constants.getLOGIN_URL() + order.getQuotes().get(0).getDeal().getImage())
                    .resize(120, 120)
                    .centerCrop()
                    .into(orderImage);
        }

    }
}
