package com.haidaiban.foxlee.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.adapter.AcceptedOrderListAdapter;
import com.haidaiban.foxlee.adapter.OrderListAdapter;
import com.haidaiban.foxlee.model.offer.Offer;

/**
 * Created by tom on 4/11/15.
 */
public class AcceptedOfferList extends Fragment implements ChildMethod{
    private View view;
    private Offer offer;
    private int index;
    ListView list;
    RelativeLayout loading;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.acceptedorderlist, null);
        list = (ListView) view.findViewById(R.id.list);
        loading = (RelativeLayout) view.findViewById(R.id.loadingPanel);
        loading.setVisibility(View.VISIBLE);
        offer = new Offer();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        android.os.Handler handler = new android.os.Handler();
        switch (index){
            case 0:
                if(DataHolder.getOfferAll()!=null){
                    offer = DataHolder.getOfferAll();
                    if(offer.getResults()!=null)
                        list.setAdapter(new AcceptedOrderListAdapter((getActivity().getApplicationContext()), offer, index, getActivity()));
                    loading.setVisibility(View.INVISIBLE);
                    break;
                }
            case 1:
                if(DataHolder.getOfferPaid()!=null){
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            offer = DataHolder.getOfferPaid();
                            if(offer.getResults()!=null)
                                list.setAdapter(new AcceptedOrderListAdapter((getActivity().getApplicationContext()), offer, index, getActivity()));
                            loading.setVisibility(View.INVISIBLE);
                        }
                    }, 100);
                    break;
                }
            case 2:
                if(DataHolder.getOfferBuying()!=null){
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            offer = DataHolder.getOfferBuying();
                            if(offer.getResults()!=null)
                                list.setAdapter(new AcceptedOrderListAdapter((getActivity().getApplicationContext()), offer, index, getActivity()));
                            loading.setVisibility(View.INVISIBLE);
                        }
                    }, 200);
                    break;
                }
            case 3:
                if(DataHolder.getOfferDelivering()!=null){
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            offer = DataHolder.getOfferDelivering();
                            if(offer.getResults()!=null)
                                list.setAdapter(new AcceptedOrderListAdapter((getActivity().getApplicationContext()), offer, index, getActivity()));
                            loading.setVisibility(View.INVISIBLE);
                            }
                        }, 300);
                    break;
                }
            case 4:
                if(DataHolder.getOfferComplete()!=null){
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            offer = DataHolder.getOfferComplete();
                            if(offer.getResults()!=null)
                                list.setAdapter(new AcceptedOrderListAdapter((getActivity().getApplicationContext()), offer, index, getActivity()));
                            loading.setVisibility(View.INVISIBLE);

                        }
                    }, 400);
                    break;
                }
            case 5:
                if(DataHolder.getOfferCanceled()!=null){
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            offer = DataHolder.getOfferCanceled();
                            if(offer.getResults()!=null)
                                list.setAdapter(new AcceptedOrderListAdapter((getActivity().getApplicationContext()), offer, index, getActivity()));
                            loading.setVisibility(View.INVISIBLE);
                        }
                    }, 500);
                    break;
                }
        }
    }

    @Override
    public void getData() {
        switch (index){
            case 0:
                offer = DataHolder.getOfferAll();
                if(offer.getResults()!=null)
                list.setAdapter(new AcceptedOrderListAdapter((getActivity().getApplicationContext()), offer, index, getActivity()));
                loading.setVisibility(View.INVISIBLE);
                break;
            case 1:
                offer = DataHolder.getOfferPaid();
                if(offer.getResults()!=null)
                list.setAdapter(new AcceptedOrderListAdapter((getActivity().getApplicationContext()), offer, index, getActivity()));
                loading.setVisibility(View.INVISIBLE);
                break;
            case 2:
                offer = DataHolder.getOfferBuying();
                if(offer.getResults()!=null)
                list.setAdapter(new AcceptedOrderListAdapter((getActivity().getApplicationContext()), offer, index, getActivity()));
                loading.setVisibility(View.INVISIBLE);
                break;
            case 3:
                offer = DataHolder.getOfferDelivering();
                if(offer.getResults()!=null)
                list.setAdapter(new AcceptedOrderListAdapter((getActivity().getApplicationContext()), offer, index, getActivity()));
                loading.setVisibility(View.INVISIBLE);
                break;
            case 4:
                offer = DataHolder.getOfferComplete();
                if(offer.getResults()!=null)
                list.setAdapter(new AcceptedOrderListAdapter((getActivity().getApplicationContext()), offer, index, getActivity()));
                loading.setVisibility(View.INVISIBLE);
                break;
            case 5:
                offer = DataHolder.getOfferCanceled();
                if(offer.getResults()!=null)
                list.setAdapter(new AcceptedOrderListAdapter((getActivity().getApplicationContext()), offer, index, getActivity()));
                loading.setVisibility(View.INVISIBLE);
                break;
        }
    }

    public void setIndex(int index){
        this.index = index;
    }
}
