package com.haidaiban.foxlee.fragments;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentManager;

import java.util.List;
import java.util.Vector;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.adapter.TabPagerAdapter;
import com.haidaiban.foxlee.google.SlidingTabLayout;
import com.haidaiban.foxlee.model.order.Order;
import com.haidaiban.foxlee.model.order.Result;

public class C_SentedOfferFragment extends Fragment implements ParentMethods{

    private String title;
    private View view;
    private ViewPager viewPager;
    private TabPagerAdapter tabPagerAdapter;
    private String[] categorys;
    private List<Fragment> fragments;
    private OrderList orderList;
    private ActionBar actionBar;
    private SlidingTabLayout slidingTabLayout;
    private int index;
    ChildMethod orderWaiting;
    ChildMethod orderAccepted;
    ChildMethod orderClosed;
    Order orderWaitingPojo;
    Order orderAcceptedPojo;
    Order orderClosedPojo;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.c0_sendedoffer,null);
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        slidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        return view;
    }

    public void setCustomerView(){


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categorys = getActivity().getResources().getStringArray(R.array.SendedPriceTitle);
        fragments = new Vector<Fragment>();
        index = 0;
        for(String category: categorys){
            orderList = new OrderList();
            orderList.setIndex(index);
            fragments.add(orderList);
            index++;
        }
//        getSupportFragmentManager()
        tabPagerAdapter = new TabPagerAdapter(getChildFragmentManager(),fragments,categorys);
        viewPager.setAdapter(tabPagerAdapter);
        viewPager.setOffscreenPageLimit(10);
        // Center the tabs in the layout
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(viewPager);
        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.fragment_c_viewpager));
        orderWaiting = (ChildMethod) fragments.get(1);
        orderAccepted = (ChildMethod) fragments.get(2);
        orderClosed = (ChildMethod) fragments.get(3);
        orderWaitingPojo = new Order();
        orderAcceptedPojo = new Order();
        orderClosedPojo = new Order();

    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    @Override
    public void setData() {
        for(Result result : DataHolder.getOrderAll().getResults()){
            if(result.getOpenOffers().size()>0){
                orderAcceptedPojo.getResults().add(result);
            }else{
                if(result.getIsOpen()){
                    orderWaitingPojo.getResults().add(result);
                }else {
                    orderClosedPojo.getResults().add(result);
                }
            }
        }
        DataHolder.setOrderAccepted(orderAcceptedPojo);
        orderAccepted.getData();
        DataHolder.setOrderWaiting(orderWaitingPojo);
        orderWaiting.getData();
        DataHolder.setOrderClosed(orderClosedPojo);
        orderClosed.getData();

    }
}