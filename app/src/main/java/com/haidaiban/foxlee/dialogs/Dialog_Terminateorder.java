package com.haidaiban.foxlee.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.haidaiban.foxlee.fragments.R;

/**
 * Created by qixiaohui on 7/4/15.
 */
public class Dialog_Terminateorder extends Dialog {
    private static Context context;

    public Dialog_Terminateorder(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_terminateorder);
    }
}
