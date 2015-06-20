package com.haidaiban.foxlee.fragments;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Handler;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.Util.Utility;
import com.haidaiban.foxlee.activitys.Activity_PriceFill;
import com.haidaiban.foxlee.activitys.LimitedTimeOffer;
import com.haidaiban.foxlee.activitys.WebActivity;
import com.haidaiban.foxlee.config.Constants;
import com.haidaiban.foxlee.model.message.Message;
import com.haidaiban.foxlee.model.message.Result;
import com.haidaiban.foxlee.webMethod.Webmethod;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

public class FragmentPage1 extends Fragment{

    private View view;

    private Context context;
    private ImageView mBtn_discount;
    private ImageView mBtn_fillprice;
    private Webmethod webmethod;
    private Message message;
    private GetMessage getMessage;
    private RelativeLayout progressBar;
    private Intent intent;
    private LinearLayout container;
    private LinearLayout child;
    private int[] size;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

        context = container.getContext();
        webmethod = new Webmethod(context);
        intent = new Intent(getActivity().getApplicationContext(),WebActivity.class);
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

        if(message==null) {
            getMessage = new GetMessage();
            getMessage.execute();
        }else{
            setAd();
        }

		return view;
	}


    private void initView() {

        size = Utility.getWindowSize(getActivity().getApplicationContext());
        mBtn_discount = (ImageView) view.findViewById(R.id.btn_new_discount);
        mBtn_fillprice = (ImageView) view.findViewById(R.id.btn_fillprice);
        progressBar = (RelativeLayout) view.findViewById(R.id.loadingPanel);
        container = (LinearLayout) view.findViewById(R.id.container);
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

    public class GetMessage extends AsyncTask<String,String,String>{

        Bitmap bmp ;
        @Override
        protected String doInBackground(String... params) {
            try {
                message = webmethod.getMessage();
            }catch (IOException e){

            }
            DataHolder.setMessage(message);  //make sure if dataholder has message then it must also has bitmaps
            return null;
        }

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @SuppressLint("NewApi")
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            setAd();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }

    public void setAd(){

        for (int i = 0; i < message.getResults().size(); i++) {

            child = new LinearLayout(getActivity().getApplicationContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, (int) size[1]/3);
            layoutParams.setMargins(5, 5, 5, 5);
            child.setTag(i);
            ImageView image = new ImageView(getActivity().getApplicationContext());
            image.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(getActivity().getApplicationContext())
                    .load(Constants.getLOGIN_URL() + message.getResults().get(i).getImage())
                    .resize(size[0],Math.round(size[1]*2/5))
                    .into(image);
            System.out.println(Constants.getLoginUrl1() + message.getResults().get(i).getImage());
            child.addView(image);
            container.addView(child, layoutParams);
        }
        progressBar.setVisibility(View.GONE);

        for(int i = 0; i< message.getResults().size(); i++){
            container.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent = new Intent(getActivity().getApplicationContext(),WebActivity.class);
                    intent.putExtra("url",message.getResults().get(Integer.parseInt(v.getTag().toString())).getWebLink());
                    startActivity(intent);
                }
            });
        }
    }
}
