package com.haidaiban.foxlee.fragments;

import android.content.Context;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haidaiban.foxlee.model.deal.Result;

/**
 * Created by tom on 4/4/15.
 */
public interface OnUpdateComment {
    public void updateComment(Context context, Result deal, ListView commentList, TextView verb, RelativeLayout loading);
}
