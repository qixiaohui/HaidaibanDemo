package com.haidaiban.foxlee.fragments;

import java.io.IOException;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.activitys.Activity_PriceFill;
import com.haidaiban.foxlee.activitys.LimitedTimeOffer;
import com.haidaiban.foxlee.config.Constants;
import com.haidaiban.foxlee.model.message.Message;
import com.haidaiban.foxlee.model.message.Result;
import com.haidaiban.foxlee.webMethod.Webmethod;

public class FragmentPage1 extends Fragment{

    private View view;

    private SliderLayout slider;

    private Context context;
    private ImageView mBtn_discount;
    private ImageView mBtn_fillprice;
    private GetMessage getMessage;
    private Webmethod webmethod;
    private Message message;
    private RelativeLayout loading;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {


        context = container.getContext();


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

        getMessage = new GetMessage();
        getMessage.execute();

		return view;
	}



    private void initView() {

        slider = (SliderLayout)view.findViewById(R.id.slider);
        mBtn_discount = (ImageView) view.findViewById(R.id.btn_new_discount);
        mBtn_fillprice = (ImageView) view.findViewById(R.id.btn_fillprice);
        loading = (RelativeLayout) view.findViewById(R.id.loadingPanel);
        loading.setVisibility(View.GONE);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        System.out.println("on attachment"+slider);
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
        @Override
        protected String doInBackground(String... params) {
            webmethod = new Webmethod(getActivity().getApplicationContext());
            try {
                if(message == null) {
                    message = webmethod.getMessage();
                }
            }catch (IOException e){

            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            loading.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            loading.setVisibility(View.GONE);
            HashMap<String, String> urlMap = new HashMap<String,String>();
            for(Result result : message.getResults()){
                TextSliderView sliderView = new TextSliderView(context);
                sliderView
                        .description(result.getMessage())
                        .image(Constants.getLOGIN_URL()+result.getImage())
                        .setScaleType(BaseSliderView.ScaleType.Fit);
                slider.addSlider(sliderView);
            }
//            urlMap.put("Haniba","http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
//            urlMap.put("big bang","http://tvfiles.alphacoders.com/100/hdclearart-10.png");
//            urlMap.put("house of cards","http://cdn3.nflximg.net/images/3093/2043093.jpg");
//            urlMap.put("game of throne","http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

//            HashMap<String,Integer> fileMap = new HashMap<String,Integer>();
//            fileMap.put("Haniba",R.drawable.hannibal);
//            fileMap.put("bang bang",R.drawable.bigbang);
//            fileMap.put("house of cards",R.drawable.house);
//            fileMap.put("game of throne",R.drawable.game_of_thrones);


            slider.setPresetTransformer(SliderLayout.Transformer.Accordion);
            slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            slider.setCustomAnimation(new DescriptionAnimation());
            slider.setDuration(4000);

        }
    }
}
