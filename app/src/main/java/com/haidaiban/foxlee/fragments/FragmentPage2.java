package com.haidaiban.foxlee.fragments;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.haidaiban.foxlee.Util.Utility;
import com.haidaiban.foxlee.webMethod.Webmethod;
import com.securepreferences.SecurePreferences;

import org.json.JSONException;

import java.io.IOException;

public class FragmentPage2 extends Fragment{
    View view;
    Button login;
    Button register;
    EditText userNameEdit;
    EditText passwordEdit;
    private String userName;
    private String password;
    private SharedPreferences sharedPreferences;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.login, null);
        login = (Button) view.findViewById(R.id.login);
        register = (Button) view.findViewById(R.id.register);
        sharedPreferences = new SecurePreferences(getActivity().getApplicationContext());
        userNameEdit = (EditText) view.findViewById(R.id.loginaccount);
        passwordEdit = (EditText) view.findViewById(R.id.loginpassword);
		return view;
	}

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(sharedPreferences.contains("token")){

            Utility.redirect(getFragmentManager(), R.id.realtabcontent,new Fragment_MyTempOffer());

        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = userNameEdit.getText().toString();
                password = passwordEdit.getText().toString();
                loginAsync login = new loginAsync();
                login.execute(new String [] {userName,password});
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.redirect(getFragmentManager(),R.id.realtabcontent,new Register());
            }
        });
    }

    public class loginAsync extends AsyncTask<String,String,String> {
        @Override
        protected String doInBackground(String... params){
            final Webmethod webMethod = new Webmethod(getActivity().getApplicationContext());
            try {
//                if(sharedPreferences.contains("token")){
                //webMethod.get();
                if(webMethod.post(params[0],params[1])==200){
                    getActivity().runOnUiThread(new Runnable(){

                        @Override
                        public void run(){
                            //update ui here
                            // display toast here
                            Toast.makeText(getActivity().getApplicationContext(),"login success",Toast.LENGTH_LONG).show();
                        }
                    });

                    Utility.redirect(getFragmentManager(), R.id.realtabcontent, new Fragment_MyTempOffer());

                }
//                }else{
//                    Toast.makeText(getActivity().getApplicationContext(),"Already login",Toast.LENGTH_SHORT).show();
//                }
            }catch (IOException e){
                System.out.println("%%%%%IOException");
            }catch (JSONException e){
                System.out.println("%%%%%JSONException");
                getActivity().runOnUiThread(new Runnable(){

                    @Override
                    public void run(){
                        //update ui here
                        // display toast here
                        Toast.makeText(getActivity().getApplicationContext(),"login fail",Toast.LENGTH_LONG).show();
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