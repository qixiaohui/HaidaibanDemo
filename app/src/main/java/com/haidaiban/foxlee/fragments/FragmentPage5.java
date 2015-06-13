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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.activitys.E1_MyAddress_Activity;
import com.haidaiban.foxlee.activitys.E1_MyMoney_Activity;
import com.haidaiban.foxlee.activitys.Login_Activity;
import com.haidaiban.foxlee.config.Constants;
import com.haidaiban.foxlee.model.profile.UserProfile;
import com.haidaiban.foxlee.webMethod.Webmethod;
import com.securepreferences.SecurePreferences;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.io.IOException;
import java.lang.Runnable;

public class FragmentPage5 extends Fragment{

    private static View view;
    private static Button button;
    private static Button get;
    private static TextView logout;
    private static TextView nickName;
    private static ImageView  icon;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static Intent intent;

    private FrameLayout myMoney ;
    private Webmethod webmethod;
    private FrameLayout myAdds;
    private UserProfile userProfile;
    private String userName;
    private GetUserProfile getUserProfile;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.e0_profile_head, null);
        userProfile = DataHolder.getUserProfile();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        logout = (TextView) view.findViewById(R.id.logout);
        sharedPreferences = new SecurePreferences(getActivity().getApplicationContext());
        userName = sharedPreferences.getString("userName","0");
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

        myMoney = (FrameLayout) getActivity().findViewById(R.id.profile_head_payment);
        myAdds = (FrameLayout) getActivity().findViewById(R.id.profile_head_ship);
        nickName = (TextView) getActivity().findViewById(R.id.nickName);
        icon = (ImageView) getActivity().findViewById(R.id.icon);


        myMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), E1_MyMoney_Activity.class);
                startActivity(i);
            }
        });
        myAdds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), E1_MyAddress_Activity.class);
                startActivity(i);
            }
        });

        //call async to get user profile
        getUserProfile = new GetUserProfile();
        getUserProfile.execute(userName);

    }

    public void loadData(){

        if(userProfile.getNickname()!=null) {
            nickName.setText(userProfile.getNickname());
        }else{
            nickName.setText(userProfile.getUser().getUsername());
        }

        if(userProfile.getIcon()!=null)
        Picasso.with(getActivity().getApplicationContext())
                .load(Constants.getLOGIN_URL()+userProfile.getIcon())
                .centerCrop()
                .resize(70, 70)
                .into(icon);
    }

    public class GetUserProfile extends AsyncTask<String,String,String>{
        @Override
        protected String doInBackground(String... params) {
            webmethod = new Webmethod(getActivity().getApplicationContext());
            try {
                userProfile = webmethod.isAgent(params[0]);
            }catch (IOException e){
                Toast.makeText(getActivity().getApplicationContext(),"can't load user profile, try later",Toast.LENGTH_LONG).show();
            }catch (JSONException e){
                Toast.makeText(getActivity().getApplicationContext(),"fail to parse user profile",Toast.LENGTH_LONG).show();
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
            loadData();
        }
    }

}