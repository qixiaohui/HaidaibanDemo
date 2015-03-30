package com.haidaiban.foxlee.activitys;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.haidaiban.foxlee.fragments.R;

import java.util.List;

/**
 * Created by jili on 3/28/15.
 */
public class Search_Activity extends ActionBarActivity implements android.support.v7.widget.SearchView.OnQueryTextListener{

    private SearchView mSearchView;
    private TextView mTx_Search ;

    private InputMethodManager mInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
        mTx_Search = (TextView) findViewById(R.id.tx_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

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
       setupSearchView(searchItem);

        return true;


    }


        @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
        private void setupSearchView(MenuItem searchItem) {

            if (isAlwaysExpanded()) {
                mSearchView.setIconifiedByDefault(false);
            } else {
                searchItem.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM
                        | MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
            }

            SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            if (searchManager != null) {
                List<SearchableInfo> searchables = searchManager.getSearchablesInGlobalSearch();

                SearchableInfo info = searchManager.getSearchableInfo(getComponentName());
                for (SearchableInfo inf : searchables) {
                    if (inf.getSuggestAuthority() != null
                            && inf.getSuggestAuthority().startsWith("applications")) {
                        info = inf;
                    }
                }
                mSearchView.setSearchableInfo(info);
            }

            mSearchView.setOnQueryTextListener(this);
        }


    public boolean onQueryTextChange(String newText) {
        mTx_Search.setText("Query = " + newText);
        return false;
    }

    public boolean onQueryTextSubmit(String query) {
        mTx_Search.setText("Query = " + query + " : submitted");
        return false;
    }

    public boolean onClose() {
        mTx_Search.setText("Closed!");
        return false;
    }

    protected boolean isAlwaysExpanded() {
        return false;
    }
    }



