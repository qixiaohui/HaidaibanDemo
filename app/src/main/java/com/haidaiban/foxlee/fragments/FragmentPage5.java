package com.haidaiban.foxlee.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.haidaiban.foxlee.webMethod.Webmethod;

import java.io.IOException;

public class FragmentPage5 extends Fragment{

    private View view;
    private Button button;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.fragment_5, null);
        button = (Button) view.findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                AsyncHttpClient client = new AsyncHttpClient();
//                client.post("http://stage.sanqtech.com:7777/login/",new AsyncHttpResponseHandler() {
//
//                    @Override
//                    public void onStart(){
//                        RequestParams param = new RequestParams();
//                        param.put("login","foxlee");
//                        param.put("password","liji1025");
//                    }
//
//                    @Override
//                    public void onSuccess(int i, Header[] headers, byte[] bytes) {
//                        System.out.println("success");
//                        System.out.println(headers[0]);
//                    }
//
//                    @Override
//                    public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
//                        System.out.println("failed");
//                    }
//                });
                loginAsync login = new loginAsync();
                login.execute();
            }
        });
		return view;
	}


    public class loginAsync extends AsyncTask<String,String,String>{
        @Override
        protected String doInBackground(String... params) {
            final Webmethod webMethod = new Webmethod(getActivity().getApplicationContext());
            try {
                webMethod.get();
                webMethod.post();
            }catch (IOException e){
                System.out.println("%%%%%IOException");
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