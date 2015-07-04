package com.haidaiban.foxlee.activitys;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.Util.Utility;
import com.haidaiban.foxlee.adapter.BasicAdapter;
import com.haidaiban.foxlee.config.Constants;
import com.haidaiban.foxlee.dialogs.Dialog_Terminateorder;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.openoffer.OpenOffer;
import com.haidaiban.foxlee.model.order.Result;
import com.haidaiban.foxlee.webMethod.Webmethod;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.io.IOException;
import java.text.ParseException;

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
    private static Result order;
    private static String time;
    private static ListView listView;
    private static GetDetail getDetail;
    private static Webmethod webmethod;
    private static OpenOffer openOffer;
    private static TextView price;
    private static LinearLayout priceLinear;
    private static TextView offerTime;
    private static Button buy;
    private static RelativeLayout loadingPanel;
    private static Button terminate;
    private static Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c1_orderdetail_layout);
        tempOrder = (TextView) findViewById(R.id.textView_temporder);
        orderNumber = (TextView) findViewById(R.id.textView_ordernumber);
        updateTimer = (TextView) findViewById(R.id.textView_updatetimer);
        orderImage = (ImageView) findViewById(R.id.c0_img);
        orderStatus = (TextView) findViewById(R.id.orderStatus);
        listView = (ListView) findViewById(R.id.list);
        orderStatus = (TextView) findViewById(R.id.orderStatus);
        priceLinear = (LinearLayout) findViewById(R.id.priceLinear);
        price = (TextView) findViewById(R.id.price);
        offerTime = (TextView) findViewById(R.id.offerTime);
        loadingPanel = (RelativeLayout) findViewById(R.id.loadingPanel);
        buy = (Button) findViewById(R.id.buy);
        terminate = (Button) findViewById(R.id.terminate);

        loadData();
    }

    public void loadData(){
        order = DataHolder.getOrderResult();

        try {
            time = Utility.getTimeSpan(order.getLastUpdate());
            if(!time.equals("")){
                updateTimer.setText("更新于"+time+"前");
            }
        }catch (ParseException e) {
            System.out.println("parse time exception***");
        }

        if(order.getIsOpen()&&order.getOpenOffers().size()>0){
            tempOrder.setText("已报价");
            loadingPanel.setVisibility(View.VISIBLE);
            tempOrder.setTextColor(getApplicationContext().getResources().getColor(R.color.white));
            tempOrder.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.grey));
            orderNumber.setText("询价单号: "+order.getUid());
            getDetail = new GetDetail();
            getDetail.execute(order.getOpenOffers().get(0).getUid());
        }else if(order.getIsOpen()&&order.getOpenOffers().size()==0){
            tempOrder.setText("待报价");
            tempOrder.setTextColor(getApplicationContext().getResources().getColor(R.color.white));
            tempOrder.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.blue));
            orderNumber.setText("询价单号: "+order.getUid());
        }else {
            tempOrder.setText("已关闭");
            orderStatus.setVisibility(View.VISIBLE);
            tempOrder.setTextColor(getApplicationContext().getResources().getColor(R.color.white));
            tempOrder.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.green));
            orderNumber.setText("询价单号: "+order.getUid());
            orderStatus.setText("超时无代办接单，系统已终止询价。");
        }

        listView.setAdapter(new BasicAdapter(OrderDetails.this,order));
//
//        if(order.getIsSystemClosed()) {
//            tempOrder.setText(getResources().getString(R.string.c_orderdetails_closed));
//            tempOrder.setBackgroundColor(getResources().getColor(R.color.grey));
//            orderStatus.setText(getResources().getString(R.string.orderClosed));
//        }else{
//            if(order.getOpenOffers().size()>0){
//                tempOrder.setText(getResources().getString(R.string.c_orderdetails_accepted));
//                tempOrder.setBackgroundColor(getResources().getColor(R.color.green));
//                orderStatus.setText(getResources().getString(R.string.orderAccepted_1)
//                        +order.getOpenOffers().get(0).getAgent()
//                        +getResources().getString(R.string.orderAccepted_2));
//            }else {
//                tempOrder.setText(getResources().getString(R.string.c_orderdetails_waiting));
//                tempOrder.setBackgroundColor(getResources().getColor(R.color.blue));
//                orderStatus.setText(getResources().getString(R.string.c_orderdetails_18hours_1)
//                        +getResources().getString(R.string.c_orderdetails_18hours_2));
//            }
//        }
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

    public class GetDetail extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... params) {
            webmethod = new Webmethod(getApplicationContext());
            try {
                openOffer = webmethod.getOpenOffer(params[0]);
                DataHolder.setOpenOffer(openOffer);
            }catch (IOException e){

            }catch (JSONException e){

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
            String timeSpan;
            loadingPanel.setVisibility(View.GONE);
            priceLinear.setVisibility(View.VISIBLE);
            if(openOffer.getOfferPrice()!=null){
                price.setText("预估到手价￥"+openOffer.getOfferPrice()+"(含定金￥"+openOffer.getDownPayment()+")");
            }else{
                price.setText("预估到手价: 未填 (含定金￥"+openOffer.getDownPayment()+")");
                buy.setVisibility(View.GONE);
            }
            try {
                timeSpan = Utility.getTimeSpan(openOffer.getCreateDate());
                offerTime.setText("接单时间"+timeSpan);
            }catch (ParseException e){

            }

            buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent = new Intent(OrderDetails.this,OrderPayment.class);
                    startActivity(intent);

                }
            });

            terminate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Dialog_Terminateorder(OrderDetails.this,R.style.CustomDialog).show();
                }
            });

        }
    }
}
