package com.haidaiban.foxlee.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.Util.Utility;
import com.haidaiban.foxlee.activitys.Activity_PriceFill;
import com.haidaiban.foxlee.activitys.WebActivity;
import com.haidaiban.foxlee.adapter.CommentAdapter;
import com.haidaiban.foxlee.config.Constants;
import com.haidaiban.foxlee.model.comment.Comment;
import com.haidaiban.foxlee.model.deal.Result;
import com.haidaiban.foxlee.ui.RecommendationDialog;
import com.haidaiban.foxlee.ui.SentCommentDialog;
import com.haidaiban.foxlee.webMethod.Webmethod;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by tom on 3/30/15.
 */
public class ProductDetailFragment extends Fragment {

  public static  String TAG = "PDF";

    ImageView productImage;
    TextView title;
    Result deal;
    TextView brand;
    TextView like;
    TextView viewCount;
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
    TextView useCoupon;
    Webmethod webmethod;
    com.haidaiban.foxlee.model.quotelist.Result quoteList;
    ArrayList<String> titleArray;
    ArrayList<String> weblinkArray;
    ArrayList<String> image0Array;
    ArrayList<String> priceArray;
//    final int[] index = new int[] {0};
     int[] index = new int[] {0};
    private Boolean flag = false;
    int[] size;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.productdetail, null);
        deal = getDeal();
        asyn = new Asyn();

        productImage = (ImageView) view.findViewById(R.id.productImage);
        title = (TextView) view.findViewById(R.id.title);
        brand = (TextView) view.findViewById(R.id.brand);
        like = (TextView) view.findViewById(R.id.like);
        viewCount = (TextView) view.findViewById(R.id.view);
        store = (TextView) view.findViewById(R.id.store);
        link = (TextView) view.findViewById(R.id.link);
        disocunt = (TextView) view.findViewById(R.id.discount);
        coupon = (TextView) view.findViewById(R.id.coupon);
        shippingDiscount = (TextView) view.findViewById(R.id.shippingdiscount);
        shippingCoupon = (TextView) view.findViewById(R.id.shippingcoupon);
        specialEvent = (TextView) view.findViewById(R.id.special);
        endDate = (TextView) view.findViewById(R.id.enddate);
        tip = (TextView) view.findViewById(R.id.tip);
        arrowUp = (ImageView) view.findViewById(R.id.arrowup);
        info = (TableLayout) view.findViewById(R.id.info);
        bookmark = (ImageView) view.findViewById(R.id.bookmark);
        bookmarkButton = (LinearLayout) view.findViewById(R.id.bookmarkbutton);
        website = (TextView) view.findViewById(R.id.website);
        horizontalScrollView = (HorizontalScrollView) view.findViewById(R.id.horizontal);
        youMightLike = (TextView) view.findViewById(R.id.related);
        useCoupon = (TextView) view.findViewById(R.id.usecoupon);

        titleArray = new ArrayList<String>();
        weblinkArray = new ArrayList<String>();
        image0Array = new ArrayList<String>();
        priceArray = new ArrayList<String>();

        asyn.execute("comment");

        size = Utility.getWindowSize(getActivity().getApplicationContext());
        if (deal.getRecommendations().size() > 0) {
            horizontalScrollView.setVisibility(View.VISIBLE);
            youMightLike.setVisibility(View.VISIBLE);

            container = (LinearLayout) view.findViewById(R.id.container);
            for (int i = 0; i < deal.getRecommendations().size(); i++) {
                titleArray.add(deal.getRecommendations().get(i).getTitle());
                weblinkArray.add(deal.getRecommendations().get(i).getWeblink());
                image0Array.add(deal.getRecommendations().get(i).getImage());
                priceArray.add(deal.getRecommendations().get(i).getFullPrice());

                child = new LinearLayout(getActivity().getApplicationContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        (int) (size[0] / 3), (int) (size[1] / 4));
                layoutParams.setMargins(5, 0, 5, 5);
                child.setOrientation(1);
                child.setTag(i);
                ImageView image = new ImageView(getActivity().getApplicationContext());
                TextView relateTitle = new TextView(getActivity().getApplicationContext());
                relateTitle.setTextColor(getResources().getColor(R.color.black));
                relateTitle.setTextSize(10);
                relateTitle.setText(deal.getRecommendations().get(i).getTitle());
                image.setScaleType(ImageView.ScaleType.FIT_XY);
                Picasso.with(getActivity().getApplicationContext())
                        .load(Constants.getLOGIN_URL() + deal.getRecommendations().get(i).getImage())
                        .into(image);
                child.addView(image);
                child.addView(relateTitle);
                container.addView(child, layoutParams);

                image.getLayoutParams().height = (int) (size[1] / 5);
            }
        }
        for(index[0]=0; index[0]<container.getChildCount(); index[0]++){
            container.getChildAt(index[0]).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println(index[0]+"&&&&&&&");
                    Log.d(TAG, "======>"+index[0]);
                    quoteList = new com.haidaiban.foxlee.model.quotelist.Result();

                    quoteList.setTitle(titleArray.get(index[0] - 1) + " @" + deal.getTitle());
                    quoteList.setQuantity(1);
                    quoteList.setWebLink(weblinkArray.get(index[0] - 1));
                    quoteList.setImage0(image0Array.get(index[0]-1));
                    quoteList.setPrice(priceArray.get(index[0] - 1));
                    quoteList.setCoupon(deal.getCouponMain());
                    quoteList.setRemark(deal.getDiscMain());
                    DataHolder.setQuotelistResult(quoteList);
                    showRecomment_Dialog();
                    Log.d(TAG, "======>"+index[0]);
                }
            });
        }


        Picasso.with(getActivity().getApplicationContext())
                .load(Constants.getLOGIN_URL() + deal.getImage())
                .resize((int) (size[0] * 0.90), (int) (size[1] * 0.35))
                .into(productImage);
        title.setText(deal.getTitle());
        brand.setText(getResources().getString(R.string.brand) + ": " + deal.getBrand());
        viewCount.setText(Integer.toString(deal.getReadCount()));
        like.setText(deal.getLikeCount() == null ? "0" : Integer.toString(deal.getLikeCount()));
        store.setText(deal.getStore());
        link.setText(deal.getWeblink());
        disocunt.setText(deal.getDiscMain());
        coupon.setText(deal.getCouponMain());
        shippingDiscount.setText(deal.getDiscShip());
        shippingCoupon.setText(deal.getCouponShip());
        specialEvent.setText(deal.getInstrSpecial() == null ? "" : deal.getInstrSpecial());
        endDate.setText(deal.getEndDate() == null ? "" : deal.getEndDate());
        tip.setText(deal.getTip() == null ? "" : deal.getTip());
        info.setVisibility(View.GONE);
        if (deal.getIsLike()) {
            bookmark.setImageDrawable(getResources().getDrawable(R.drawable.mark));
        } else {
            bookmark.setImageDrawable(getResources().getDrawable(R.drawable.unmark));
        }

        arrowUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = !flag;
                if (flag) {
                    info.setVisibility(View.VISIBLE);
                    arrowUp.setImageDrawable(getResources().getDrawable(R.drawable.arrowup));
                } else {
                    info.setVisibility(View.GONE);
                    arrowUp.setImageDrawable(getResources().getDrawable(R.drawable.arrowdown));
                }
            }
        });

        bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyn.execute("bookmark");
            }
        });

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity().getApplicationContext(), WebActivity.class);
                intent.putExtra("url", deal.getWeblink());
                startActivity(intent);
            }
        });

        useCoupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity().getApplicationContext(), Activity_PriceFill.class);
                quoteList = new com.haidaiban.foxlee.model.quotelist.Result();
                quoteList.setTitle(deal.getTitle());
                quoteList.setQuantity(1);
                quoteList.setWebLink(deal.getWeblink());
                quoteList.setCoupon(deal.getCouponMain());
                quoteList.setRemark(deal.getDiscMain());
                DataHolder.setQuotelistResult(quoteList);
                intent.putExtra("flag",2);
                startActivity(intent);
            }
        });
        return view;
    }

    private void showRecomment_Dialog() {
//  new SentCommentDialog(getActivity(), R.style.CustomDialog).show();
        new RecommendationDialog(getActivity()).show();

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    public Result getDeal() {

        return DataHolder.getDealResult();
    }

    public class Asyn extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {

            if (params[0].equals("bookmark")) {
                try {
                    webmethod = new Webmethod(getActivity().getApplicationContext());
                    if (!deal.getIsLike()) {
                        if (webmethod.bookmark(Integer.toString(deal.getId())) == 200) {
                            deal.setIsLike(true);
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    bookmark.setImageDrawable(getResources().getDrawable(R.drawable.mark));
                                    Toast.makeText(getActivity().getApplicationContext()
                                            , getResources().getString(R.string.likeSuccess)
                                            , Toast.LENGTH_LONG)
                                            .show();
                                    ;
                                }
                            });
                        }
                    } else {
                        if (webmethod.deleteBookmark(Integer.toString(deal.getId())) == 200) {
                            deal.setIsLike(false);
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    bookmark.setImageDrawable(getResources().getDrawable(R.drawable.unmark));
                                    Toast.makeText(getActivity().getApplicationContext()
                                            , getResources().getString(R.string.unlikeSuccess), Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    }
                } catch (IOException e) {

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
