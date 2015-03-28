package com.haidaiban.foxlee.Util;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Display;
import android.view.WindowManager;


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
}
