package com.haidaiban.foxlee.ui;

/**
 *
 */

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.activitys.Activity_PriceFill;
import com.haidaiban.foxlee.activitys.WebActivity;
import com.haidaiban.foxlee.config.Constants;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.deal.Result;
import com.haidaiban.foxlee.webMethod.Webmethod;

import java.io.IOException;

/**
 * 发送comment
 *
 * Created by jili on 3/30/15.
 *
 *         Time:2015年3月22日
 */
public class RecommendationDialog extends Dialog {

    private TextView tv_UseCoupon;
    private TextView tv_GoOfficialSite;
    private Context mContext;
    private static int mTheme = R.style.CustomDialog;
    private static int num = 0;
    private static int request_code = 1000;
    private static int mode = 0;            //to differentiate between from camera and from photo gallery
    private Asyn asyn;
    private Webmethod webmethod;
    private Result deal;
    private int status;
    private Intent intent;

    String str_getInput;

    /**
     * 自定义Dialog
     *
     * @param context
     *            上下文
     * @param "activity"
     *            Dialog所在的Activity，用于点击“确定”按钮后finish所在的Activity
     * @param "title"
     *            文本内容
     * @param "btnString"
     *            按钮上的文字
     * @param theme
     *            样式
     */
    public RecommendationDialog(Context context, int theme, int num) {
        super(context, theme);
        this.mContext = context;
        this.num = num;
    }

    public RecommendationDialog(Context context) {
        super(context, mTheme);
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_recommendation);
        tv_UseCoupon = (TextView) findViewById(R.id.dia_tv_usecoupon);
        tv_GoOfficialSite = (TextView) findViewById(R.id.dia_tv_officialsite);


        tv_UseCoupon
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        /***
                         *  here : use this coupon
                         */
                    intent = new Intent(mContext, Activity_PriceFill.class);
                    intent.putExtra("flag",1);
                     mContext.startActivity(intent);
                     }
                });


        tv_GoOfficialSite
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        /***
                         *  here : Go to official site
                         */
                    intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra("url", DataHolder.getQuotelistResult().getWebLink());
                    mContext.startActivity(intent);
                    }
                });
    }



    public Result getDeal() {

        return DataHolder.getDealResult();
    }

    public static int getNum() {
        return num;
    }

    public static int getMode() {
        return mode;
    }

    public class Asyn extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... params) {
            webmethod = new Webmethod(getContext());
            deal = getDeal();
            try {
                status = webmethod.addComment(Integer.toString(deal.getId()), str_getInput);
            }catch (IOException e){

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
            if(status == 201){
                Toast.makeText(getContext()
                        ,getContext().getResources().getString(R.string.commentSuccess)
                        ,Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getContext()
                        ,getContext().getResources().getString(R.string.commentFailed)
                        ,Toast.LENGTH_LONG).show();
            }
        }
    }
}