package com.haidaiban.foxlee.fragments;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.Vector;

import com.haidaiban.foxlee.adapter.TabPagerAdapter;
import com.haidaiban.foxlee.google.SlidingTabLayout;

/**
 * Created by qixiaohui on 3/14/15.
 */
public class LimitedDealFragment extends Fragment {
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
        view  = inflater.inflate(R.layout.sublimitedoffer,null);
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        slidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categorys = getActivity().getResources().getStringArray(R.array.category);
        fragments = new Vector<Fragment>();
        for(String category: categorys){
            dealList = new DealList();
            dealList.setTitle(title,category);
            fragments.add(dealList);
        }
        tabPagerAdapter = new TabPagerAdapter(getActivity().getSupportFragmentManager(),fragments,categorys);
        viewPager.setAdapter(tabPagerAdapter);
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
