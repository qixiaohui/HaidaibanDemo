package com.haidaiban.foxlee.activitys;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

import com.haidaiban.foxlee.fragments.R;

/**
 * Created by jili on 4/7/15.
 */
public class OrderDetails extends Activity {

    private static ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c1_orderdetail_layout);

    }
}
