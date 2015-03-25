package com.haidaiban.foxlee.Util;

import android.widget.ListView;

import com.haidaiban.foxlee.fragments.DealList;
import com.haidaiban.foxlee.model.deal.Deal;
import com.haidaiban.foxlee.model.message.Message;
import com.haidaiban.foxlee.model.quotelist.QuoteList;

/**
 * Created by qixiaohui on 3/24/15.
 */
public class DataHolder {
    private static Deal deal;
    private static Message message;
    private static QuoteList quoteList;

    public static Deal getDeal() {
        return deal;
    }

    public static void setDeal(Deal deal) {
        DataHolder.deal = deal;
    }

    public static Message getMessage() {
        return message;
    }

    public static void setMessage(Message message) {
        DataHolder.message = message;
    }

    public static QuoteList getQuoteList() {
        return quoteList;
    }

    public static void setQuoteList(QuoteList quoteList) {
        DataHolder.quoteList = quoteList;
    }
}
