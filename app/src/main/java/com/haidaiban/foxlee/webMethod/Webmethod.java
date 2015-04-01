package com.haidaiban.foxlee.webMethod;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.widget.Toast;

import com.google.gson.Gson;
import com.haidaiban.foxlee.config.Constants;
import com.haidaiban.foxlee.model.comment.Comment;
import com.haidaiban.foxlee.model.deal.Deal;
import com.haidaiban.foxlee.model.message.Message;
import com.haidaiban.foxlee.model.offer.Offer;
import com.haidaiban.foxlee.model.quotelist.QuoteList;
import com.haidaiban.foxlee.model.quotelist.Result;
import com.securepreferences.SecurePreferences;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
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
    private static HttpGet httpGet;
    private static HttpPost httpPost;
    private static HttpResponse httpResponse;
    private static HttpEntity entity;
    private static String response;
    private static Gson gson;
    private static CredentialsProvider credentialsProvider;
    private static UsernamePasswordCredentials usernamePasswordCredentials;
    private static HttpClient basicAuthClient;
    private static int status;
    private static String [] credentials;

    public Webmethod(Context context) {
        this.context = context;
        httpClient = new DefaultHttpClient();
        sharedPreferences = new SecurePreferences(this.context);
    }

    public static String getToken(){
        return sharedPreferences.getString("token",null);
    }

    public static void getCredential(){
        credentials = new String [2];
        credentials[0] = sharedPreferences.getString("userName",null);
        credentials[1] = sharedPreferences.getString("password",null);
    }

    public static String get()throws IOException,JSONException{

        token = getToken();
        httpGet = new HttpGet(url+"api/offers");
        //httpGet.setHeader("Accept","applicatiton/json; indent=4");
        //System.out.println("token"+token);
        httpGet.setHeader("Authorization","Token "+token);
        httpResponse = httpClient.execute(httpGet);
        entity = httpResponse.getEntity();
        response = EntityUtils.toString(entity,"UTF-8");
        //System.out.println(response+"***********");
        return  response;

    }

    public static Message getMessage() throws IOException{
        httpGet = new HttpGet(url+"api/sitemessages");
        httpResponse = httpClient.execute(httpGet);
        entity = httpResponse.getEntity();
        response = EntityUtils.toString(entity,"UTF-8");
        System.out.println(response);
        return new Gson().fromJson(response,Message.class);
    }

    public static Deal getDeals()throws IOException,JSONException{
        token = getToken();
        httpGet = new HttpGet(url+"api/deals");
        httpGet.setHeader("Authorization","Token "+token);
        httpResponse = httpClient.execute(httpGet);
        entity = httpResponse.getEntity();
        response = EntityUtils.toString(entity,"UTF-8");
        return new Gson().fromJson(response,Deal.class);
    }

    public static QuoteList getQuotes()throws IOException,JSONException{
        token = getToken();
        httpGet = new HttpGet(url+"api/quotes/?type=cart");
        httpGet.setHeader("Authorization","Token "+token);
        httpResponse = httpClient.execute(httpGet);
        entity = httpResponse.getEntity();
        response = EntityUtils.toString(entity,"UTF-8");
        System.out.println(response);
        return new Gson().fromJson(response,QuoteList.class);
    }

    /**
     * Problem: always got a 404 return
     * @param userName
     * @param password1
     * @param password2
     * @param email
     * @return
     * @throws IOException
     */
    public static String register(String userName, String password1, String password2, String email)throws IOException{
        httpPost = new HttpPost(url+"/rest-auth/registration/");
        httpPost.setHeader("username",userName);
        httpPost.setHeader("password1",password1);
        httpPost.setHeader("password2",password2);
        httpPost.setHeader("email",email);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity entity = httpResponse.getEntity();
        String response = EntityUtils.toString(entity,"UTF-8");
        System.out.println(response);
        System.out.println(httpResponse.getStatusLine()+"status****");
        return response;
    }

    public static void deleteQuote(String uid) throws IOException{
        credentialsProvider = new BasicCredentialsProvider();
        getCredential();
        usernamePasswordCredentials = new UsernamePasswordCredentials(credentials[0],credentials[1]);
        credentialsProvider.setCredentials(AuthScope.ANY, usernamePasswordCredentials);
        basicAuthClient = HttpClientBuilder.create().setDefaultCredentialsProvider(credentialsProvider).build();
        pair = new ArrayList<NameValuePair>();
        token = getToken();
        httpPost = new HttpPost(url+"api/quotes/"+uid);
        httpPost.setHeader("Authorization","Token "+token);
        pair.add(new BasicNameValuePair("_method","DELETE"));
        httpPost.setEntity(new UrlEncodedFormEntity(pair));
        httpResponse = basicAuthClient.execute(httpPost);
        status = httpResponse.getStatusLine().getStatusCode();
        System.out.println(status);
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
        System.out.println("**********"+userName+"**************"+password);
        return httpResponse.getStatusLine().getStatusCode();
    }

    public void updateQuote(Result result) throws IOException{
        token = getToken();
        credentialsProvider = new BasicCredentialsProvider();
        getCredential();
        usernamePasswordCredentials = new UsernamePasswordCredentials(credentials[0],credentials[1]);
        credentialsProvider.setCredentials(AuthScope.ANY, usernamePasswordCredentials);
        basicAuthClient = HttpClientBuilder.create().setDefaultCredentialsProvider(credentialsProvider).build();
        pair = new ArrayList<NameValuePair>();
        pair.add(new BasicNameValuePair("_method","PATCH"));
        pair.add(new BasicNameValuePair("deal",""));
        pair.add(new BasicNameValuePair("title",result.getTitle()));
        pair.add(new BasicNameValuePair("web_link",result.getWebLink()));
        pair.add(new BasicNameValuePair("price",result.getPrice().toString()));
        pair.add(new BasicNameValuePair("coupon",result.getCoupon()));
        pair.add(new BasicNameValuePair("style",result.getStyle()));
        pair.add(new BasicNameValuePair("quantity",result.getQuantity().toString()));
        pair.add(new BasicNameValuePair("shipping",result.getShipping()==null?"0":result.getShipping().toString()));
        pair.add(new BasicNameValuePair("weight",result.getWeight()==null?"0":result.getWeight().toString()));
        pair.add(new BasicNameValuePair("direct_ship",result.getDirectShip()));
        pair.add(new BasicNameValuePair("remark",result.getRemark()));
        pair.add(new BasicNameValuePair("image0",""));
        pair.add(new BasicNameValuePair("is_favorite",result.getIsFavorite()?"True":"False"));
        pair.add(new BasicNameValuePair("is_draft","True"));

        httpPost = new HttpPost(url+"api/quotes/"+result.getUid());
        httpPost.setHeader("Authorization","Token "+token);
        httpPost.setEntity(new UrlEncodedFormEntity(pair));
        httpResponse = basicAuthClient.execute(httpPost);
        status = httpResponse.getStatusLine().getStatusCode();
        System.out.println(status);
    }

    public Boolean createQuote(Result result)throws IOException{
        token = getToken();
        credentialsProvider = new BasicCredentialsProvider();
        getCredential();
        usernamePasswordCredentials = new UsernamePasswordCredentials(credentials[0],credentials[1]);
        credentialsProvider.setCredentials(AuthScope.ANY,usernamePasswordCredentials);
        basicAuthClient = HttpClientBuilder.create().setDefaultCredentialsProvider(credentialsProvider).build();
        pair = new ArrayList<NameValuePair>();
        pair.add(new BasicNameValuePair("deal",result.getUid()==null?"":result.getUid()));
        pair.add(new BasicNameValuePair("title",result.getTitle()));
        pair.add(new BasicNameValuePair("web_link",result.getWebLink()));
        pair.add(new BasicNameValuePair("price",result.getPrice().toString()));
        pair.add(new BasicNameValuePair("coupon",result.getCoupon()));
        pair.add(new BasicNameValuePair("style",result.getStyle()));
        pair.add(new BasicNameValuePair("quantity",result.getQuantity().toString()));
        pair.add(new BasicNameValuePair("shipping",result.getShipping()==null?"0":result.getShipping().toString()));
        pair.add(new BasicNameValuePair("weight",result.getWeight()==null?"0":result.getWeight().toString()));
        pair.add(new BasicNameValuePair("direct_ship",result.getDirectShip()));
        pair.add(new BasicNameValuePair("remark",result.getRemark()));
        pair.add(new BasicNameValuePair("image0",result.getImage0()==null?"":result.getImage0().toString()));
        if(result.getIsFavorite()==null){
            result.setIsFavorite(Boolean.FALSE);
        }
        pair.add(new BasicNameValuePair("is_favorite",result.getIsFavorite()?"True":"False"));
        pair.add(new BasicNameValuePair("is_draft","True"));

        httpPost = new HttpPost(Constants.getLOGIN_URL()+"api/quotes/");
        httpPost.setHeader("Authorization","Token "+token);
        httpPost.setEntity(new UrlEncodedFormEntity(pair));
        httpResponse = basicAuthClient.execute(httpPost);
        status = httpResponse.getStatusLine().getStatusCode();
        if(status == 201){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }

    public static int bookmark(String id) throws IOException{
        token = getToken();
        pair = new ArrayList<NameValuePair>();
        pair.add(new BasicNameValuePair("id",id));
        httpPost = new HttpPost(Constants.getLOGIN_URL()+"api/like/deal/");
        httpPost.setHeader("Authorization","Token "+token);
        httpPost.setEntity(new UrlEncodedFormEntity(pair));
        httpResponse = httpClient.execute(httpPost);
        status = httpResponse.getStatusLine().getStatusCode();
        System.out.println(status);
        return status;
    }

    public static int deleteBookmark(String id) throws IOException{
        token = getToken();
        token = getToken();
        pair = new ArrayList<NameValuePair>();
        pair.add(new BasicNameValuePair("id",id));
        pair.add(new BasicNameValuePair("_method","DELETE"));
        httpPost = new HttpPost(Constants.getLOGIN_URL()+"api/like/deal/");
        httpPost.setHeader("Authorization","Token "+token);
        httpPost.setEntity(new UrlEncodedFormEntity(pair));
        httpResponse = httpClient.execute(httpPost);
        status = httpResponse.getStatusLine().getStatusCode();
        System.out.println(status);
        return status;
    }

    public static Comment getComments(String id) throws IOException,JSONException{
        token = getToken();
        httpGet = new HttpGet(Constants.getLOGIN_URL()+"api/comments/?ct=deal.deal&id="+id);
        httpGet.setHeader("Authorization",token);
        httpResponse = httpClient.execute(httpGet);
        entity = httpResponse.getEntity();
        response = EntityUtils.toString(entity,"UTF-8");
        System.out.println(response+"****");
        return new Gson().fromJson(response,Comment.class);
    }

    public static int addComment(String id,String comment) throws IOException{
        token = getToken();
        pair = new ArrayList<NameValuePair>();
        pair.add(new BasicNameValuePair("content_type","deal.deal"));
        pair.add(new BasicNameValuePair("object_pk",id));
        pair.add(new BasicNameValuePair("comment",comment));
        httpPost = new HttpPost(Constants.getLOGIN_URL()+"api/comment/write/");
        httpPost.setHeader("Authorization","Token "+token);
        httpPost.setEntity(new UrlEncodedFormEntity(pair));
        httpResponse = httpClient.execute(httpPost);
        status = httpResponse.getStatusLine().getStatusCode();
        System.out.println(status+"*****");
        return status;
    }
}
