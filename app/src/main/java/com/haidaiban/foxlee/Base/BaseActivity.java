package com.haidaiban.foxlee.Base;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by jili on 4/25/15.
 */
public abstract class BaseActivity extends Activity {

    private int count = 0 ;

    private static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "Activity onCreate");

        ActivityCollector.addActivity(this);

        ActionBar actionBar = getActionBar();
//        actionBar.setDisplayShowHomeEnabled(true);
        initView();
    }

    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);

    }

    public void onBackPressed(){
        if(count ==1){
            count --;
            ActivityCollector.finishAll();
        }else{
            count ++;
            Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
        }
    }

    protected abstract void initView();

    protected abstract void initData();

//    protected void loadData()

}
