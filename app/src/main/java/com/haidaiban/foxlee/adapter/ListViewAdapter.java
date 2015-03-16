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
import com.haidaiban.foxlee.model.deal.Deal;
import com.squareup.picasso.Picasso;


/**
 * Created by qixiaohui on 3/15/15.
 */
public class ListViewAdapter extends BaseAdapter {
    private Deal deals;
    private Context context;
    private TextView title;
    private ImageView thumbNail;
    private TextView description;
    private TextView category;
    private TextView rating;
    private LayoutInflater inflater;
    private View view;
    @Override
    public int getCount() {
        return deals.getResults().size();
    }

    public ListViewAdapter(Deal deals,Context context) {

        this.deals = deals;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.list_row, parent, false);
        }
        title = (TextView) view.findViewById(R.id.title);
        description = (TextView) view.findViewById(R.id.releaseYear);
        category = (TextView) view.findViewById(R.id.genre);
        rating = (TextView) view.findViewById(R.id.rating);
        thumbNail = (ImageView) view.findViewById(R.id.thumbnail);
        title.setText(deals.getResults().get(position).getTitle());
        category.setText(deals.getResults().get(position).getBrand());
        description.setText(deals.getResults().get(position).getStore());
        Picasso.with(context)
                .load(Constants.getLOGIN_URL()+deals.getResults().get(position).getImage())
                .resize(50, 50)
                .centerCrop()
                .into(thumbNail);

        return view;
    }
}
