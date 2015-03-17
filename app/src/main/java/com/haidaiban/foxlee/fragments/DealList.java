package com.haidaiban.foxlee.fragments;

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
import android.widget.Spinner;

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
    private Deal deals;
    private asyncTask loadData;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.offerlist,null);
        listView = (ListView) view.findViewById(R.id.list);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webmethod = new Webmethod(getActivity());
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
                deals = webmethod.getDeals();
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
            listView.setAdapter(new ListViewAdapter(deals,getActivity().getApplicationContext()));
        }
    }
}
