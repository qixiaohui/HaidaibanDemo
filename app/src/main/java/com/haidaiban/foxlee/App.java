package com.haidaiban.foxlee;
import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Created by jili on 5/4/15.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * IMKit SDK 初始化
         */
        RongIM.init(this);
        System.out.println("init");
    }
}