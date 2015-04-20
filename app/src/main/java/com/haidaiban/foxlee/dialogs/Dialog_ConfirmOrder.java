package com.haidaiban.foxlee.dialogs;

/**
 *
 */

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.haidaiban.foxlee.fragments.R;

/**
 * 为符合软件整体风格而自定义的选择照片来源dialog
 *
 * Created by jili on 3/22/15.
 *
 *         Time:2015年3月22日
 */
public class Dialog_ConfirmOrder extends Dialog {

    private TextView tv_my_camera_take_photo;
    private TextView tv_my_camera_from_album;
    private Context mContext;
    private static int mTheme = R.style.CustomDialog;
    private static int num = 0;
    private static int request_code = 1000;
    private static int mode = 0;            //to differentiate between from camera and from photo gallery

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
    public Dialog_ConfirmOrder(Context context, int theme, int num) {
        super(context, theme);
        this.mContext = context;
        this.num = num;
    }

    public Dialog_ConfirmOrder(Context context) {
        super(context, mTheme);
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
        tv_my_camera_take_photo = (TextView) findViewById(R.id.dialog_camera);
        tv_my_camera_from_album = (TextView) findViewById(R.id.dialog_upload);

        tv_my_camera_take_photo
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        mode = 0;
                        Dialog_ConfirmOrder.this.dismiss();
                        //拍照选择
                        Intent intent = new Intent(
                                "android.media.action.IMAGE_CAPTURE");
                        ((Activity) mContext).startActivityForResult(intent,request_code);

                    }
                });

        tv_my_camera_from_album
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        //从相册选择
                        mode = 1;
                        Dialog_ConfirmOrder.this.dismiss();
                        Intent intent = new Intent(
                                Intent.ACTION_PICK,
                                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        ((Activity) mContext).startActivityForResult(intent, request_code);
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