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

import com.haidaiban.foxlee.model.comment.Comment;
import com.squareup.picasso.Picasso;

/**
 * Created by tom on 3/29/15.
 */
public class CommentAdapter extends BaseAdapter {
    private static Comment comment;
    LayoutInflater inflater;
    Context context;
    View view;

    public CommentAdapter(Comment comment,Context context) {
        this.comment = comment;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return comment.getResults().size();
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
            view = inflater.inflate(R.layout.comment,parent,false);
        }
        ViewHolder viewHolder = null;
        if(viewHolder == null){
            viewHolder = new ViewHolder();
            viewHolder.user = (TextView) view.findViewById(R.id.user);
            viewHolder.commentContent = (TextView) view.findViewById(R.id.comment);
            viewHolder.timeStamp = (TextView) view.findViewById(R.id.timeStamp);
            viewHolder.avatar = (ImageView) view.findViewById(R.id.avatar);
            viewHolder.user.setText(comment.getResults().get(position).getUser().getUsername());
            viewHolder.timeStamp.setText(comment.getResults().get(position).getSubmitDate());
            viewHolder.commentContent.setText(comment.getResults().get(position).getComment());
            if(comment.getResults().get(position).getUser().getIcon()!=null) {
                Picasso.with(context)
                        .load(Constants.getLOGIN_URL() + comment.getResults().get(position).getUser().getIcon())
                        .resize(50, 50)
                        .centerCrop()
                        .into(viewHolder.avatar);
            }else{
                viewHolder.avatar.setImageDrawable(context.getResources().getDrawable(R.drawable.profile_no_avarta_icon));
            }
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        return view;
    }

    public static class ViewHolder{
        private TextView user;
        private TextView commentContent;
        private TextView timeStamp;
        private ImageView avatar;
    }
}
