package com.haidaiban.foxlee.webMethod;

import android.content.Context;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

/**
 * Created by qixiaohui on 3/8/15.
 */
public class Webmethod {
    private static String url = "http://stage.sanqtech.com:7777/";
    private Context context;
    private static ArrayList<NameValuePair> pair;
    private static DefaultHttpClient httpClient;
    private static List<Cookie> cookies;
    private static Cookie middleWareToken;
    private static CookieStore cookieStore;

    public Webmethod(Context context) {
        this.context = context;
        httpClient = new DefaultHttpClient();
    }

    public static void get()throws IOException{
        HttpGet get = new HttpGet(url);
        httpClient.execute(get);
        cookies = httpClient.getCookieStore().getCookies();
        cookieStore = httpClient.getCookieStore();
    }

    public static void post()throws IOException{

        pair = new ArrayList<NameValuePair>();
//        for(Cookie cookie : cookies){
//            if(cookie.getName().equals("csrftoken")){
//                System.out.println("find token (*************"+cookie.getValue());
//                middleWareToken = cookie;
//                break;
//            }
//        }
//        pair.add(new BasicNameValuePair("csrfmiddlewaretoken",middleWareToken.getValue()));
        pair.add(new BasicNameValuePair("username","foxlee"));
        pair.add(new BasicNameValuePair("password","liji1025"));

        HttpPost httpPost = new HttpPost(url+"/rest-auth/login/");
        //BasicClientCookie clientCookie = new BasicClientCookie("csrftoken",middleWareToken.getValue());
        //clientCookie.setPath("/Login");
        //cookieStore.addCookie(clientCookie);
        httpClient.setCookieStore(cookieStore);
        httpPost.setHeader("content-type","application/x-www-form-urlencoded");
        httpPost.setEntity(new UrlEncodedFormEntity(pair));
        HttpResponse httpResponse = httpClient.execute(httpPost);
        System.out.println(httpResponse.getStatusLine() + "status******");
        HttpEntity entity = httpResponse.getEntity();
        String response = EntityUtils.toString(entity,"UTF-8");
        System.out.println(response+"*************");

    }

}
