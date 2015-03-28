package com.haidaiban.foxlee.activitys;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.haidaiban.foxlee.fragments.LimitedDealFragment;
import com.haidaiban.foxlee.fragments.R;

/**
 * Created by qixiaohui on 3/14/15.
 */
public class LimitedTimeOffer extends ActionBarActivity{
    private FragmentTabHost tabHost;
    private String [] titles;
    private ActionBar actonBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.limitedoffer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        titles = getResources().getStringArray(R.array.tabTitle);
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

        tabHost.setup(this,getSupportFragmentManager(),R.id.tabcontent);

        for(String title : titles){
            tabHost.addTab(tabHost.newTabSpec(title).setIndicator(title),LimitedDealFragment.class,null);
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.menu_search:
                openSearch();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openSearch() {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(),Search_Activity.class);
        startActivity(intent);
    }
}
