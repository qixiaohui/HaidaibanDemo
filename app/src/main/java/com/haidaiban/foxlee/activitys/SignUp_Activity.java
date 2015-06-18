package com.haidaiban.foxlee.activitys;

import com.haidaiban.foxlee.Base.BaseActivity;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.token.Token;
import com.haidaiban.foxlee.webMethod.Webmethod;
import com.securepreferences.SecurePreferences;

import org.json.JSONException;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by jili on 3/23/15.
 */
public class SignUp_Activity extends BaseActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);
    }
    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
