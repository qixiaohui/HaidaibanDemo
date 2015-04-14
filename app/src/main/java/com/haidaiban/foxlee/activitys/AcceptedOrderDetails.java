package com.haidaiban.foxlee.activitys;

import android.app.Activity;
import android.os.Bundle;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.offer.Result;

/**
 * Created by tom on 4/13/15.
 */
public class AcceptedOrderDetails extends Activity{
    private Result acceptedOffer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d0offer_details);
        acceptedOffer = DataHolder.getAcceptedOffer();
    }
}
