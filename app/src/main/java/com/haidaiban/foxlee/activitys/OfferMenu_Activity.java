package com.haidaiban.foxlee.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.haidaiban.foxlee.fragments.FragmentPage1;
import com.haidaiban.foxlee.fragments.Fragment_MyTempOffer;
import com.haidaiban.foxlee.fragments.R;

/**
 * Created by jili on 3/17/15.
 */
public class OfferMenu_Activity extends Activity {

    //initview

    private Button btn_OfferMenu_AddNew;
    private Button btn_OfferMenu_Review;
    private Button btn_OfferMenu_Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_menu);
        initView();
        initClick();
    }

    // click event
    private void initClick() {
        btn_OfferMenu_AddNew.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), Activity_PriceFill.class);
                startActivity(intent);

            }
        });


     //
        btn_OfferMenu_Review.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), MainTabActivity.class);
                startActivity(intent);
            }
        });

        btn_OfferMenu_Back.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(), MainTabActivity.class);
                startActivity(intent);

            }
        });

    }

    private void initView() {

        btn_OfferMenu_AddNew = (Button) findViewById(R.id.btn_offermenu_new);
        btn_OfferMenu_Review = (Button) findViewById(R.id.btn_offermenu_review);
        btn_OfferMenu_Back = (Button) findViewById(R.id.btn_offermenu_back);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
