package com.haidaiban.foxlee.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.haidaiban.foxlee.ui.MyCameraDialog;
import com.haidaiban.foxlee.ui.SentCommentDialog;

/**
 * Created by tom on 3/30/15.
 */
public class CommentFragment extends Fragment {

    private View mView;
    private ListView commentList;
    private Button btn_comment;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.frg_comment_layout, null);

        initView();
        return mView;


    }

    private void initView() {

        commentList = (ListView) mView.findViewById(R.id.comment_listView);
        btn_comment = (Button) mView.findViewById(R.id.btn_write_comment);

        // click on edittext will display the dialog for write comment ;
        btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showComment_Dialog();

            }


        });
    }

    private void showComment_Dialog() {
//  new SentCommentDialog(getActivity(), R.style.CustomDialog).show();
        new SentCommentDialog(getActivity()).show();

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
