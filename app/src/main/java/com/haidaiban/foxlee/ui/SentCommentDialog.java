package com.haidaiban.foxlee.ui;

/**
 *
 */

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.haidaiban.foxlee.fragments.R;

/**
 * 发送comment
 *
 * Created by jili on 3/30/15.
 *
 *         Time:2015年3月22日
 */
public class SentCommentDialog extends Dialog {

    private EditText et_comment;
    private TextView tv_sentbtn;
    private Context mContext;
    private static int mTheme = R.style.CustomDialog;
    private static int num = 0;
    private static int request_code = 1000;
    private static int mode = 0;            //to differentiate between from camera and from photo gallery

    String str_getInput;

    /**
     * 自定义Dialog
     *
     * @param context
     *            上下文
     * @param "activity"
     *            Dialog所在的Activity，用于点击“确定”按钮后finish所在的Activity
     * @param "title"
     *            文本内容
     * @param "btnString"
     *            按钮上的文字
     * @param theme
     *            样式
     */
    public SentCommentDialog(Context context, int theme, int num) {
        super(context, theme);
        this.mContext = context;
        this.num = num;
    }

    public SentCommentDialog(Context context) {
        super(context, mTheme);
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_sentcomment);
        et_comment = (EditText) findViewById(R.id.et_comment);
        tv_sentbtn = (TextView) findViewById(R.id.dialog_btn_sentcomment);

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

        str_getInput=  et_comment.getText().toString();

        tv_sentbtn
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
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


                     }
                });

    }

    public static int getNum() {
        return num;
    }

    public static int getMode() {
        return mode;
    }
}