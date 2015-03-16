package com.haidaiban.foxlee.adapter;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by qixiaohui on 3/8/15.
 */
public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;
    private String [] titles;

    public TabPagerAdapter(FragmentManager fm, List<Fragment> fragments, String[] titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override

    public Fragment getItem(int position) {
        System.out.println(position+"**********");
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
