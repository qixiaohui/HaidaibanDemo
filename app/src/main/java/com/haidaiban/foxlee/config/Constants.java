package com.haidaiban.foxlee.config;

import android.content.Context;
import android.content.SharedPreferences;

import com.securepreferences.SecurePreferences;

/**
 * Created by jili on 3/8/15.
 *
 * 存放 常量URL 及其他常量；
 */
public class Constants {

    public static String APP_NAME ="";

    public static final String LOGIN_URL ="http://stage.haidaiban.com:7777/";

    private static SharedPreferences sharedPreferences;

    public static String getToken(Context context){
        if(sharedPreferences == null){
            sharedPreferences = new SecurePreferences(context);
        }
        return sharedPreferences.getString("RongToken",null);
    }

    public static String getAPP_NAME() {
        return APP_NAME;
    }

    public static String getLOGIN_URL() {
        return LOGIN_URL;
    }

}
