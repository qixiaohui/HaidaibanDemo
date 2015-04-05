package com.haidaiban.foxlee.fragments;

import android.app.Dialog;
import android.content.Context;
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
    Context context;

    @Override
    public void updateComment(Context context, Result deal, ListView listView, TextView textView, RelativeLayout relativeLayout) {
        webmethod = new Webmethod(context);
        this.context = context;
        this.deal = deal;
        this.commentList = listView;
        this.commentVerb = textView;
        this.loading = relativeLayout;
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
        executeAsync();
    }

    public void executeAsync(){
        asyn = new Asyn();
        asyn.execute();
    }

    public ListView getCommentList() {
        return commentList;
    }

    public RelativeLayout getLoading() {
        return loading;
    }

    public TextView getCommentVerb() {
        return commentVerb;
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
            commentAdapter = new CommentAdapter(comment,context==null?getActivity().getApplicationContext():context);
            if (comment.getResults().size() > 0) {
                if(commentList != null) {
                    commentList.setAdapter(commentAdapter);
                    commentVerb.setVisibility(View.VISIBLE);
                }else{
                    commentAdapter.notifyDataSetChanged();
                }
            }
        }
    }


    public class SentCommentDialog extends Dialog {

        private EditText et_comment;
        private TextView tv_sentbtn;
        private Context mContext;
        private int mTheme = R.style.CustomDialog;
        private int num = 0;
        private int request_code = 1000;
        private int mode = 0;            //to differentiate between from camera and from photo gallery
        private Asyn asyn;
        private Webmethod webmethod;
        private Result deal;
        private int status;
        ListView refList;
        RelativeLayout refLoading;
        TextView refText;


        String str_getInput;

        public SentCommentDialog(Context context) {
            super(context);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.dialog_sentcomment);
            et_comment = (EditText) findViewById(R.id.et_comment);
            tv_sentbtn = (TextView) findViewById(R.id.dialog_btn_sentcomment);
            refList = getCommentList();
            refLoading = getLoading();
            refText = getCommentVerb();

//        tv_my_camera_take_photo
//                .setOnClickListener(new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        mode = 0;
//                        SentCommentDialog.this.dismiss();
//                        //拍照选择
//                        Intent intent = new Intent(
//                                "android.media.action.IMAGE_CAPTURE");
//                        ((Activity) mContext).startActivityForResult(intent,request_code);
//
//                    }
//                });


            tv_sentbtn
                    .setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            str_getInput = et_comment.getText().toString();
                            //从相册选择
                            mode = 1;
                            SentCommentDialog.this.dismiss();
//                        Intent intent = new Intent(
//                                Intent.ACTION_PICK,
//                                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                        ((Activity) mContext).startActivityForResult(intent, request_code);

                            /**
                             * sent get str to server.
                             * */
                            if (str_getInput.equals("")) {
                                Toast.makeText(getContext()
                                        , getContext().getResources().getString(R.string.commentFirst)
                                        , Toast.LENGTH_LONG).show();
                                ;
                            } else {
                                asyn = new Asyn();
                                asyn.execute(et_comment.getText().toString());
                                deal = getDeal();
                            }

                        }
                    });
        }

        public Result getDeal() {

            return DataHolder.getDealResult();
        }

        public class Asyn extends AsyncTask<String, String, String> {
            @Override
            protected String doInBackground(String... params) {
                webmethod = new Webmethod(getContext());
                try {
                    status = webmethod.addComment(Integer.toString(deal.getId()), params[0]);
                } catch (IOException e) {

                }

                return null;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (status == 201) {
                    Toast.makeText(getContext()
                            , getContext().getResources().getString(R.string.commentSuccess)
                            , Toast.LENGTH_LONG).show();
                    CommentFragment commentFragment = new CommentFragment();
                    commentFragment.updateComment(getActivity().getApplicationContext(), deal, refList, refText, refLoading);
                } else {
                    Toast.makeText(getContext()
                            , getContext().getResources().getString(R.string.commentFailed)
                            , Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
