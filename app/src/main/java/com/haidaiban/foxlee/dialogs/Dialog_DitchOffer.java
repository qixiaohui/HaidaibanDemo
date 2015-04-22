package com.haidaiban.foxlee.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.haidaiban.foxlee.fragments.R;

/**
 * Created by tom on 4/21/15.
 */
public class Dialog_DitchOffer extends Dialog {

    private Context mContext;
    private static int mTheme = R.style.CustomDialog;
    private EditText comment;
    private Button confirm;
    private Button cancel;


    public Dialog_DitchOffer(Context context, int theme) {
        super(context, theme);
        this.mContext = context;
    }

    public Dialog_DitchOffer(Context context) {
        super(context, mTheme);
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_d0_ditchoffer);
        comment = (EditText) findViewById(R.id.et_comment);
        confirm = (Button) findViewById(R.id.dialog_btn_sentcomment);
        cancel = (Button) findViewById(R.id.dialog_btn_cancel);

    }
}
