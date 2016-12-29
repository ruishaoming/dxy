package com.dxy.happy.factory;

import android.support.v4.app.Fragment;


import com.dxy.happy.fragment.Community_Fragment;
import com.dxy.happy.fragment.Home_Fragment;
import com.dxy.happy.fragment.Mine_Fragment;

import java.util.HashMap;

/**
 * Created by 芮靖林
 * on 2016/12/28.
 * Fragment的工厂
 */
public class FragmentFactory {

    private static HashMap<Integer, Fragment> fragmentMap = new HashMap<>();

    public static Fragment getFragment(int position) {
        Fragment fragment = fragmentMap.get(position);
        if (fragment != null) {
            return fragment;
        }
        switch (position) {
            case 0:
                fragment = new Home_Fragment();
                break;
            case 1:
                fragment = new Community_Fragment();
                break;
            case 2:
                fragment = new Mine_Fragment();
                break;
        }
        fragmentMap.put(position, fragment);
        return fragment;
    }
}
