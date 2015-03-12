package com.haidaiban.foxlee.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haidaiban.foxlee.webMethod.Webmethod;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by qixiaohui on 3/10/15.
 */
public class Offers extends Fragment {
    private Webmethod webmethod;
    private JSONObject offer;
    GetData getData;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test_offers, null);
    }

    /*******
     * in this method you will get offer json object, the structure of this object is(after parse the json data, render the data on UI, in runOnUiThread method)
     * {
     "count": 1,
     "next": null,
     "previous": null,
     "results": [
     {
     "uid": "833278322918",
     "agent": {
     "user": 68,
     "icon": "/media/photos/profile/icons/thumbnails/2015/02/26/3510503895.JPG",
     "username": "foxdaiban"
     },
     "customer": {
     "id": 67,
     "icon": null,
     "username": "foxlee"
     },
     "order": "416566118391",
     "redistribute_count": 2,
     "offer_price": "1100.00",
     "price_adj": null,
     "down_payment": "1111.00",
     "internal_pay": true,
     "external_pay": false,
     "payment_link": null,
     "ext_pay_desc": null,
     "ext_pay_acct": null,
     "agent_remark": null,
     "counterquotes": [
     {
     "quote": {
     "customer": 67,
     "deal": {
     "uid": "7901182143",
     "title": "TOMS购买正价商品满$50即可享受优惠",
     "image": "/media/photos/deal/2014/11/15/2217493019.png"
     },
     "image0": null,
     "image1": null,
     "image2": null,
     "recommendation": null,
     "is_submitted": true,
     "title": "TOMS购买正价商品满$50即可享受优惠",
     "web_link": "http://www.toms.com/",
     "price": null,
     "coupon": "VETERANS;",
     "style": "",
     "quantity": 1,
     "shipping": null,
     "weight": null,
     "custom": "none",
     "direct_ship": "none",
     "remark": "使用折扣码VETERANS:现有购买正价商品满$50即可享受立减$10优惠",
     "uid": "978822350566",
     "order": "416566118391",
     "last_update": "2015-02-27T17:00:08.572Z",
     "is_favorite": false
     },
     "image0": null,
     "image1": null,
     "image2": null,
     "modifications": {
     "coupon": false,
     "weight": false,
     "remark": false,
     "image0": false,
     "direct_ship": false,
     "image1": false,
     "image2": false,
     "web_link": false,
     "shipping": false,
     "custom": false,
     "style": false,
     "title": false,
     "quantity": false,
     "price": false
     },
     "title": "TOMS购买正价商品满$50即可享受优惠",
     "web_link": "http://www.toms.com/",
     "price": null,
     "coupon": "VETERANS;",
     "style": "",
     "quantity": 1,
     "shipping": null,
     "weight": null,
     "custom": "none",
     "direct_ship": "none",
     "remark": "使用折扣码VETERANS:现有购买正价商品满$50即可享受立减$10优惠",
     "uid": "150055460039",
     "quote_price": null,
     "has_agent_activity": false
     },
     {
     "quote": {
     "customer": 67,
     "deal": {
     "uid": "1309425770",
     "title": "多款迷你唐卡Minnetonka休闲鞋，冬靴热卖",
     "image": "/media/photos/deal/2014/11/14/9431994775.png"
     },
     "image0": null,
     "image1": null,
     "image2": null,
     "recommendation": null,
     "is_submitted": true,
     "title": "多款迷你唐卡Minnetonka休闲鞋，冬靴热卖",
     "web_link": "http://www.amazon.com/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords=minnetonka",
     "price": null,
     "coupon": "",
     "style": "",
     "quantity": 1,
     "shipping": null,
     "weight": null,
     "custom": "none",
     "direct_ship": "none",
     "remark": "",
     "uid": "823363366065",
     "order": "416566118391",
     "last_update": "2015-02-27T17:14:01.173Z",
     "is_favorite": false
     },
     "image0": null,
     "image1": null,
     "image2": null,
     "modifications": {
     "coupon": false,
     "weight": false,
     "remark": false,
     "image0": false,
     "direct_ship": false,
     "image1": false,
     "image2": false,
     "web_link": false,
     "shipping": false,
     "custom": false,
     "style": false,
     "title": false,
     "quantity": false,
     "price": false
     },
     "title": "多款迷你唐卡Minnetonka休闲鞋，冬靴热卖",
     "web_link": "http://www.amazon.com/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords=minnetonka",
     "price": null,
     "coupon": "",
     "style": "",
     "quantity": 1,
     "shipping": null,
     "weight": null,
     "custom": "none",
     "direct_ship": "none",
     "remark": "",
     "uid": "386923389630",
     "quote_price": "1100.00",
     "has_agent_activity": true
     }
     ],
     "status": "open",
     "customer_declined": true,
     "decline_message": null,
     "create_date": "2015-02-27T17:21:46.332Z",
     "last_update": "2015-02-27T17:46:08.969Z",
     "last_activity_date": "2015-02-27T17:46:08.966Z",
     "last_customer_activity_date": "2015-02-27T17:26:30.311Z",
     "last_agent_activity_date": "2015-02-27T17:46:08.966Z",
     "has_agent_activity": false,
     "has_customer_activity": false,
     "has_counter_quote_activity": true,
     "has_new_agent_msg": false,
     "has_new_customer_msg": false,
     "has_new_price": false,
     "transaction_state": {},
     "is_content_locked": false
     }
     ]
     }
     * @param view
     * @param savedInstanceState
     */

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        getData = new GetData();
        getData.execute();

    }

    public class GetData extends AsyncTask<String,String,String>{
        @Override
        protected String doInBackground(String... params) {
            webmethod = new Webmethod(getActivity().getApplicationContext());
            try {
                offer = webmethod.get();
            }catch(JSONException e){

            }catch(IOException e){

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
