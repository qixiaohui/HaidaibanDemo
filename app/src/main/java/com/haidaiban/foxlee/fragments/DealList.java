package com.haidaiban.foxlee.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by qixiaohui on 3/15/15.
 */
public class DealList extends Fragment{
    private View view;
    private String title;
    private String category;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.offerlist,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void setTitle(String title,String category){
        this.title = title;
        this.category = category;

    }
}
