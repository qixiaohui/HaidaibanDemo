package com.haidaiban.foxlee.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.haidaiban.foxlee.activitys.Login_Activity;
import com.haidaiban.foxlee.webMethod.Webmethod;
import com.securepreferences.SecurePreferences;

import org.json.JSONException;

import java.io.IOException;
import java.lang.Runnable;

public class FragmentPage5 extends Fragment{

    private static View view;
    private static Button button;
    private static Button get;
    private static TextView logout;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static Intent intent;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.e0_profile_head, null);
		return view;
	}

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        logout = (TextView) view.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = new SecurePreferences(getActivity().getApplicationContext());
                editor = sharedPreferences.edit();
                editor.remove("userName");
                editor.remove("password");
                editor.remove("token");
                editor.commit();
                intent = new Intent(getActivity(), Login_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                getActivity().finish();
            }
        });
//        button = (Button) view.findViewById(R.id.login);
//        get = (Button) view.findViewById(R.id.get);
//        sharedPreferences = new SecurePreferences(getActivity().getApplicationContext());
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                GetData getData = new GetData();
//                getData.execute();
//            }
//        });
//
//        get.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                loginAsync login = new loginAsync();
//                login.execute();
//            }
//        });
    }

}