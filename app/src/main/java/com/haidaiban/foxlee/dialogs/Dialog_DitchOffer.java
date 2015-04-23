package com.haidaiban.foxlee.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.haidaiban.foxlee.Util.DataHolder;
import com.haidaiban.foxlee.fragments.R;
import com.haidaiban.foxlee.model.offer.CustomerAction;
import com.haidaiban.foxlee.model.offer.Result;
import com.haidaiban.foxlee.webMethod.Webmethod;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by tom on 4/21/15.
 */
public class Dialog_DitchOffer extends Dialog {

    private Context mContext;
    private static int mTheme = R.style.CustomDialog;
    private EditText comment;
    private Button confirm;
    private Button cancel;
    private Async async;
    private CustomerAction customerAction;
    private Result acceptedOffer;
    private Webmethod webmethod;


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
        webmethod = new Webmethod(getContext());
        async = new Async();

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customerAction = DataHolder.getCustomerAction();
                acceptedOffer = DataHolder.getAcceptedOffer();
                async.execute();
            }
        });

    }

    public class Async extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... params) {
            try {
                webmethod.offerUpdateAction(customerAction.getName(), customerAction.getParameters(), acceptedOffer.getUid());
            }catch (IOException e){

            }catch (JSONException e){

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
        }
    }
}
