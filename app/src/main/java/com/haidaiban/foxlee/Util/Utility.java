package com.haidaiban.foxlee.Util;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Display;
import android.view.WindowManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;


/**
 * Created by qixiaohui on 3/14/15.
 */
public class Utility {

    public static void redirect(FragmentManager fm,int fragment,Fragment newFragment){

        if (fm != null) {
            // Perform the FragmentTransaction to load in the list tab content.
            // Using FragmentTransaction#replace will destroy any Fragments
            // currently inside R.id.fragment_content and add the new Fragment
            // in its place.
            android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
            ft.replace(fragment, newFragment);
            ft.commit();
        }
    }

    public static int[] getWindowSize(Context context){
        int [] size = new int [2];
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        size[0] = point.x;
        size[1] = point.y;
        return size;
    }

    public static String getTimeSpan(String time)throws ParseException{
        Date inputTime = null;
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'");
        date.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date current  = new Date();
        inputTime = date.parse(time);
        Map<TimeUnit,Long> result = computeDiff(inputTime,current);
        if(result.get(TimeUnit.DAYS)!=0){
            return Long.toString(result.get(TimeUnit.DAYS))+"天";
        }else if(result.get(TimeUnit.HOURS)!=0){
            return Long.toString(result.get(TimeUnit.HOURS))+"小时";
        }else if(result.get(TimeUnit.MINUTES)!=0){
            return Long.toString(result.get(TimeUnit.MINUTES))+"分钟";
        }else{
            return "";
        }
    }

    public static Map<TimeUnit,Long> computeDiff(Date date1, Date date2) {
        long diffInMillies = date2.getTime() - date1.getTime();
        List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);

        Map<TimeUnit,Long> result = new LinkedHashMap<TimeUnit, Long>();
        long milliesRest = diffInMillies;
        for ( TimeUnit unit : units ) {
            long diff = unit.convert(milliesRest,TimeUnit.MILLISECONDS);
            long diffInMilliesForUnit = unit.toMillis(diff);
            milliesRest = milliesRest - diffInMilliesForUnit;
            result.put(unit,diff);
        }
        return result;
    }

}
