package com.haidaiban.foxlee.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.Util.Utility;
import com.haidaiban.foxlee.config.Constants;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.deal.Result;
import com.squareup.picasso.Picasso;

/**
 * Created by qixiaohui on 3/27/15.
 */
public class ProductDetail extends Activity {
    ImageView productImage;
    TextView title;
    Result deal;
    int [] size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productdetail);
        productImage = (ImageView) findViewById(R.id.productImage);
        title = (TextView) findViewById(R.id.title);

        size = Utility.getWindowSize(this);
        deal = getDeal();
        Picasso.with(this)
                .load(Constants.getLOGIN_URL() + deal.getImage())
                .resize((int)(size[0]*0.95),(int)(size[1]*0.37))
                .into(productImage);
        title.setText(deal.getTitle());
    }

    public Result getDeal(){

        return DataHolder.getDealResult();
    }
}
