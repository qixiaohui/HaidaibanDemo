package com.haidaiban.foxlee.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.dialogs.Dialog_Quote;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.offer.Offer;
import com.haidaiban.foxlee.model.order.Result;

/**
 * Created by tom on 6/27/15.
 */
public class BasicAdapter extends BaseAdapter {
    private static Context context;
    private static Result orders;
    private static LayoutInflater layoutInflater;
    private static View view;

    @Override
    public int getCount() {
        return orders.getQuotes().size();
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
            view = layoutInflater.inflate(R.layout.basic_order_list_row,null);
        }
        ViewHolder viewHolder = null;
        if(viewHolder == null){
            viewHolder = new ViewHolder();
            viewHolder.quote = (TextView) view.findViewById(R.id.quote);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.quote.setText(orders.getQuotes().get(position).getTitle());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHolder.setQuote(orders.getQuotes().get(position));
                new Dialog_Quote(context,R.style.CustomDialog).show();
            }
        });
        return view;
    }

    public BasicAdapter(Context context, Result orders) {
        this.context = context;
        this.orders = orders;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public static class ViewHolder{
        TextView quote;
    }
}
