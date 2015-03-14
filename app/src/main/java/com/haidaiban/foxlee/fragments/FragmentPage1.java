package com.haidaiban.foxlee.fragments;

import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.haidaiban.foxlee.activitys.Activity_PriceFill;

public class FragmentPage1 extends Fragment{

    private View view;

    private SliderLayout slider;

    private Context context;
    private ImageView mBtn_discount;
    private ImageView mBtn_fillprice;

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

        HashMap<String, String> urlMap = new HashMap<String,String>();
        urlMap.put("Haniba","http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        urlMap.put("big bang","http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        urlMap.put("house of cards","http://cdn3.nflximg.net/images/3093/2043093.jpg");
        urlMap.put("game of throne","http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String,Integer> fileMap = new HashMap<String,Integer>();
        fileMap.put("Haniba",R.drawable.hannibal);
        fileMap.put("bang bang",R.drawable.bigbang);
        fileMap.put("house of cards",R.drawable.house);
        fileMap.put("game of throne",R.drawable.game_of_thrones);

        System.out.println(fileMap+"map");

        for(String name : fileMap.keySet()){
            TextSliderView sliderView = new TextSliderView(context);
            sliderView
                    .description(name)
                    .image(fileMap.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            slider.addSlider(sliderView);

        }

        slider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        slider.setCustomAnimation(new DescriptionAnimation());
        slider.setDuration(4000);

		return view;
	}

    private void initView() {

        slider = (SliderLayout)view.findViewById(R.id.slider);
        mBtn_discount = (ImageView) view.findViewById(R.id.btn_new_discount);
        mBtn_fillprice = (ImageView) view.findViewById(R.id.btn_fillprice);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        System.out.println("on attachment"+slider);
    }
}
