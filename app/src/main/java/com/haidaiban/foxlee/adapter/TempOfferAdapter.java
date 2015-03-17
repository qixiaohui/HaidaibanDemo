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
import com.haidaiban.foxlee.model.offer.Offer;
import com.squareup.picasso.Picasso;

/**
 * Created by foxlee on 3/15/15
 * */

public class TempOfferAdapter extends BaseAdapter{

    private LayoutInflater inflater;
    private Context context ;
    private View view;
    private Offer myOffer;

    //Ui
    private ImageView to_thumbNail;
    private TextView to_Title ;
    private TextView to_Number;
    private TextView to_Type ;
    private TextView to_temp ;


    public TempOfferAdapter(Offer myOffer,Context context) {
        this.context = context;
        this.myOffer = myOffer;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return myOffer.getResults().get(0).getCounterquotes().size();
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
        if(view == null){
            view = inflater.inflate(R.layout.lt_row_mytempoffer,parent,false);
        }

        to_thumbNail  = (ImageView) view.findViewById(R.id.img_ls_tempoffer);
        to_Title = (TextView) view.findViewById(R.id.ls_title);
        to_Number = (TextView) view.findViewById(R.id.ls_item_num);
        to_Type = (TextView) view.findViewById(R.id.ls_item_type);
        //to_temp = (TextView) view.findViewById(R.id.ls_temp);

        to_Title.setText(myOffer.getResults().get(0).getCounterquotes().get(position).getQuote().getTitle());
        to_Number.setText(myOffer.getResults().get(0).getCounterquotes().get(position).getQuote().getLastUpdate());
        to_Type.setText(myOffer.getResults().get(0).getCounterquotes().get(position).getQuote().getStyle());


        // thumbnail image
        Picasso.with(context)
                .load(Constants.getLOGIN_URL()+myOffer.getResults().get(0).getCounterquotes().get(position).getQuote().getDeal().getImage())
                .resize(150, 150)
                .centerCrop()
                .into(to_thumbNail);



       return view;
    }
}



