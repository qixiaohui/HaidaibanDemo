package com.haidaiban.foxlee.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.config.Constants;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.order.Quote;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

/**
 * Created by tom on 6/27/15.
 */
public class Dialog_Quote extends Dialog {
    private static Context context;
    private static Quote quote;
    private static TextView quantity;
    private static TextView link;
    private static TextView version;
    private static TextView price;
    private static TextView coupon;
    private static TextView freeShipping;
    private static TextView shippingMethod;
    private static TextView tip;
    private static ImageView productImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_quote);
        quantity = (TextView) findViewById(R.id.quantity);
        link = (TextView) findViewById(R.id.link);
        version = (TextView) findViewById(R.id.version);
        price = (TextView) findViewById(R.id.price);
        coupon = (TextView) findViewById(R.id.coupon);
        freeShipping = (TextView) findViewById(R.id.freeshipping);
        shippingMethod = (TextView) findViewById(R.id.shippingmethod);
        tip = (TextView) findViewById(R.id.tip);
        productImage = (ImageView) findViewById(R.id.productImage);

        quote = DataHolder.getQuote();

        initData();
    }

    public void initData(){
        if(quote.getQuantity()!=null){
            quantity.setText(Integer.toString(quote.getQuantity()));
        }

        if(quote.getWebLink()!=null){
            link.setText(quote.getWebLink());
        }

        if(quote.getStyle()!=null){
            version.setText(quote.getStyle());
        }

        if(quote.getPrice()!=null){
            price.setText((String)quote.getPrice());
        }

        if(quote.getCoupon()!=null){
            coupon.setText(quote.getCoupon());
        }

        if(quote.getCustom()!=null){
            freeShipping.setText(quote.getCustom());
        }

        if(quote.getShipping()!=null){
            shippingMethod.setText((String)quote.getShipping());
        }

        if(quote.getRemark()!=null){
            tip.setText(quote.getRemark());
        }


        if(quote.getDeal()==null || quote.getDeal().getImage()==null){
            Picasso.with(context)
                    .load(R.drawable.productnoimage)
                    .centerCrop()
                    .resize(200, 250)
                    .into(productImage);
        }else {
            Picasso.with(context)
                    .load(Constants.getLOGIN_URL() + quote.getDeal().getImage())
                    .resize(200,250)
                    .centerCrop()
                    .into(productImage);
        }
    }

    public Dialog_Quote(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }
}
