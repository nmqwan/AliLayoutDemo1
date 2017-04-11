package com.example.sysadmin.alilayoutdemo1.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.sysadmin.alilayoutdemo1.Fragment.FragmentListItem;
import com.example.sysadmin.alilayoutdemo1.Fragment.FragmentNew;

/**
 * Created by sysadmin on 4/4/17.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag = null;
        switch (position) {
            case 0:
                frag = new FragmentNew();
                break;
            case 1:
                frag = new FragmentListItem();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "New";
                break;
            case 1:
                title = "Just For You";
                break;
        }

        return title;
    }

}

