package com.haidaiban.foxlee.fragments;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.adapter.ListViewAdapter;
import com.haidaiban.foxlee.model.deal.Deal;
import com.haidaiban.foxlee.webMethod.Webmethod;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by qixiaohui on 3/15/15.
 */
public class DealList extends Fragment{
    private View view;
    private String title;
    private String category;
    private ListView listView;
    private Webmethod webmethod;
    private static Deal deals;
    private asyncTask loadData;
    private RelativeLayout loading;
    private static DataHolder dataHolder;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.offerlist,null);
        listView = (ListView) view.findViewById(R.id.list);
        loading  = (RelativeLayout) view.findViewById(R.id.loadingPanel);
        loading.setVisibility(View.GONE);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData = new asyncTask();
        loadData.execute();
    }

    public void setTitle(String title,String category){
        this.title = title;
        this.category = category;

    }

    public class asyncTask extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... params) {
            try {
                if(deals == null) {
                    webmethod = new Webmethod(getActivity());
                    deals = webmethod.getDeals();
                }
            }catch (IOException e){

            }catch (JSONException e){

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
            if(listView != null && deals != null && getActivity() != null) {
                System.out.println("asynctask*****");
                listView.setAdapter(new ListViewAdapter(deals, getActivity().getApplicationContext()));
            }
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(DataHolder.getDeal() != null){
            System.out.println(DataHolder.getDeal().getResults().get(0).getTitle()+"********");
            this.deals = DataHolder.getDeal();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        DataHolder.setDeal(deals);
    }
}
