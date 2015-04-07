package com.haidaiban.foxlee.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.haidaiban.foxlee.adapter.ListViewAdapter;
import com.haidaiban.foxlee.adapter.OrderListAdapter;
import com.haidaiban.foxlee.model.order.Order;
import com.haidaiban.foxlee.webMethod.Webmethod;

import java.io.IOException;

/**
 * Created by tom on 4/5/15.
 */
public class OrderList extends Fragment {
    View view;
    RelativeLayout loading;
    String title;
    Async asyn;
    Webmethod webmethod;
    ListView listView;
    Order order;
    int index;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.orderlist,null);
        loading  = (RelativeLayout) view.findViewById(R.id.loadingPanel);
        listView = (ListView) view.findViewById(R.id.list);
        loading.setVisibility(View.GONE);
        view.setBackgroundColor(getResources().getColor(R.color.white));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        asyn = new Async();
        asyn.execute();
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public class Async extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... params) {
            webmethod = new Webmethod(getActivity().getApplicationContext());
            switch (index){
                case 0:
                    title = "";
                    break;
                case 1:
                    title = "?status=no_offer";
                    break;
                case 2:
                    title = "?status=has_offer";
                    break;
                case 3:
                    title = "?status=is_closed";
            }
            try {
                System.out.println(index+"$%^%*");
                order = webmethod.getOrder(title);
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
            if(listView != null && order != null && getActivity() != null) {
                System.out.println("asynctask*****");
                listView.setAdapter(new OrderListAdapter((getActivity().getApplicationContext()), order));
            }
        }
    }
}