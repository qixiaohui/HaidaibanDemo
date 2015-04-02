package com.haidaiban.foxlee.activitys;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.haidaiban.foxlee.fragments.LimitedDealFragment;
import com.haidaiban.foxlee.fragments.R;

import java.util.List;

/**
 * Created by qixiaohui on 3/14/15.
 */
public class LimitedTimeOffer extends ActionBarActivity {
    private FragmentTabHost tabHost;
    private String [] titles;
    private ActionBar actonBar;

    //search bar
    private SearchView mSearchView;
    private TextView mTx_Search ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.limitedoffer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


       // mTx_Search = (TextView) findViewById(R.id.tx_search);
        titles = getResources().getStringArray(R.array.tabTitle);
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

        tabHost.setup(this,getSupportFragmentManager(),R.id.tabcontent);

        for(String title : titles){
            tabHost.addTab(tabHost.newTabSpec(title).setIndicator(title),LimitedDealFragment.class,null);
        }


    }
    @Override
        // Inflate the menu items for use in the action bar
        public boolean onCreateOptionsMenu(Menu menu) {
            super.onCreateOptionsMenu(menu);
            // Inflate the menu; this adds items to the action bar if it is present.
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_search, menu);


        return super.onCreateOptionsMenu(menu);

        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.item_search:
                openSearch_Activty();
                return true;
//            case R.id.action_compose:
//                composeMessage();
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openSearch_Activty() {

       Intent  intent = new Intent(getApplicationContext(),Search_Activity.class);
        startActivity(intent);

    }


}


