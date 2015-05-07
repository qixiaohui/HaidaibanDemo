package com.haidaiban.foxlee.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.Util.Utility;
import com.haidaiban.foxlee.activitys.AcceptedOrderDetails;
import com.haidaiban.foxlee.config.Constants;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.offer.Offer;
import com.squareup.picasso.Picasso;

import java.text.ParseException;

import io.rong.imkit.RongIM;

/**
 * Created by tom on 4/11/15.
 */
public class AcceptedOrderListAdapter extends BaseAdapter {
    Offer acceptedOffers;
    Context context;
    LayoutInflater inflater;
    View view;
    int index;
    String status;
    String time;
    Intent intent;

    public AcceptedOrderListAdapter(Context context, Offer acceptedOffers, int index) {
        this.context = context;
        this.acceptedOffers = acceptedOffers;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.index = index;
    }

    @Override
    public int getCount() {
        return acceptedOffers.getResults().size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        view = convertView;
        if(convertView == null){
            view = inflater.inflate(R.layout.accepted_order_list_row,null);
        }
        ViewHolder viewHolder = null;
        if(viewHolder == null){
            viewHolder = new ViewHolder();
            viewHolder.status = (TextView) view.findViewById(R.id.orderState);
            viewHolder.orderNumber = (TextView) view.findViewById(R.id.orderNumber);
            viewHolder.timeSpan = (TextView) view.findViewById(R.id.orderTime);
            viewHolder.dealImage = (ImageView) view.findViewById(R.id.orderImage);
            viewHolder.dealName = (TextView) view.findViewById(R.id.dealName);
            viewHolder.avatar = (ImageView) view.findViewById(R.id.avatar);
            viewHolder.agentName = (TextView) view.findViewById(R.id.agentName);
            viewHolder.agent = (LinearLayout) view.findViewById(R.id.agent);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        status = acceptedOffers
                .getResults()
                .get(position)
                .getTransactionState()
                .getState();
        viewHolder.status.setText(status);
        if(index == 0){

            if(status.equals(context.getResources().getStringArray(R.array.OrderTitle)[1])
                    ||status.equals(context.getResources().getString(R.string.paiedDeposit))){
                viewHolder.status.setTextColor(context.getResources().getColor(R.color.green));
            }else if(status.equals(context.getResources().getStringArray(R.array.OrderTitle)[2])){
                viewHolder.status.setTextColor(context.getResources().getColor(R.color.blue));
            }else if(status.equals(context.getResources().getStringArray(R.array.OrderTitle)[3])){
                viewHolder.status.setTextColor(context.getResources().getColor(R.color.yellow));
            }else if(status.equals(context.getResources().getStringArray(R.array.OrderTitle)[4])){
                viewHolder.status.setTextColor(context.getResources().getColor(R.color.orange));
            }else if(status.equals(context.getResources().getStringArray(R.array.OrderTitle)[5])){
                viewHolder.status.setTextColor(context.getResources().getColor(R.color.grey));
            }
        }else if(index == 1){
            viewHolder.status.setTextColor(context.getResources().getColor(R.color.green));
        }else if(index == 2){
            viewHolder.status.setTextColor(context.getResources().getColor(R.color.blue));
        }else if(index == 3){
            viewHolder.status.setTextColor(context.getResources().getColor(R.color.yellow));
        }else if(index == 4){
            viewHolder.status.setTextColor(context.getResources().getColor(R.color.orange));
        }else if(index == 5){
            viewHolder.status.setTextColor(context.getResources().getColor(R.color.grey));
        }

        viewHolder.orderNumber.setText("询价单号: "+acceptedOffers.getResults().get(position).getOrder());
        try {
            time = Utility.getTimeSpan(acceptedOffers.getResults().get(position).getLastUpdate());
            if(!time.equals("")){
                viewHolder.timeSpan.setText("更新于"+time+"前");
            }
        }catch (ParseException e) {
            System.out.println("parse time exception***");
        }
        if(acceptedOffers.getResults().get(position).getCounterquotes().get(0).getQuote().getDeal()==null){
            Picasso.with(context)
                    .load(R.drawable.productnoimage)
                    .centerCrop()
                    .resize(120, 120)
                    .into(viewHolder.dealImage);
        }else {
            Picasso.with(context)
                    .load(Constants.getLOGIN_URL() + acceptedOffers.getResults().get(position).getCounterquotes().get(0).getQuote().getDeal().getImage())
                    .resize(120, 120)
                    .centerCrop()
                    .into(viewHolder.dealImage);
        }
        viewHolder.dealName.setText(acceptedOffers.getResults().get(position).getCounterquotes().get(0).getQuote().getTitle()
                +"等"
                +acceptedOffers.getResults().get(position).getCounterquotes().size()
                +"件商品");
        if(acceptedOffers.getResults().get(position).getAgent().getIcon()!=null){
            Picasso.with(context)
                    .load(R.drawable.profile_no_avarta_icon)
                    .centerCrop()
                    .resize(40, 40)
                    .into(viewHolder.avatar);
        }else{
            Picasso.with(context)
                    .load(Constants.getLOGIN_URL() + acceptedOffers.getResults().get(position).getAgent().getIcon())
                    .resize(40, 40)
                    .centerCrop()
                    .into(viewHolder.avatar);
        }
        viewHolder.agentName.setText("代办:"+acceptedOffers.getResults().get(position).getAgent().getUsername());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHolder.setAcceptedOffer(acceptedOffers.getResults().get(position));
                intent = new Intent(context, AcceptedOrderDetails.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        viewHolder.agent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RongIM.getInstance() != null) {
                    RongIM.getInstance().startPrivateChat(context, "2462", "hello");
                }
            }
        });

        return view;
    }

    public static class ViewHolder{
        TextView status;
        TextView orderNumber;
        TextView timeSpan;
        ImageView avatar;
        TextView dealName;
        ImageView dealImage;
        TextView agentName;
        LinearLayout agent;
    }
}
