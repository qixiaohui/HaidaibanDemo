package com.haidaiban.foxlee.activitys;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.adapter.ListViewAdapter;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.deal.Deal;
import com.haidaiban.foxlee.webMethod.Webmethod;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by jili on 3/28/15.
 */
public class Search_Activity extends ActionBarActivity implements android.support.v7.widget.SearchView.OnQueryTextListener{

    private SearchView mSearchView;
    private TextView mTx_Search ;
    private Webmethod webmethod;
    private Asyn asyn;
    private Deal deals;
    private InputMethodManager mInput;
    private ListView listView;
    private RelativeLayout loading;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.search_layout);
        mTx_Search = (TextView) findViewById(R.id.tx_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView = (ListView) findViewById(R.id.list);
        loading  = (RelativeLayout) findViewById(R.id.loadingPanel);
        loading.setVisibility(View.GONE);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search_activity, menu);
        MenuItem searchItem = menu.findItem(R.id.item_search);


        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchItem.expandActionView();
        mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        Log.i("sss", "is null ====" + mSearchView);
        // Assumes current activity is the searchable activity
        //       setupSearchView(searchItem);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                asyn = new Asyn();
                asyn.execute(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        mSearchView.onActionViewExpanded();

        return true;


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {

            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
        return true;
    }

    public class Asyn extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... params) {
            webmethod = new Webmethod(getApplicationContext());
            try {
                deals = webmethod.getSearch(params[0]);
            }catch (IOException e){

            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            listView.setVisibility(View.GONE);
            loading.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            loading.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
            if(listView != null && deals != null) {
                System.out.println("asynctask*****");
                listView.setAdapter(new ListViewAdapter(deals, getApplicationContext()));
            }

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    intent = new Intent(getApplicationContext(), ProductDetail.class);
                    DataHolder.setDealResult(deals.getResults().get(position));
                    startActivity(intent);
                }
            });
        }
    }
    }



