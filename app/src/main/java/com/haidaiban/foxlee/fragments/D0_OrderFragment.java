package com.haidaiban.foxlee.fragments;

import android.app.ActionBar;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.adapter.TabPagerAdapter;
import com.haidaiban.foxlee.google.SlidingTabLayout;
import com.haidaiban.foxlee.model.offer.Offer;
import com.haidaiban.foxlee.model.offer.Result;
import com.haidaiban.foxlee.webMethod.Webmethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class D0_OrderFragment extends Fragment{

    private String title;
    private View view;
    private ViewPager viewPager;
    private TabPagerAdapter tabPagerAdapter;
    private String[] categorys;
    private List<Fragment> fragments;
    private AcceptedOfferList acceptedOfferList;
    private ActionBar actionBar;
    private SlidingTabLayout slidingTabLayout;
    private Async async;
    private Offer offer;
    private Webmethod webmethod;
    private ChildMethod childMethod;
    private Offer offerPaid;
    private Offer offerBuying;
    private Offer offerDelivering;
    private Offer offerCompleted;
    private Offer offerCanceled;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.d0offer_fragment,null);
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        slidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.fragment_c_viewpager));
        offerPaid = new Offer();
        offerBuying = new Offer();
        offerDelivering = new Offer();
        offerCompleted = new Offer();
        offerCanceled = new Offer();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categorys = getActivity().getResources().getStringArray(R.array.OrderTitle);
        fragments = new Vector<Fragment>();
        int index = 0;
        for(String category: categorys){
            acceptedOfferList = new AcceptedOfferList();
            acceptedOfferList.setIndex(index);
            fragments.add(acceptedOfferList);
            index++;
        }
//        getSupportFragmentManager()
        tabPagerAdapter = new TabPagerAdapter(getChildFragmentManager(),fragments,categorys);
        viewPager.setAdapter(tabPagerAdapter);
        viewPager.setOffscreenPageLimit(10);
        // Center the tabs in the layout
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(viewPager);
        if(DataHolder.getOfferAll()==null) {
            async = new Async();
            async.execute();
        }
    }

    public void sortCategory(){

    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    public class Async extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... params) {
            webmethod = new Webmethod(getActivity().getApplicationContext());
            try {
                offer = webmethod.getAccepteddOffers();
            }catch (IOException e){

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
            offerPaid.setResults(new ArrayList<Result>());
            offerBuying.setResults(new ArrayList<Result>());
            offerDelivering.setResults(new ArrayList<Result>());
            offerCanceled.setResults(new ArrayList<Result>());
            DataHolder.setOfferAll(offer);
            for(int i=0; i<offer.getResults().size(); i++){
                if(offer
                        .getResults()
                        .get(i)
                        .getTransactionState()
                        .getState()
                        .equals(getActivity()
                                .getApplicationContext()
                                .getResources()
                                .getStringArray(R.array.OrderTitle)[1])
                        ||offer
                        .getResults()
                        .get(i)
                        .getTransactionState()
                        .getState()
                        .equals(getActivity()
                                .getApplicationContext()
                                .getResources()
                                .getString(R.string.paiedDeposit))){
                    offerPaid.getResults().add(offer.getResults().get(i));
                }else if(offer
                        .getResults()
                        .get(i)
                        .getTransactionState()
                        .getState()
                        .equals(getActivity()
                                .getApplicationContext()
                                .getResources()
                                .getStringArray(R.array.OrderTitle)[2])){
                    offerBuying.getResults().add(offer.getResults().get(i));
                }else if(offer
                        .getResults()
                        .get(i)
                        .getTransactionState()
                        .getState()
                        .equals(getActivity()
                                .getApplicationContext()
                                .getResources()
                                .getStringArray(R.array.OrderTitle)[3])){
                    offerDelivering.getResults().add(offer.getResults().get(i));
                }else if(offer
                        .getResults()
                        .get(i)
                        .getTransactionState()
                        .getState()
                        .equals(getActivity()
                                .getApplicationContext()
                                .getResources()
                                .getStringArray(R.array.OrderTitle)[4])){
                    offerCompleted.setResults(new ArrayList<Result>());
                    offerCompleted.getResults().add(offer.getResults().get(i));
                }else if(offer
                        .getResults()
                        .get(i)
                        .getTransactionState()
                        .getState()
                        .equals(getActivity()
                                .getApplicationContext()
                                .getResources()
                                .getStringArray(R.array.OrderTitle)[5])){
                    offerCanceled.getResults().add(offer.getResults().get(i));
                }
            }
            DataHolder.setOfferPaid(offerPaid);
            DataHolder.setOfferDelivering(offerDelivering);
            DataHolder.setOfferBuying(offerBuying);
            DataHolder.setOfferComplete(offerCompleted);
            DataHolder.setOfferCanceled(offerCanceled);
            for (int i=0; i<fragments.size(); i++){
                childMethod = (ChildMethod)fragments.get(i);
                childMethod.getData();
            }
        }
    }
}