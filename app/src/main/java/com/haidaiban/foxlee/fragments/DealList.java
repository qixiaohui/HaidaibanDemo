package com.haidaiban.foxlee.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.activitys.ProductDetail;
import com.haidaiban.foxlee.adapter.ListViewAdapter;
import com.haidaiban.foxlee.model.deal.Deal;
import com.haidaiban.foxlee.model.deal.Result;
import com.haidaiban.foxlee.pullrefreshview.PullToRefreshBase;
import com.haidaiban.foxlee.pullrefreshview.PullToRefreshListView;
import com.haidaiban.foxlee.pullrefreshview.PullToRefreshBase.OnRefreshListener;
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
    private static Deal moreDeals;
    private asyncTask loadData;
    private RelativeLayout loading;
    private static DataHolder dataHolder;
    private Intent intent;
    private PullToRefreshListView PTL ;
    private ListViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.offerlist,null);
//        listView = (ListView) view.findViewById(R.id.list);
        PTL = (PullToRefreshListView) view.findViewById(R.id.pull_to_refresh_listview);

        PTL.setOnRefreshListener(new OnRefreshListener<ListView>() {

            @Override
            public void onPullDownToRefresh(
                    PullToRefreshBase<ListView> refreshView) {
                System.out.println("pull up refresh");
            }

            @Override
            public void onPullUpToRefresh(
                    PullToRefreshBase<ListView> refreshView) {
                System.out.println("update list");
                loadData = new asyncTask();
                loadData.execute("load more");
            }
        });



        PTL.getRefreshableView().setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        intent = new Intent(getActivity().getApplicationContext(), ProductDetail.class);
                        if (PTL.getRefreshableView().getHeaderViewsCount() > 0) {
                            DataHolder.setDealResult(deals.getResults().get(position -1));

                        } else {
                            DataHolder.setDealResult(deals.getResults().get(position));
                        }
                        DataHolder.setDealResult(deals.getResults().get(position));
                        startActivity(intent);
                    }
                });
        loading  = (RelativeLayout) view.findViewById(R.id.loadingPanel);
        loading.setVisibility(View.GONE);
        view.setBackgroundColor(getResources().getColor(R.color.white));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(DataHolder.getLimitedDeal(category) == null) {
            loadData = new asyncTask();
            loadData.execute("first load");
        }else{
            deals = DataHolder.getLimitedDeal(category);
            adapter = new ListViewAdapter(deals, getActivity().getApplicationContext());
            PTL.getRefreshableView().setAdapter(adapter);
        }
    }

    public void setTitle(String title,String category){
        this.title = title;
        this.category = category;

    }

    public class asyncTask extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... params) {
            try {
                webmethod = new Webmethod(getParentFragment().getActivity());
                deals = DataHolder.getLimitedDeal(category);
                if(params[0].equals("first load")) {
                    deals = webmethod.getDeals(category);
                    DataHolder.setLimitedDeal(category,deals);
                }else if(params[0].equals("load more")
                        &&deals.getNext()!=null
                        &&deals.getResults().size()!=0){
                    System.out.println("*****"+deals.getNext());
                    moreDeals = webmethod.getMoreDeals(deals.getNext());
                    DataHolder.setLimitedDeal(category,deals);
                }else{
                    return "No data";
                }
            }catch (IOException e){

            }catch (JSONException e){

            }
            return params[0];
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if(DataHolder.getLimitedDeal(category)==null)
            loading.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            loading.setVisibility(View.GONE);
            if(PTL != null
                    && deals.getResults().size() != 0
                    && getActivity() != null
                    && s.equals("first load")) {
//            if(listView != null && deals != null && getActivity() != null) {
                System.out.println("asynctask*****");
//                listView.setAdapter(new ListViewAdapter(deals, getActivity().getApplicationContext()));

                if (adapter == null) {
                    PTL.setScrollLoadEnabled(true);
                    adapter = new ListViewAdapter(deals, getActivity().getApplicationContext());
                    DataHolder.setDeal(deals);
                    PTL.getRefreshableView().setAdapter(adapter);
                } else {
                    adapter.notifyDataSetChanged();
                }
                onLoaded();

//                PTL.getRefreshableView().setAdapter(new ListViewAdapter(deals, getActivity().getApplicationContext()));
            }else if(s.equals("load more")){
                deals.setNext(moreDeals.getNext());
                PTL.setHasMoreData(true);
                for(Result deal:moreDeals.getResults()){
                    deals.getResults().add(deal);
                }
                DataHolder.setDeal(deals);
                adapter.notifyDataSetChanged();
                onLoaded();
            }else{
                onLoaded();
            }


//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    intent = new Intent(getActivity().getApplicationContext(), ProductDetail.class);
//                    DataHolder.setDealResult(deals.getResults().get(position));
//                    startActivity(intent);
//                }
//            });

            // onclick listener




        }
    }
    private void onLoaded() {
//        if(loadingView)
        PTL.onPullDownRefreshComplete();
        PTL.onPullUpRefreshComplete();
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
