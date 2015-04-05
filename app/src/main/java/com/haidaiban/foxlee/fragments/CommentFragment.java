package com.haidaiban.foxlee.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.adapter.CommentAdapter;
import com.haidaiban.foxlee.model.comment.Comment;
import com.haidaiban.foxlee.model.deal.Result;
import com.haidaiban.foxlee.ui.MyCameraDialog;
import com.haidaiban.foxlee.ui.SentCommentDialog;
import com.haidaiban.foxlee.webMethod.Webmethod;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by tom on 3/30/15.
 */
public class CommentFragment extends Fragment implements OnUpdateComment{

    private View mView;
    private Button btn_comment;
    ListView commentList;
    RelativeLayout loading;
    Webmethod webmethod;
    CommentAdapter commentAdapter;
    Comment comment;
    TextView commentVerb;
    Result deal;
    Asyn asyn;

    @Override
    public void updateComment() {
        asyn = new Asyn();
        asyn.execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.frg_comment_layout, null);

        initView();
        return mView;


    }

    private void initView() {
        btn_comment = (Button) mView.findViewById(R.id.btn_write_comment);

        // click on edittext will display the dialog for write comment ;
        btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showComment_Dialog();

            }


        });
        commentList = (ListView) mView.findViewById(R.id.commentList);
        loading = (RelativeLayout) mView.findViewById(R.id.loadingPanel);
        commentVerb = (TextView) mView.findViewById(R.id.commentVerb);
        deal = getDeal();
        updateComment();
    }

    public Result getDeal() {

        return DataHolder.getDealResult();
    }

    private void showComment_Dialog() {
//  new SentCommentDialog(getActivity(), R.style.CustomDialog).show();
        new SentCommentDialog(getActivity()).show();

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    public class Asyn extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {

            try {
                webmethod = new Webmethod(getActivity().getApplicationContext());
                comment = webmethod.getComments(Integer.toString(deal.getId()));
            } catch (IOException e) {

            } catch (JSONException e) {

            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (loading!=null) {
                loading.setVisibility(View.VISIBLE);
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (loading!=null) {
                loading.setVisibility(View.GONE);
            }
            commentAdapter = new CommentAdapter(comment, getActivity().getApplicationContext());
            if (comment.getResults().size() > 0) {
                commentList.setAdapter(commentAdapter);
                commentVerb.setVisibility(View.VISIBLE);
            }
        }
    }

}
