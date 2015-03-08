package com.haidaiban.foxlee.fragments;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentManager;

import java.util.List;
import java.util.Vector;

import com.haidaiban.foxlee.pagers.GameFragment;
import com.haidaiban.foxlee.pagers.MovieFragment;
import com.haidaiban.foxlee.pagers.MusicFragment;
import com.haidaiban.foxlee.pagers.TabPagerAdapter;

public class FragmentPage3 extends Fragment implements ActionBar.TabListener{

    private View view;
    private ViewPager viewPager;
    private TabPagerAdapter tabPagerAdapter;
    private ActionBar actionBar;
    private FragmentManager fragmentManager;
    private String [] titles = {"Game","Music","Movie"};
    private List<Fragment> fragments;


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        fragments = new Vector<Fragment>();
        fragments.add(new GameFragment());
        fragments.add(new MusicFragment());
        fragments.add(new MovieFragment());

        view = inflater.inflate(R.layout.fragment_3, null);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        fragmentManager = getActivity().getSupportFragmentManager();
        System.out.println("!!!!!!!!"+fragments.size());
        tabPagerAdapter = new TabPagerAdapter(fragmentManager,fragments);

        viewPager.setAdapter(tabPagerAdapter);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setCurrentItem(0);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for(String title : titles){
            actionBar.addTab(actionBar.newTab().setText(title).setTabListener(this));
        }

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

		return view;
	}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        actionBar = activity.getActionBar();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        actionBar.removeAllTabs();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        viewPager.removeAllViews();
    }
}