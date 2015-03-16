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

import com.haidaiban.foxlee.adapter.TabPagerAdapter;
import com.haidaiban.foxlee.pagers.GameFragment;
import com.haidaiban.foxlee.pagers.MovieFragment;
import com.haidaiban.foxlee.pagers.MusicFragment;

public class FragmentPage3 extends Fragment{

    private View view;
    private ViewPager viewPager;
    private TabPagerAdapter tabPagerAdapter;
    private ActionBar actionBar;
    private FragmentManager fragmentManager;
    private String [] titles = {"Game","Music","Movie"};
    private List<Fragment> fragments;

    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        fragments = new Vector<Fragment>();
        fragments.add(new GameFragment());
        fragments.add(new MusicFragment());
        fragments.add(new MovieFragment());

        view = inflater.inflate(R.layout.fragment_3, null);
        viewPager = (ViewPager) view.findViewById(R.id.pager );
        fragmentManager = getActivity().getSupportFragmentManager();
        System.out.println("!!!!!!!!"+fragments.size());
        tabPagerAdapter = new TabPagerAdapter(fragmentManager,fragments,titles);

        viewPager.setAdapter(tabPagerAdapter);
//        viewPager.setOffscreenPageLimit(1);
//        viewPager.setCurrentItem(0);
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


		return view;
	}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

//        actionBar = activity.getActionBar();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        actionBar.removeAllTabs();
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
//        viewPager.removeAllViews();
    }
}