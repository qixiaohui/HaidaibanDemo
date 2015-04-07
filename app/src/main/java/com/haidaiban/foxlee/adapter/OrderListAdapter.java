package com.haidaiban.foxlee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.haidaiban.foxlee.config.Constants;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.order.Order;
import com.squareup.picasso.Picasso;

import java.util.zip.Inflater;

/**
 * Created by tom on 4/5/15.
 */
public class OrderListAdapter extends BaseAdapter {
    Context context;
    Order order;
    LayoutInflater inflater;
    View view;


    public OrderListAdapter(Context context, Order order) {
        this.context = context;
        this.order = order;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return order.getResults().size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        view = convertView;
        if(view == null){
            view = inflater.inflate(R.layout.order_list_row,parent,false);
        }
        ViewHolder viewHolder = null;
        if(viewHolder == null){
            viewHolder = new ViewHolder();
            viewHolder.status = (TextView) view.findViewById(R.id.orderState);
            viewHolder.orderNumber = (TextView) view.findViewById(R.id.orderNumber);
            viewHolder.timeElapse = (TextView) view.findViewById(R.id.orderTime);
            viewHolder.prodImg = (ImageView) view.findViewById(R.id.orderImage);
            viewHolder.dealName = (TextView) view.findViewById(R.id.dealName);
            viewHolder.timeRemain = (TextView) view.findViewById(R.id.remainTime);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        if(order.getResults().get(position).getIsOpen()&&order.getResults().get(position).getOpenOffers().size()>0){
            viewHolder.status.setText("已报价");
            viewHolder.status.setTextColor(context.getResources().getColor(R.color.white));
            viewHolder.status.setBackgroundColor(context.getResources().getColor(R.color.grey));
            viewHolder.timeRemain.setText("已收到代办\""+order.getResults().get(position).getOpenOffers().get(0).getAgent()+"\"的报价");
        }else if(order.getResults().get(position).getIsOpen()&&order.getResults().get(position).getOpenOffers().size()==0){
            viewHolder.status.setText("待报价");
            viewHolder.status.setTextColor(context.getResources().getColor(R.color.white));
            viewHolder.status.setBackgroundColor(context.getResources().getColor(R.color.blue));
            viewHolder.timeElapse.setText("更新于"+Integer.toString(23-Integer.parseInt(order.getResults().get(position).getCloseTaskEta().toString().substring(0,2)))+"小时前");
            viewHolder.timeRemain.setText("正在等待代办接单 ，若"+order.getResults().get(position).getCloseTaskEta().toString().substring(0,2)+"小时内无人接单，则询价单将被关闭");
        }else {
            viewHolder.status.setText("已关闭");
            viewHolder.status.setTextColor(context.getResources().getColor(R.color.white));
            viewHolder.status.setBackgroundColor(context.getResources().getColor(R.color.green));
            viewHolder.timeRemain.setText("超时无代办接单或无进行中的报价，系统已终止询价");
        }
        viewHolder.dealName.setText(order.getResults().get(position).getQuotes().get(0).getTitle());
        viewHolder.orderNumber.setText("询价单号: "+order.getResults().get(position).getQuotes().get(0).getOrder());
        if(order.getResults().get(position).getQuotes().get(0).getImage0()==null){
            viewHolder.prodImg.setImageDrawable(context.getResources().getDrawable(R.drawable.productnoimage));
        }else {
            Picasso.with(context)
                    .load(Constants.getLOGIN_URL() + order.getResults().get(position).getQuotes().get(0).getImage0())
                    .resize(150, 150)
                    .centerCrop()
                    .into(viewHolder.prodImg);
        }
        return view;
    }

    public class ViewHolder{
        TextView status;
        TextView orderNumber;
        TextView timeElapse;
        ImageView prodImg;
        TextView dealName;
        TextView timeRemain;
    }
}
