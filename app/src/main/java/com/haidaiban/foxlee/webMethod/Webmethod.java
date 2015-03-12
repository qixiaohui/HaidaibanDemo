package com.haidaiban.foxlee.webMethod;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.widget.Toast;

import com.securepreferences.SecurePreferences;

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
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

/**
 * Created by qixiaohui on 3/8/15.
 */
public class Webmethod {
    private static String url = "http://stage.sanqtech.com:7777/";
    private static Context context;
    private static ArrayList<NameValuePair> pair;
    private static DefaultHttpClient httpClient;
    private static List<Cookie> cookies;
    private static Cookie middleWareToken;
    private static CookieStore cookieStore;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static JSONObject result;
    private static String token;

    public Webmethod(Context context) {
        this.context = context;
        httpClient = new DefaultHttpClient();
        sharedPreferences = new SecurePreferences(this.context);
    }

    public static String getToken(){
        return sharedPreferences.getString("token",null);
    }

    public static JSONObject get()throws IOException,JSONException{

        token = getToken();
        HttpGet httpGet = new HttpGet(url+"api/offers");
        //httpGet.setHeader("Accept","applicatiton/json; indent=4");
        //System.out.println("token"+token);
        httpGet.setHeader("Authorization","Token "+token);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();
        String response = EntityUtils.toString(entity,"UTF-8");
        System.out.println(response+"***********");
        JSONTokener tokener = new JSONTokener(response);
        return  new JSONObject(tokener);

    }

    public static int post(String userName, String password)throws IOException,JSONException{

        pair = new ArrayList<NameValuePair>();
//        for(Cookie cookie : cookies){
//            if(cookie.getName().equals("csrftoken")){
//                System.out.println("find token (*************"+cookie.getValue());
//                middleWareToken = cookie;
//                break;
//            }
//        }
//        pair.add(new BasicNameValuePair("csrfmiddlewaretoken",middleWareToken.getValue()));
        System.out.println(userName+password+"*********");
        pair.add(new BasicNameValuePair("username",userName));
        pair.add(new BasicNameValuePair("password",password));

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
        JSONTokener tokener = new JSONTokener(response);
        result = new JSONObject(tokener);
        System.out.println(result.get("key"));
        if(httpResponse.getStatusLine().getStatusCode()==200){
            editor = sharedPreferences.edit();
            editor.putString("token",result.get("key").toString());
            editor.commit();
        }
        System.out.print("**********"+userName+"**************"+password);
        return httpResponse.getStatusLine().getStatusCode();
    }

}
