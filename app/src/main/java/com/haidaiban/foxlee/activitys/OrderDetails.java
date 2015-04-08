package com.haidaiban.foxlee.activitys;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.haidaiban.foxlee.fragments.R;

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
    }
}
