package com.haidaiban.foxlee.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.haidaiban.foxlee.webMethod.Webmethod;

import java.io.IOException;

/**
 * Created by qixiaohui on 3/14/15.
 */
public class Register extends Fragment{
    private View view;
    private Button registerBtn;
    private EditText userName;
    private EditText password1;
    private EditText password2;
    private EditText email;
    private String userNameStr;
    private String password1Str;
    private String password2Str;
    private String emailStr;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.register,null);
        registerBtn = (Button) view.findViewById(R.id.login);
        userName = (EditText) view.findViewById(R.id.username);
        email = (EditText) view.findViewById(R.id.email);
        password1 = (EditText) view.findViewById(R.id.password1);
        password2 = (EditText) view.findViewById(R.id.password2);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyncTask asyncTask = new asyncTask();
                asyncTask.execute(userNameStr, password1Str, password2Str, emailStr);
            }
        });

    }

    public class asyncTask extends AsyncTask<String,String,String>{
        @Override
        protected String doInBackground(String... params) {
            Webmethod webmethod = new Webmethod(getActivity().getApplicationContext());
            try {
                webmethod.register(params[0], params[1], params[2], params[3]);
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
        }
    }
}
