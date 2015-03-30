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
            MenuItem searchItem = menu.findItem(R.id.item_search);


            SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);
            Log.i("sss", "is null ====" + mSearchView);
            mSearchView.setQueryHint("查找");
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextChange(String newText) {
                //Log.e("onQueryTextChange", "called");
                return false;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {


                // Do your task here

                Toast.makeText(getApplicationContext(), "search test", Toast.LENGTH_LONG).show();

                return false;
            }

        });


            return true;


        }

}
