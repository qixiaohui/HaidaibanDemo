package com.haidaiban.foxlee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.haidaiban.foxlee.config.Constants;
import com.haidaiban.foxlee.fragments.R;

import com.haidaiban.foxlee.model.deal.Result;
import com.squareup.picasso.Picasso;


/**
 * Created by qixiaohui on 3/25/15.
 */
public class TwoWayAdapter extends BaseAdapter {
    private Result result;
    private Context context;
    private ImageView image;
    private View view;
    private LayoutInflater inflater;
    private ViewHolder viewHolder;

    public TwoWayAdapter(Result result, Context context) {
        this.result = result;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return result.getRecommendations().size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        view = convertView;
        if(view == null){
            view = inflater.inflate(R.layout.twowaylist,parent,false);
        }
        if(viewHolder == null){
            viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) view.findViewById(R.id.image);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        Picasso.with(context)
                .load(Constants.getLOGIN_URL()+result.getRecommendations().get(position).getImage())
                .resize(50, 50)
                .centerCrop()
                .into(viewHolder.image);
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewHolder{
        private ImageView image;
    }
}
