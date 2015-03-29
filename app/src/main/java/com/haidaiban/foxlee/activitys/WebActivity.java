package com.haidaiban.foxlee.activitys;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.WebView;

import com.haidaiban.foxlee.fragments.R;
import com.securepreferences.SecurePreferences;

/**
 * Created by qixiaohui on 3/29/15.
 */
public class WebActivity extends Activity {
    WebView webView;
    Intent intent;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webactivity);
        webView = (WebView) findViewById(R.id.webview);
        intent = getIntent();
        url = intent.getStringExtra("url");
        webView.loadUrl(url);
    }
}
