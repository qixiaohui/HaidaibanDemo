package com.haidaiban.foxlee.config;

/**
 * Created by jili on 3/8/15.
 *
 * 存放 常量URL 及其他常量；
 */
public class Constants {

    public static String APP_NAME ="";

    public static String LOGIN_URL ="http://stage.sanqtech.com:7777/";

    public static String getAPP_NAME() {
        return APP_NAME;
    }

    public static void setAPP_NAME(String APP_NAME) {
        Constants.APP_NAME = APP_NAME;
    }

    public static String getLOGIN_URL() {
        return LOGIN_URL;
    }

    public static void setLOGIN_URL(String LOGIN_URL) {
        Constants.LOGIN_URL = LOGIN_URL;
    }
}
