package com.haidaiban.foxlee.activitys;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.webMethod.Webmethod;
import com.securepreferences.SecurePreferences;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by jili on 3/23/15.
 */
public class Login_Activity extends Activity {
    private static ActionBar actionBar;
    private static Button login;
    private static TextView register;
    private static EditText userNameEdit;
    private static EditText passwordEdit;
    private static String userName;
    private static String password;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static Intent intent;

    @Override
    protected void onStart() {
        super.onStart();
        actionBar = getActionBar();
        actionBar.hide();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = new SecurePreferences(this);
        if(sharedPreferences.contains("token")){
            intent = new Intent(this,MainTabActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
        setContentView(R.layout.signin_layout);
        register = (TextView) findViewById(R.id.register);
        login = (Button) findViewById(R.id.login);
        userNameEdit = (EditText) findViewById(R.id.username);
        passwordEdit = (EditText) findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = userNameEdit.getText().toString();
                password = passwordEdit.getText().toString();
                loginAsync login = new loginAsync();
                login.execute(new String [] {userName,password});
            }
        });

    }

    public class loginAsync extends AsyncTask<String,String,String> {
        @Override
        protected String doInBackground(String... params){
            final Webmethod webMethod = new Webmethod(getApplicationContext());
            try {
//                if(sharedPreferences.contains("token")){
                //webMethod.get();
                if(webMethod.post(params[0],params[1])==200){
                    editor = sharedPreferences.edit();
                    editor.putString("userName",params[0]);
                    editor.putString("password",params[1]);
                    editor.commit();
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            //update ui here
                            // display toast here
                            Toast.makeText(getApplicationContext(), "login success", Toast.LENGTH_LONG).show();
                        }
                    });

                    intent = new Intent(getApplicationContext(),MainTabActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
//                }else{
//                    Toast.makeText(getActivity().getApplicationContext(),"Already login",Toast.LENGTH_SHORT).show();
//                }
            }catch (IOException e){
                System.out.println("%%%%%IOException");
            }catch (JSONException e){
                System.out.println("%%%%%JSONException");
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        //update ui here
                        // display toast here
                        Toast.makeText(getApplicationContext(), "login fail", Toast.LENGTH_LONG).show();
                    }
                });
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
        }
    }
}
