package com.haidaiban.foxlee.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.Util.Utility;
import com.haidaiban.foxlee.config.Constants;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.deal.Result;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

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
    private Boolean flag = false;
    int [] size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productdetail);
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


        size = Utility.getWindowSize(this);
        deal = getDeal();
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
    }

    public Result getDeal(){

        return DataHolder.getDealResult();
    }
}
