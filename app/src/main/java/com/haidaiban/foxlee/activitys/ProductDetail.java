package com.haidaiban.foxlee.activitys;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.Util.Utility;
import com.haidaiban.foxlee.adapter.CommentAdapter;
import com.haidaiban.foxlee.config.Constants;
import com.haidaiban.foxlee.fragments.CommentFragment;
import com.haidaiban.foxlee.fragments.LimitedDealFragment;
import com.haidaiban.foxlee.fragments.ProductDetailFragment;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.comment.Comment;
import com.haidaiban.foxlee.model.deal.Result;
import com.haidaiban.foxlee.webMethod.Webmethod;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by qixiaohui on 3/27/15.
 */
public class ProductDetail extends ActionBarActivity {
    private String [] titles;
    FragmentTabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productdetailmain);

        getSupportActionBar().setHomeButtonEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // mTx_Search = (TextView) findViewById(R.id.tx_search);
        titles = getResources().getStringArray(R.array.productDetailTitle);
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

        tabHost.setup(this, getSupportFragmentManager(), R.id.tabcontent);
        tabHost.setBackgroundColor(getResources().getColor(R.color.list_divider));

        for (String title : titles) {
            if (title.equals("商品")) {
                tabHost.addTab(tabHost.newTabSpec(title).setIndicator(title), ProductDetailFragment.class, null);
            } else if (title.equals("评论")) {
                tabHost.addTab(tabHost.newTabSpec(title).setIndicator(title), CommentFragment.class, null);
            }
        }
    }

    @Override
    // Inflate the menu items for use in the action bar
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);


        return super.onCreateOptionsMenu(menu);

    }
    @Override
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


}
