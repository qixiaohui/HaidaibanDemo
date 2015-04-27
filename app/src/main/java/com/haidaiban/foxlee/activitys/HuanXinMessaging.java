package com.haidaiban.foxlee.activitys;

import android.app.Activity;
import android.os.Bundle;

import com.easemob.chat.EMChat;
import com.haidaiban.foxlee.fragments.R;

/**
 * Created by tom on 4/26/15.
 */
public class HuanXinMessaging extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.haidaiban_messaging);
        EMChat.getInstance().init(getApplicationContext());
        EMChat.getInstance().setDebugMode(true);
    }
}
