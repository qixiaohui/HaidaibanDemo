package com.haidaiban.foxlee.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.activitys.AcceptedOrderDetails;
import com.haidaiban.foxlee.activitys.OrderDetails;
import com.haidaiban.foxlee.activitys.ProductDetail;
import com.haidaiban.foxlee.adapter.ListViewAdapter;
import com.haidaiban.foxlee.adapter.OrderListAdapter;
import com.haidaiban.foxlee.model.offer.Result;
import com.haidaiban.foxlee.model.order.Order;
import com.haidaiban.foxlee.webMethod.Webmethod;

import java.io.IOException;
import java.util.logging.Handler;

/**
 * Created by tom on 4/5/15.
 */
public class OrderList extends Fragment implements ChildMethod{
    View view;
    RelativeLayout loading;
    String title;
    Async asyn;
    Webmethod webmethod;
    ListView listView;
    Order order;
    int index;
    Intent intent;
    ParentMethods parenView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.orderlist,null);
        loading  = (RelativeLayout) view.findViewById(R.id.loadingPanel);
        listView = (ListView) view.findViewById(R.id.list);
        loading.setVisibility(View.GONE);
        view.setBackgroundColor(getResources().getColor(R.color.white));
        parenView = (ParentMethods) getParentFragment();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        android.os.Handler handler = new android.os.Handler();
        loading.setVisibility(View.VISIBLE);
        switch (index){
            case 0:
                if(DataHolder.getOrderAll() == null){
                    asyn = new Async();
                    asyn.execute();
                }else {
                    order = DataHolder.getOrderAll();
                    loading.setVisibility(View.INVISIBLE);
                    loadListView();
                    break;
                }
            case 1:
                if(DataHolder.getOrderWaiting()==null){
                    loading.setVisibility(View.VISIBLE);
                }else{
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            order = DataHolder.getOrderWaiting();
                            loadListView();
                        }
                    }, 100);
                    break;
                }
            case 2:
                if(DataHolder.getOrderAccepted() == null){
                    loading.setVisibility(View.VISIBLE);
                }else{
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            order = DataHolder.getOrderAccepted();
                            loadListView();
                        }
                    }, 200);
                    break;
                }
            case 3:
                if(DataHolder.getOrderClosed() == null){
                    loading.setVisibility(View.VISIBLE);
                }else{
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            order = DataHolder.getOrderClosed();
                            loadListView();
                        }
                    }, 300);
                    break;
                }
        }

    }

    public void loadListView(){
        if(listView != null && order != null && getActivity() != null) {
            loading.setVisibility(View.INVISIBLE);
            System.out.println("asynctask*****");
            listView.setAdapter(new OrderListAdapter((getActivity().getApplicationContext()), order));

            // get details of orderlist
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    intent = new Intent(getActivity().getApplicationContext(), OrderDetails.class);
                    DataHolder.setOrderResult(order.getResults().get(position));
                    //   DataHolder.setDealResult(deals.getResults().get(position));
                    startActivity(intent);
                }
            });
        }
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public class Async extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... params) {
            webmethod = new Webmethod(getActivity().getApplicationContext());
            try {
                order = webmethod.getOrder();
            }catch (IOException e){

            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loading.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            loading.setVisibility(View.GONE);
            DataHolder.setOrderAll(order);
            parenView.setData();

            if(listView != null && order != null && getActivity() != null) {
                System.out.println("asynctask*****");
                listView.setAdapter(new OrderListAdapter((getActivity().getApplicationContext()), order));

                // get details of orderlist
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        intent = new Intent(getActivity().getApplicationContext(), OrderDetails.class);
                        DataHolder.setOrderResult(order.getResults().get(position));
                     //   DataHolder.setDealResult(deals.getResults().get(position));
                        startActivity(intent);
                    }
                });
            }
        }
    }

    @Override
    public void getData() {
        switch (index){
            case 1:
                order = DataHolder.getOrderWaiting();
                break;
            case 2:
                order = DataHolder.getOrderAccepted();
                break;
            case 3:
                order = DataHolder.getOrderClosed();
                break;
        }
    loadListView();
    }
}
