package com.example.sysadmin.alilayoutdemo1.Fragment;

import android.support.v4.app.Fragment;

/**
 * Created by sysadmin on 4/5/17.
 */

public abstract class BaseFragment extends Fragment{

    protected void addCreateView() {
        initData();
        setData();
    }

    protected abstract void initData();

    protected abstract void setData();

}
