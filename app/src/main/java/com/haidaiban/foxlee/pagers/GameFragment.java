package com.haidaiban.foxlee.pagers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haidaiban.foxlee.haidaibandemo.R;

/**
 * Created by qixiaohui on 3/8/15.
 */
public class GameFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.game,null);
        return view;
    }
}
