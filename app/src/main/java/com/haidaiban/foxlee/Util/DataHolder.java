package com.haidaiban.foxlee.Util;

import android.widget.ListView;

import com.haidaiban.foxlee.model.deal.Deal;

/**
 * Created by qixiaohui on 3/24/15.
 */
public class DataHolder {
    private static Deal deal;

    public static Deal getDeal() {
        return deal;
    }

    public static void setDeal(Deal deal) {
        DataHolder.deal = deal;
    }
}
