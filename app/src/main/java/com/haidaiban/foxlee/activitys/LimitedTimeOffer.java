package com.haidaiban.foxlee.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBarActivity;

import com.haidaiban.foxlee.fragments.LimitedDealFragment;
import com.haidaiban.foxlee.fragments.R;

/**
 * Created by qixiaohui on 3/14/15.
 */
public class LimitedTimeOffer extends ActionBarActivity{
    private FragmentTabHost tabHost;
    private String [] titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.limitedoffer);

        titles = getResources().getStringArray(R.array.tabTitle);
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

        tabHost.setup(this,getSupportFragmentManager(),R.id.tabcontent);

        for(String title : titles){
            tabHost.addTab(tabHost.newTabSpec(title).setIndicator(title),LimitedDealFragment.class,null);
        }


    }


}
