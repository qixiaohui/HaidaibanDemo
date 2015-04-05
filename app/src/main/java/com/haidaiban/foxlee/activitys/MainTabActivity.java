package com.haidaiban.foxlee.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;

import com.haidaiban.foxlee.fragments.C_SentedOfferFragment;
import com.haidaiban.foxlee.fragments.D0_OrderFragment;
import com.haidaiban.foxlee.fragments.FragmentPage1;
import com.haidaiban.foxlee.fragments.FragmentPage2;
import com.haidaiban.foxlee.fragments.FragmentPage5;
import com.haidaiban.foxlee.fragments.R;

/**
 * ji li 3.2.2015
 */
public class MainTabActivity extends FragmentActivity{	
	private FragmentTabHost mTabHost;

	private LayoutInflater layoutInflater;
		
	// each fragment
	private Class fragmentArray[] = {FragmentPage1.class,FragmentPage2.class,C_SentedOfferFragment.class,D0_OrderFragment.class,FragmentPage5.class};
	
	//底部菜单 图片
	private int mImageViewArray[] = {R.drawable.tab_home_btn,R.drawable.tab_a1_btn,R.drawable.tab_c2_btn,
									 R.drawable.tab_d3_btn,R.drawable.tab_d4_btn};
	
	//private String mTextviewArray[] = {"菜单", "待发询价", "已发询价", "订单", "帮助"};
	private String mTextviewArray[] = {"菜单", "待发询价", "已发询价", "订单", "帮助"};

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tab_layout);
        
        initView();
    }
	 

	private void initView(){
		layoutInflater = LayoutInflater.from(this);
				
		mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);	
		
		int count = fragmentArray.length;


		for(int i = 0; i < count; i++){	
			TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
			mTabHost.addTab(tabSpec, fragmentArray[i], null);
			mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.color.white);
		}
	}

	private View getTabItemView(int index){
		View view = layoutInflater.inflate(R.layout.tab_item_view, null);
	
		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mImageViewArray[index]);
		
		//TextView textView = (TextView) view.findViewById(R.id.textview);
		//textView.setText(mTextviewArray[index]);
	
		return view;
	}
}
