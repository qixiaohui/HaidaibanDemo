package com.haidaiban.foxlee.Util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


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
}
