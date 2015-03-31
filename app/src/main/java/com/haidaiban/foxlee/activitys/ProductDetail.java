package com.haidaiban.foxlee.activitys;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBarActivity;
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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // mTx_Search = (TextView) findViewById(R.id.tx_search);
        titles = getResources().getStringArray(R.array.productDetailTitle);
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

        tabHost.setup(this,getSupportFragmentManager(),R.id.tabcontent);
        tabHost.setBackgroundColor(getResources().getColor(R.color.list_divider));

        for(String title : titles){
            if(title.equals("商品")) {
                tabHost.addTab(tabHost.newTabSpec(title).setIndicator(title), ProductDetailFragment.class, null);
            }else if(title.equals("评论")){
                tabHost.addTab(tabHost.newTabSpec(title).setIndicator(title), CommentFragment.class, null);
            }
        }

        setTabColor(tabHost);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                setTabColor(tabHost);
            }
        });
    }

    public static void setTabColor(TabHost tabhost) {
        for(int i=0;i<tabhost.getTabWidget().getChildCount();i++) {
            tabhost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#FFFFFF")); //unselected
        }
        tabhost.getTabWidget().getChildAt(tabhost.getCurrentTab()).setBackgroundColor(Color.parseColor("#87ceeb")); // selected
    }
}
