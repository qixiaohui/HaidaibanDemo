package com.haidaiban.foxlee.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.haidaiban.foxlee.config.Constants;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.offer.Offer;
import com.haidaiban.foxlee.model.quotelist.QuoteList;
import com.squareup.picasso.Picasso;

/**
 * Created by foxlee on 3/15/15
 * */

public class TempOfferAdapter extends BaseAdapter{

    public  static final String TAG = TempOfferAdapter.class.getSimpleName();

    private LayoutInflater inflater;
    private Context context ;
    private View view;
    private QuoteList quotes;

    //Ui



    public TempOfferAdapter(QuoteList quotes,Context context) {
        this.context = context;
        this.quotes = quotes;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return quotes.getResults().size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {


        if(convertView == null) {
            convertView = inflater.inflate(R.layout.lt_row_mytempoffer, parent, false);

        }

      ViewHolder  holder = null;
        if (holder == null){

        holder = new ViewHolder();

        holder.to_thumbNail  = (ImageView) convertView.findViewById(R.id.img_ls_tempoffer);
        holder.to_Title = (TextView) convertView.findViewById(R.id.ls_title);
        holder.to_Number = (TextView) convertView.findViewById(R.id.ls_item_num);
        holder.to_Type = (TextView) convertView.findViewById(R.id.ls_item_type);
        //to_temp = (TextView) view.findViewById(R.id.ls_temp);
        holder.to_del= (ImageView) convertView.findViewById(R.id.btn_tempoffer_del);
        holder.to_edit= (ImageView) convertView.findViewById(R.id.btn_tempoffer_edit);
            convertView.setTag(holder);
        }
        else{

            holder = (ViewHolder) convertView.getTag();

        }
        holder.to_Title.setText(quotes.getResults().get(0).getTitle());
        holder.to_Number.setText(quotes.getResults().get(0).getQuantity().toString());
        holder.to_Type.setText(quotes.getResults().get(0).getStyle());

        /**
         *  TO-DO click events
         *    1.  del event
         *    2. edit click event
         * */
        holder.to_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "=====  del =========");
                quotes.getResults().remove(position);
                notifyDataSetChanged();
                //  Toast.makeText("sss");
                Toast.makeText(context, "this is my Toast message!!! =)",
                        Toast.LENGTH_LONG).show();
            }
        });


        // thumbnail image
        Picasso.with(context)
                .load(Constants.getLOGIN_URL()+(String)quotes.getResults().get(0).getImage0())
                .resize(150, 150)
                .centerCrop()
                .into(holder.to_thumbNail);


       return convertView;
    }

    private static class ViewHolder {
        private ImageView to_thumbNail;
        private TextView to_Title ;
        private TextView to_Number;
        private TextView to_Type ;
       // private TextView to_temp ;
        private ImageView to_del;
        private ImageView to_edit;

    }
}



