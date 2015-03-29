package com.haidaiban.foxlee.activitys;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.Util.Utility;
import com.haidaiban.foxlee.config.Constants;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.deal.Result;
import com.haidaiban.foxlee.webMethod.Webmethod;
import com.squareup.picasso.Picasso;

import java.io.IOException;

/**
 * Created by qixiaohui on 3/27/15.
 */
public class ProductDetail extends Activity {
    ImageView productImage;
    TextView title;
    Result deal;
    TextView brand;
    TextView like;
    TextView view;
    TextView store;
    TextView link;
    TextView disocunt;
    TextView coupon;
    TextView shippingDiscount;
    TextView shippingCoupon;
    TextView specialEvent;
    TextView endDate;
    TextView tip;
    ImageView arrowUp;
    TableLayout info;
    ImageView bookmark;
    LinearLayout bookmarkButton;
    TextView website;
    Asyn asyn;
    Intent intent;
    HorizontalScrollView horizontalScrollView;
    LinearLayout container;
    LinearLayout child;
    TextView youMightLike;
    private Boolean flag = false;
    int [] size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productdetail);

        deal = getDeal();

        productImage = (ImageView) findViewById(R.id.productImage);
        title = (TextView) findViewById(R.id.title);
        brand = (TextView) findViewById(R.id.brand);
        like = (TextView) findViewById(R.id.like);
        view = (TextView) findViewById(R.id.view);
        store = (TextView) findViewById(R.id.store);
        link = (TextView) findViewById(R.id.link);
        disocunt = (TextView) findViewById(R.id.discount);
        coupon = (TextView) findViewById(R.id.coupon);
        shippingDiscount = (TextView) findViewById(R.id.shippingdiscount);
        shippingCoupon = (TextView) findViewById(R.id.shippingcoupon);
        specialEvent = (TextView) findViewById(R.id.special);
        endDate = (TextView) findViewById(R.id.enddate);
        tip = (TextView) findViewById(R.id.tip);
        arrowUp = (ImageView) findViewById(R.id.arrowup);
        info = (TableLayout) findViewById(R.id.info);
        bookmark = (ImageView) findViewById(R.id.bookmark);
        bookmarkButton = (LinearLayout) findViewById(R.id.bookmarkbutton);
        website = (TextView) findViewById(R.id.website);
        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.horizontal);
        youMightLike = (TextView) findViewById(R.id.related);

        size = Utility.getWindowSize(this);
        if(deal.getRecommendations().size()>0) {
            horizontalScrollView.setVisibility(View.VISIBLE);
            youMightLike.setVisibility(View.VISIBLE);
            container = (LinearLayout) findViewById(R.id.container);
            for(int i=0; i<deal.getRecommendations().size(); i++){
                child = new LinearLayout(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        (int)(size[0]/3), (int)(size[1]/4));
                layoutParams.setMargins(5, 0, 5, 0);
                child.setOrientation(1);
                child.setTag(i);
                ImageView image = new ImageView(this);
                TextView relateTitle = new TextView(this);
                relateTitle.setTextColor(getResources().getColor(R.color.black));
                relateTitle.setTextSize(10);
                relateTitle.setText(deal.getRecommendations().get(i).getTitle());
                image.setScaleType(ImageView.ScaleType.FIT_XY);
                Picasso.with(this)
                        .load(Constants.getLOGIN_URL() + deal.getRecommendations().get(i).getImage())
                        .into(image);
                child.addView(image);
                child.addView(relateTitle);
                container.addView(child, layoutParams);
                image.getLayoutParams().height = (int)(size[1]/5);
            }
        }

        Picasso.with(this)
                .load(Constants.getLOGIN_URL() + deal.getImage())
                .resize((int)(size[0]*0.90),(int)(size[1]*0.35))
                .into(productImage);
        title.setText(deal.getTitle());
        brand.setText(getResources().getString(R.string.brand)+": "+deal.getBrand());
        view.setText(Integer.toString(deal.getReadCount()));
        like.setText(deal.getLikeCount()==null?"0":Integer.toString(deal.getLikeCount()));
        store.setText(deal.getStore());
        link.setText(deal.getWeblink());
        disocunt.setText(deal.getDiscMain());
        coupon.setText(deal.getCouponMain());
        shippingDiscount.setText(deal.getDiscShip());
        shippingCoupon.setText(deal.getCouponShip());
        specialEvent.setText(deal.getInstrSpecial()==null?"":deal.getInstrSpecial());
        endDate.setText(deal.getEndDate()==null?"":deal.getEndDate());
        tip.setText(deal.getTip()==null?"":deal.getTip());
        info.setVisibility(View.GONE);
        if(deal.getIsLike()){
            bookmark.setImageDrawable(getResources().getDrawable(R.drawable.mark));
        }else{
            bookmark.setImageDrawable(getResources().getDrawable(R.drawable.unmark));
        }


        arrowUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = !flag;
                if(flag){
                    info.setVisibility(View.VISIBLE);
                    arrowUp.setImageDrawable(getResources().getDrawable(R.drawable.arrowup));
                }else{
                    info.setVisibility(View.GONE);
                    arrowUp.setImageDrawable(getResources().getDrawable(R.drawable.arrowdown));
                }
            }
        });

        bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyn = new Asyn();
                asyn.execute("bookmark");
            }
        });

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),WebActivity.class);
                intent.putExtra("url",deal.getWeblink());
                startActivity(intent);
            }
        });



    }

    public Result getDeal(){

        return DataHolder.getDealResult();
    }

    public class Asyn extends AsyncTask<String,String,String>{
        @Override
        protected String doInBackground(String... params) {
            if(params[0].equals("bookmark")){
                try{
                    Webmethod webmethod = new Webmethod(getApplicationContext());
                    webmethod.bookmark(Integer.toString(deal.getId()));
                }catch (IOException e){

                }
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
