package com.haidaiban.foxlee.fragments;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.logging.Handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.activitys.Activity_PriceFill;
import com.haidaiban.foxlee.activitys.LimitedTimeOffer;
import com.haidaiban.foxlee.config.Constants;
import com.haidaiban.foxlee.model.message.Message;
import com.haidaiban.foxlee.model.message.Result;
import com.haidaiban.foxlee.webMethod.Webmethod;
import com.squareup.picasso.Picasso;

public class FragmentPage1 extends Fragment{

    private View view;

    private Context context;
    private ImageView mBtn_discount;
    private ImageView mBtn_fillprice;
    private LinearLayout gallery;
    private WebView webView;
    private Webmethod webmethod;
    private Message message;
    private Button button;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

        context = container.getContext();
        webmethod = new Webmethod(context);

        view = inflater.inflate(R.layout.fragment_1, null);
    //init views ;
        initView();

        mBtn_fillprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Activity_PriceFill.class);
                startActivity(intent);
            }
        });

        mBtn_discount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LimitedTimeOffer.class);
                startActivity(intent);
            }
        });

		return view;
	}


    private void initView() {

        mBtn_discount = (ImageView) view.findViewById(R.id.btn_new_discount);
        mBtn_fillprice = (ImageView) view.findViewById(R.id.btn_fillprice);
        gallery = (LinearLayout) view.findViewById(R.id.gallery);
//        webView = (WebView) view.findViewById(R.id.webview);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setLoadWithOverviewMode(true);
//        webView.getSettings().setUseWideViewPort(true);
//        webView.loadUrl("file:///android_asset/imageslider.html");

    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(DataHolder.getMessage() != null){
            message = DataHolder.getMessage();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        DataHolder.setMessage(message);
    }

    public class getMessage extends AsyncTask<String,String,String>{
        @Override
        protected String doInBackground(String... params) {
            try {
                message = webmethod.getMessage();
            }catch (IOException e){

            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            for(int i=0; i<message.getResults().size(); i++){

                button = new Button(context);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                        ViewGroup.LayoutParams.FILL_PARENT);
                button.setRes
                gallery.addView(button);
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }
}
