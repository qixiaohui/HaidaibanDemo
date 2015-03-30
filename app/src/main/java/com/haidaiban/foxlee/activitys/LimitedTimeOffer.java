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
            // Assumes current activity is the searchable activity
           // setupSearchView(searchItem);

            return true;


        }
//    private void setupSearchView(MenuItem searchItem) {
//
//        if (isAlwaysExpanded()) {
//            mSearchView.setIconifiedByDefault(false);
//        } else {
//            searchItem.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM
//                    | MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
//        }
//
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        if (searchManager != null) {
//            List<SearchableInfo> searchables = searchManager.getSearchablesInGlobalSearch();
//
//            SearchableInfo info = searchManager.getSearchableInfo(getComponentName());
//            for (SearchableInfo inf : searchables) {
//                if (inf.getSuggestAuthority() != null
//                        && inf.getSuggestAuthority().startsWith("applications")) {
//                    info = inf;
//                }
//            }
//            mSearchView.setSearchableInfo(info);
//        }
//
//        mSearchView.setOnQueryTextListener( this);
//    }
//
//
//    public boolean onQueryTextChange(String newText) {
//        mTx_Search.setText("Query = " + newText);
//        return false;
//    }
//
//    public boolean onQueryTextSubmit(String query) {
//        mTx_Search.setText("Query = " + query + " : submitted");
//        return false;
//    }
//
//    public boolean onClose() {
//        mTx_Search.setText("Closed!");
//        return false;
//    }
//
//    protected boolean isAlwaysExpanded() {
//        return false;
//    }
//


//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle presses on the action bar items
//        switch (item.getItemId()) {
//            case R.id.item_search:
//                openSearch();
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//    private void openSearch() {
//        Intent intent = new Intent();
//        intent.setClass(getApplicationContext(),Search_Activity.class);
//        startActivity(intent);
//    }
}
