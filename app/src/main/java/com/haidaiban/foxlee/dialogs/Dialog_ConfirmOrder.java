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

    private TextView tv_dialog_btn_confirm;
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
    public Dialog_ConfirmOrder(Context context, int theme) {
        super(context, theme);
        this.mContext = context;
    }

    public Dialog_ConfirmOrder(Context context) {
        super(context, mTheme);
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_d0_confirm);
        // add textview click on here
        tv_dialog_btn_confirm = (TextView) findViewById(R.id.dialog_btn_confirm);
    }

    public static int getNum() {
        return num;
    }

    public static int getMode() {
        return mode;
    }
}