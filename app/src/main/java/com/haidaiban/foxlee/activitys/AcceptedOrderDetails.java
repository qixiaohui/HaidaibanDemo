package com.haidaiban.foxlee.activitys;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.Util.Utility;
import com.haidaiban.foxlee.dialogs.Dialog_AddMoney;
import com.haidaiban.foxlee.dialogs.Dialog_AddTime;
import com.haidaiban.foxlee.dialogs.Dialog_ConfirmOrder;
import com.haidaiban.foxlee.fragments.ChildMethod;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.offer.Counterquote;
import com.haidaiban.foxlee.model.offer.CustomerAction;
import com.haidaiban.foxlee.model.offer.Offer;
import com.haidaiban.foxlee.model.offer.Result;
import com.haidaiban.foxlee.webMethod.Webmethod;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tom on 4/13/15.
 */
public class AcceptedOrderDetails extends Activity implements ChildMethod{

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
    Button btn_confirm;
    Button btn_addTime;
    Button btn_addMoney;
    Button btn_ShareOrder;
    Button ditch_quote;
    ArrayList<String> customerActions;
    private Result acceptedOffer;
    private RelativeLayout acceptedOfferDetail;
    private Offer offersAll;
    private Offer offerUpdate;
    private Offer offerPaid;
    private Offer offerBuying;
    private Offer offerDelivering;
    private Offer offerCompleted;
    private Offer offerCanceled;
    private Intent intent;
    private String uid;
    private static GetAcceptedOffer getAcceptedOffer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d0offer_details);
        acceptedOffer = DataHolder.getAcceptedOffer();
        offerPaid = new Offer();
        offerBuying = new Offer();
        offerDelivering = new Offer();
        offerCompleted = new Offer();
        offerCanceled = new Offer();
        initView();
        btn_addMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Dialog_AddMoney(AcceptedOrderDetails.this, R.style.CustomDialog).show();
            }
        });

        btn_addTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Dialog_AddTime(AcceptedOrderDetails.this,R.style.CustomDialog).show();
            }
        });

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Dialog_ConfirmOrder(AcceptedOrderDetails.this,R.style.CustomDialog).show();

            }
        });

        ditch_quote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Dialog_DitchOffer(AcceptedOrderDetails.this,R.style.CustomDialog, AcceptedOrderDetails.this
                ).show();
            }
        });

        intent = getIntent();
        if(!intent.getBooleanExtra("LoadData",false)){
            setData();
        }else{
            uid = intent.getStringExtra("uid");
            getAcceptedOffer = new GetAcceptedOffer();
            getAcceptedOffer.execute();
        }

    }


    private void setData() {
        orderDetail = DataHolder.getAcceptedOffer();
        customerActions = new ArrayList<String>(Arrays.asList(getApplicationContext().getResources().getStringArray(R.array.customerAction)));
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

        for (int i = 0; i < acceptedOffer.getTransactionState().getCustomerActions().size(); i++) {
            String action = acceptedOffer.getTransactionState().getCustomerActions().get(i).getName();
            System.out.println(action);
            if (action.equals(refillQuote.getText())) {
                refillQuote.setVisibility(View.VISIBLE);
            } else if (action.equals(btn_confirm.getText())) {
                btn_confirm.setVisibility(View.VISIBLE);
            } else if (action.equals(btn_addTime)) {
                btn_addTime.setVisibility(View.VISIBLE);
            } else if (action.equals(btn_addMoney)) {
                btn_addMoney.setVisibility(View.VISIBLE);
            } else if (action.equals(btn_ShareOrder.getText())) {
                btn_ShareOrder.setVisibility(View.VISIBLE);
            } else if (action.equals(ditch_quote.getText())) {
                DataHolder.setCustomerAction(acceptedOffer.getTransactionState().getCustomerActions().get(i));
                ditch_quote.setVisibility(View.VISIBLE);
            }
        }

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

    @Override
    public void getData() {
        acceptedOfferDetail.invalidate();
    }

    private void initView() {
        acceptedOfferDetail = (RelativeLayout) findViewById(R.id.acceptedOfferDetail);
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
        btn_addMoney = (Button) findViewById(R.id.btn_addmoney);
        btn_addTime = (Button) findViewById(R.id.btn_addtime);
        btn_confirm = (Button) findViewById(R.id.btn_confirm);
        btn_ShareOrder = (Button) findViewById(R.id.btn_shareorder);
        ditch_quote = (Button) findViewById(R.id.ditchQutoe);

    }

    public class Dialog_DitchOffer extends Dialog {

        private Context mContext;
        private int mTheme = R.style.CustomDialog;
        private EditText comment;
        private Button confirm;
        private Button cancel;
        private Async async;
        private CustomerAction customerAction;
        private Result acceptedOffer;
        private Webmethod webmethod;
        private int result;
        private ChildMethod ownerActivity;


        public Dialog_DitchOffer(Context context, int theme, ChildMethod ownerActivity) {
            super(context, theme);
            this.mContext = context;
            this.ownerActivity = ownerActivity;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.dialog_d0_ditchoffer);
            comment = (EditText) findViewById(R.id.et_comment);
            confirm = (Button) findViewById(R.id.dialog_btn_sentcomment);
            cancel = (Button) findViewById(R.id.dialog_btn_cancel);
            webmethod = new Webmethod(getContext());
            async = new Async();

            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    customerAction = DataHolder.getCustomerAction();
                    acceptedOffer = DataHolder.getAcceptedOffer();
                    async.execute();
                    Dialog_DitchOffer.this.dismiss();
                }
            });

            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog_DitchOffer.this.dismiss();
                }
            });

        }

        public class Async extends AsyncTask<String, String, String> {
            @Override
            protected String doInBackground(String... params) {
                try {
                    result = webmethod.offerUpdateAction(customerAction.getName(), customerAction.getParameters(), acceptedOffer.getUid());
                }catch (IOException e){

                }catch (JSONException e){

                }
                return Integer.toString(result);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if(s.equals("200")){
                    offersAll = DataHolder.getOfferAll();

                    for(int i=0; i<offersAll.getResults().size();i++){
                        if(offersAll.getResults().get(i).getUid().equals(DataHolder.getAcceptedOffer().getUid())){
                            offersAll.getResults().remove(i);
                            offersAll.getResults().add(i,DataHolder.getAcceptedOffer());
                            DataHolder.setOfferAll(offersAll);
                            break;
                        }
                    }
                    for(int i=0; i<offersAll.getResults().size(); i++){
                        if(offersAll
                                .getResults()
                                .get(i)
                                .getTransactionState()
                                .getState()
                                .equals(getApplicationContext()
                                        .getResources()
                                        .getStringArray(R.array.OrderTitle)[1])
                                ||offersAll
                                .getResults()
                                .get(i)
                                .getTransactionState()
                                .getState()
                                .equals(getApplicationContext()
                                        .getResources()
                                        .getString(R.string.paiedDeposit))){
                            offerPaid.getResults().add(offersAll.getResults().get(i));
                        }else if(offersAll
                                .getResults()
                                .get(i)
                                .getTransactionState()
                                .getState()
                                .equals(getApplicationContext()
                                        .getResources()
                                        .getStringArray(R.array.OrderTitle)[2])){
                            offerBuying.getResults().add(offersAll.getResults().get(i));
                        }else if(offersAll
                                .getResults()
                                .get(i)
                                .getTransactionState()
                                .getState()
                                .equals(getApplicationContext()
                                        .getResources()
                                        .getStringArray(R.array.OrderTitle)[3])){
                            offerDelivering.getResults().add(offersAll.getResults().get(i));
                        }else if(offersAll
                                .getResults()
                                .get(i)
                                .getTransactionState()
                                .getState()
                                .equals(getApplicationContext()
                                        .getResources()
                                        .getStringArray(R.array.OrderTitle)[4])){
                            offerCompleted.setResults(new ArrayList<Result>());
                            offerCompleted.getResults().add(offersAll.getResults().get(i));
                        }else if(offersAll
                                .getResults()
                                .get(i)
                                .getTransactionState()
                                .getState()
                                .equals(getApplicationContext()
                                        .getResources()
                                        .getStringArray(R.array.OrderTitle)[5])){
                            offerCanceled.getResults().add(offersAll.getResults().get(i));
                        }
                    }
                    DataHolder.setOfferPaid(offerPaid);
                    DataHolder.setOfferDelivering(offerDelivering);
                    DataHolder.setOfferBuying(offerBuying);
                    DataHolder.setOfferComplete(offerCompleted);
                    DataHolder.setOfferCanceled(offerCanceled);


                    ownerActivity.getData();
                }
            }
        }
    }


    public class GetAcceptedOffer extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... params) {
            try {
                acceptedOffer = new Webmethod(getApplicationContext()).getAcceptedOffer(uid);
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
            setData();
        }
    }
}
