package com.haidaiban.foxlee.fragments;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haidaiban.foxlee.adapter.TabPagerAdapter;
import com.haidaiban.foxlee.google.SlidingTabLayout;

import java.util.List;
import java.util.Vector;

public class D0_OrderFragment extends Fragment{

    private String title;
    private View view;
    private ViewPager viewPager;
    private TabPagerAdapter tabPagerAdapter;
    private String[] categorys;
    private List<Fragment> fragments;
    private DealList dealList;
    private ActionBar actionBar;
    private SlidingTabLayout slidingTabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.d0offer_fragment,null);
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        slidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.fragment_c_viewpager));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categorys = getActivity().getResources().getStringArray(R.array.OrderTitle);
        fragments = new Vector<Fragment>();
        for(String category: categorys){
            dealList = new DealList();
            dealList.setTitle(title,category);
            fragments.add(dealList);
        }
//        getSupportFragmentManager()
        tabPagerAdapter = new TabPagerAdapter(getChildFragmentManager(),fragments,categorys);
        viewPager.setAdapter(tabPagerAdapter);
        viewPager.setOffscreenPageLimit(10);
        // Center the tabs in the layout
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(viewPager);

    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
}