package com.haidaiban.foxlee.fragments;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.haidaiban.foxlee.webMethod.Webmethod;
import com.securepreferences.SecurePreferences;

import org.json.JSONException;

import java.io.IOException;
import java.lang.Runnable;

public class FragmentPage5 extends Fragment{

    private View view;
    private Button button;
    private Button get;
    private static SharedPreferences sharedPreferences;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.fragment_5, null);
		return view;
	}

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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