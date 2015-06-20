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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.haidaiban.foxlee.Util.DataHolder;
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
    private LinearLayout gallery;
    private WebView webView;
    private Webmethod webmethod;
    private Message message;
    private ImageLoader imageLoader;
    private Bitmap bitmap1;
    private Bitmap bitmap2;
    private Bitmap bitmap3;
    private BitmapDrawable bitmapDrawable1;
    private BitmapDrawable bitmapDrawable2;
    private BitmapDrawable bitmapDrawable3;
    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private GetMessage getMessage;
    private RelativeLayout progressBar;
    private Intent intent;
    private ArrayList<BitmapDrawable> caches;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

        context = container.getContext();
        webmethod = new Webmethod(context);
        imageLoader = ImageLoader.getInstance();
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

        if((message = DataHolder.getMessage())==null) {
            getMessage = new GetMessage();
            getMessage.execute();
        }else{
            progressBar.setVisibility(View.GONE);
            caches = DataHolder.getBitmapDrawables();
            imageButton1.setBackgroundDrawable(caches.get(0));
            imageButton2.setBackgroundDrawable(caches.get(1));
            imageButton3.setBackgroundDrawable(caches.get(2));

            imageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("url", message.getResults().get(0).getWebLink());
                    startActivity(intent);
                }
            });

            imageButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("url",message.getResults().get(1).getWebLink());
                    startActivity(intent);
                }
            });

            imageButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("url",message.getResults().get(2).getWebLink());
                    startActivity(intent);
                }
            });
        }

		return view;
	}


    private void initView() {

        mBtn_discount = (ImageView) view.findViewById(R.id.btn_new_discount);
        mBtn_fillprice = (ImageView) view.findViewById(R.id.btn_fillprice);
        gallery = (LinearLayout) view.findViewById(R.id.gallery);
        imageButton1 = (ImageButton) view.findViewById(R.id.ad1);
        imageButton2 = (ImageButton) view.findViewById(R.id.ad2);
        imageButton3 = (ImageButton) view.findViewById(R.id.ad3);
        progressBar = (RelativeLayout) view.findViewById(R.id.loadingPanel);
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
            System.out.println();
            // synchronously cache the bitmap in backgorund thread
            bitmap1 = imageLoader.loadImageSync(Constants.getLOGIN_URL()+message.getResults().get(0).getImage());
            bitmap2 = imageLoader.loadImageSync(Constants.getLOGIN_URL()+message.getResults().get(1).getImage());
            bitmap3 = imageLoader.loadImageSync(Constants.getLOGIN_URL()+message.getResults().get(2).getImage());
            bitmapDrawable1 = new BitmapDrawable(getResources(),bitmap1);
            bitmapDrawable2 = new BitmapDrawable(getResources(),bitmap2);
            bitmapDrawable3 = new BitmapDrawable(getResources(),bitmap3);
            caches = new ArrayList<BitmapDrawable>();
            caches.add(bitmapDrawable1);
            caches.add(bitmapDrawable2);
            caches.add(bitmapDrawable3);
            DataHolder.setBitmapDrawables(caches);
            DataHolder.setMessage(message);  //make sure if dataholder has message then it must also has bitmaps
            caches = null;
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
            imageButton1.setBackgroundDrawable(bitmapDrawable1);
            imageButton2.setBackgroundDrawable(bitmapDrawable2);
            imageButton3.setBackgroundDrawable(bitmapDrawable3);
            progressBar.setVisibility(View.GONE);
            imageButton1.setOnTouchListener(new View.OnTouchListener() {
                int buttonX1 = 0;
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            buttonX1 = Math.round(event.getX());
                        case MotionEvent.ACTION_UP:
                            if(Math.abs(Math.round(event.getX())-buttonX1)<10){
                                intent.putExtra("url", message.getResults().get(0).getWebLink());
                                startActivity(intent);
                            }
                    }
                    return false;
                }
            });

            imageButton2.setOnTouchListener(new View.OnTouchListener() {
                int buttonX2 = 0;
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            buttonX2 = Math.round(event.getX());
                        case MotionEvent.ACTION_UP:
                            if(Math.abs(Math.round(event.getX())-buttonX2)<10){
                                intent.putExtra("url", message.getResults().get(1).getWebLink());
                                startActivity(intent);
                            }
                    }
                    return false;
                }
            });

            imageButton3.setOnTouchListener(new View.OnTouchListener() {
                int buttonX3 = 0;
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            buttonX3 = Math.round(event.getX());
                        case MotionEvent.ACTION_UP:
                            if(Math.abs(Math.round(event.getX())-buttonX3)<10){
                                intent.putExtra("url", message.getResults().get(2).getWebLink());
                                startActivity(intent);
                            }
                    }
                    return false;
                }
            });
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }
}
