package com.haidaiban.foxlee.Util;

import android.graphics.drawable.BitmapDrawable;
import android.widget.ListView;

import com.haidaiban.foxlee.fragments.DealList;
import com.haidaiban.foxlee.model.deal.Deal;
import com.haidaiban.foxlee.model.deal.Result;
import com.haidaiban.foxlee.model.message.Message;
import com.haidaiban.foxlee.model.offer.CustomerAction;
import com.haidaiban.foxlee.model.offer.Offer;
import com.haidaiban.foxlee.model.openoffer.OpenOffer;
import com.haidaiban.foxlee.model.order.Order;
import com.haidaiban.foxlee.model.order.Quote;
import com.haidaiban.foxlee.model.profile.UserProfile;
import com.haidaiban.foxlee.model.quotelist.QuoteList;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by qixiaohui on 3/24/15.
 */
public class DataHolder {
    private static Deal deal;
    private static Message message;
    private static QuoteList quoteList;
    private static Result dealResult;
    private static com.haidaiban.foxlee.model.quotelist.Result quotelistResult;
    private static com.haidaiban.foxlee.model.order.Result orderResult;
    private static Order orderAll;
    private static Order orderAccepted;
    private static Order orderWaiting;
    private static Order orderClosed;
    private static Offer offerAll;
    private static Offer offerPaid;
    private static Offer offerBuying;
    private static Offer offerDelivering;
    private static Offer offerComplete;
    private static Offer offerCanceled;
    private static com.haidaiban.foxlee.model.offer.Result acceptedOffer;
    private static HashMap<String, Deal> limitedDeal = new HashMap<String, Deal>();
    private static CustomerAction customerAction;
    private static UserProfile userProfile;
    private static Boolean isAgent;
    private static ArrayList<BitmapDrawable> bitmapDrawables;
    private static Quote quote;
    private static OpenOffer openOffer;

    public static OpenOffer getOpenOffer() {
        return openOffer;
    }

    public static void setOpenOffer(OpenOffer openOffer) {
        DataHolder.openOffer = openOffer;
    }

    public static Quote getQuote() {
        return quote;
    }

    public static void setQuote(Quote quote) {
        DataHolder.quote = quote;
    }

    public static ArrayList<BitmapDrawable> getBitmapDrawables() {
        return bitmapDrawables;
    }

    public static void setBitmapDrawables(ArrayList<BitmapDrawable> bitmapDrawables) {
        DataHolder.bitmapDrawables = bitmapDrawables;
    }

    public static UserProfile getUserProfile() {
        return userProfile;
    }

    public static void setUserProfile(UserProfile userProfile) {
        DataHolder.userProfile = userProfile;
    }

    public static HashMap<String, Deal> getLimitedDeal() {
        return limitedDeal;
    }

    public static void setLimitedDeal(HashMap<String, Deal> limitedDeal) {
        DataHolder.limitedDeal = limitedDeal;
    }

    public static CustomerAction getCustomerAction() {
        return customerAction;
    }

    public static void setCustomerAction(CustomerAction customerAction) {
        DataHolder.customerAction = customerAction;
    }

    public static Deal getLimitedDeal(String category) {
        return limitedDeal.get(category);
    }

    public static void setLimitedDeal(String categoty, Deal dealData) {
        limitedDeal.put(categoty, dealData);
    }

    public static com.haidaiban.foxlee.model.offer.Result getAcceptedOffer() {
        return acceptedOffer;
    }

    public static void setAcceptedOffer(com.haidaiban.foxlee.model.offer.Result acceptedOffer) {
        DataHolder.acceptedOffer = acceptedOffer;
    }

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

    public static Result getDealResult() {
        return dealResult;
    }

    public static void setDealResult(Result dealResult) {
        DataHolder.dealResult = dealResult;
    }

    public static com.haidaiban.foxlee.model.quotelist.Result getQuotelistResult() {
        return quotelistResult;
    }

    public static void setQuotelistResult(com.haidaiban.foxlee.model.quotelist.Result quotelistResult) {
        DataHolder.quotelistResult = quotelistResult;
    }

    public static com.haidaiban.foxlee.model.order.Result getOrderResult() {
        return orderResult;
    }

    public static void setOrderResult(com.haidaiban.foxlee.model.order.Result orderResult) {
        DataHolder.orderResult = orderResult;
    }

    public static Order getOrderAll() {
        return orderAll;
    }

    public static void setOrderAll(Order orderAll) {
        DataHolder.orderAll = orderAll;
    }

    public static Order getOrderAccepted() {
        return orderAccepted;
    }

    public static void setOrderAccepted(Order orderAccepted) {
        DataHolder.orderAccepted = orderAccepted;
    }

    public static Order getOrderWaiting() {
        return orderWaiting;
    }

    public static void setOrderWaiting(Order orderWaiting) {
        DataHolder.orderWaiting = orderWaiting;
    }

    public static Order getOrderClosed() {
        return orderClosed;
    }

    public static void setOrderClosed(Order orderClosed) {
        DataHolder.orderClosed = orderClosed;
    }

    public static Offer getOfferAll() {
        return offerAll;
    }

    public static void setOfferAll(Offer offerAll) {
        DataHolder.offerAll = offerAll;
    }

    public static Offer getOfferPaid() {
        return offerPaid;
    }

    public static void setOfferPaid(Offer offerPaid) {
        DataHolder.offerPaid = offerPaid;
    }

    public static Offer getOfferBuying() {
        return offerBuying;
    }

    public static void setOfferBuying(Offer offerBuying) {
        DataHolder.offerBuying = offerBuying;
    }

    public static Offer getOfferDelivering() {
        return offerDelivering;
    }

    public static void setOfferDelivering(Offer offerDelivering) {
        DataHolder.offerDelivering = offerDelivering;
    }

    public static Offer getOfferComplete() {
        return offerComplete;
    }

    public static void setOfferComplete(Offer offerComplete) {
        DataHolder.offerComplete = offerComplete;
    }

    public static Offer getOfferCanceled() {
        return offerCanceled;
    }

    public static void setOfferCanceled(Offer offerCanceled) {
        DataHolder.offerCanceled = offerCanceled;
    }

    public static Boolean getIsAgent() {
        return isAgent;
    }

    public static void setIsAgent(Boolean isAgent) {
        DataHolder.isAgent = isAgent;
    }
}
