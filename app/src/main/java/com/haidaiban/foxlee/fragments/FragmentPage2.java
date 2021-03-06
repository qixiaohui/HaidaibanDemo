package com.haidaiban.foxlee.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.Util.Utility;
import com.haidaiban.foxlee.activitys.Activity_PriceFill;
import com.haidaiban.foxlee.activitys.OfferMenu_Activity;
import com.haidaiban.foxlee.adapter.TempOfferAdapter;
import com.haidaiban.foxlee.model.order.Order;
import com.haidaiban.foxlee.model.quotelist.QuoteList;
import com.haidaiban.foxlee.webMethod.Webmethod;
import com.securepreferences.SecurePreferences;

import org.json.JSONException;

import java.io.IOException;

public class FragmentPage2 extends Fragment{
    private Webmethod webmethod;
    private String offer;
    private Gson gson;
    private QuoteList quotes;
    private Order orders;

    //ui

    private Button btn_TempOffer_Add;
    private Button btn_TempOffer_Submit;
    private Button btn_tempOffer_AddAgain;


    GetData getData;

    private View view ;
    private ListView myTemp_List;
    private Boolean isAgent; //flag is agent


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        isAgent = DataHolder.getIsAgent();
        view = inflater.inflate(R.layout.fragment_2,null);
        myTemp_List =(ListView) view.findViewById(R.id.listview_tempoffer);

        btn_TempOffer_Add =(Button) view.findViewById(R.id.btn_temp_addnewitem);
        btn_TempOffer_Submit =(Button) view.findViewById(R.id.btn_temp_submitform);
        btn_tempOffer_AddAgain =(Button) view.findViewById(R.id.btn_temp_again);

        //OnClick add new offer
        btn_TempOffer_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Activity_PriceFill.class);
                startActivity(intent);

            }
        });

        //OnClick submit offer
        btn_TempOffer_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OfferMenu_Activity.class);
                startActivity(intent);
            }
        });

        //OnClick add add again 添加新商品
        btn_tempOffer_AddAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        return view;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        gson = new Gson();
        getData = new GetData();
        getData.execute();



    }

    public class GetData extends AsyncTask<String,String,String>{
        @Override
        protected String doInBackground(String... params) {
            try {
                //get json files
                if(quotes == null) {

                    webmethod = new Webmethod(getActivity().getApplicationContext());
                    if(isAgent){    //call agent webmethod
                        orders = webmethod.getAgentOrders();
                    }else {         //call customer webmethod
                        quotes = webmethod.getQuotes();
                    }
                }
                //转化对应offer java class



            }catch(JSONException e){

            }catch(IOException e){

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
            //TO-Do  update listview in here ;
            myTemp_List.setAdapter(new TempOfferAdapter(quotes,getActivity().getApplicationContext()));




        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(DataHolder.getQuoteList() != null){
            quotes = DataHolder.getQuoteList();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        DataHolder.setQuoteList(quotes);
    }
}