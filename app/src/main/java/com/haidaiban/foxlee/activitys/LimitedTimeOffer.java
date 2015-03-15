package com.haidaiban.foxlee.activitys;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.haidaiban.foxlee.adapter.TabPagerAdapter;
import com.haidaiban.foxlee.fragments.LimitedDealFragment;
import com.haidaiban.foxlee.fragments.R;
import java.util.List;

/**
 * Created by qixiaohui on 3/14/15.
 */
public class LimitedTimeOffer extends FragmentActivity implements ActionBar.TabListener{
    private TabPagerAdapter pagerAdapter;
    private LimitedDealFragment limitedDealFragment;
    private ViewPager viewPager;
    private ActionBar actionBar;
    private FragmentManager fragmentManager;
    private List<Fragment> fragments;
    private String []  titles;

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        titles = getResources().getStringArray(R.array.tabTitle);


        setContentView(R.layout.limitedoffer);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        fragmentManager = this.getSupportFragmentManager();

        for(String title : titles){
            limitedDealFragment = new LimitedDealFragment();
            limitedDealFragment.setTitle(title);
            fragments.add(new LimitedDealFragment());
        }

        pagerAdapter = new TabPagerAdapter(fragmentManager,fragments);

        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setCurrentItem(0);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for(String title : titles){
            actionBar.addTab(actionBar.newTab().setText(title));
        }


    }


}
