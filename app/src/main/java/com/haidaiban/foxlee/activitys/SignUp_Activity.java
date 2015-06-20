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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jili on 3/23/15.
 */
public class SignUp_Activity extends Activity {
    private EditText email;
    private EditText userName;
    private EditText passWord1;
    private EditText passWord2;
    private Button register;
    private Pattern pattern;
    private Matcher matcher;
    private Intent intent;
    private Webmethod webmethod;
    private RegisterAsync registerAsync;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);
        intent = new Intent(getApplicationContext(),Login_Activity.class);
        webmethod = new Webmethod(getApplicationContext());
        initView();
    }

    protected void initView() {
        email = (EditText) findViewById(R.id.signup_et_email);
        userName = (EditText) findViewById(R.id.sign_et_username);
        passWord1 = (EditText) findViewById(R.id.sign_et_ps);
        passWord2 = (EditText) findViewById(R.id.sign_et_psagain);
        register = (Button) findViewById(R.id.register);
        pattern = Pattern.compile(EMAIL_PATTERN);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().length()==0
                        ||userName.getText().toString().length()==0
                        ||passWord1.getText().toString().length()==0
                        ||passWord2.getText().toString().length()==0){
                    Toast.makeText(getApplicationContext(),"Please fill in all details",Toast.LENGTH_LONG).show();
                }

                else if(!pattern.matcher(email.getText().toString()).matches()){
                    Toast.makeText(getApplicationContext(),"Please input valid email address",Toast.LENGTH_LONG).show();
                }

                else if(!passWord1.getText().toString().equals(passWord2.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Please input same password",Toast.LENGTH_LONG).show();
                }

                else{

                    registerAsync = new RegisterAsync();
                    registerAsync.execute();
                }
            }
        });
    }

    public class RegisterAsync extends AsyncTask<String,String,String>{
        int result = 0;
        @Override
        protected String doInBackground(String... params) {
            try {
                result = webmethod.register(userName.getText().toString(),passWord1.getText().toString(),passWord2.getText().toString(),email.getText().toString());
            }catch (IOException e){

            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(result == 200){
                Toast.makeText(getApplicationContext(),"Please check your activivation email!",Toast.LENGTH_LONG).show();
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(getApplicationContext(),"Register failed please try later",Toast.LENGTH_LONG).show();
            }
        }
    }
}
