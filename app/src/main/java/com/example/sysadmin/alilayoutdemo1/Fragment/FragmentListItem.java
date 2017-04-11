package com.example.sysadmin.alilayoutdemo1.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sysadmin.alilayoutdemo1.R;

/**
 * Created by sysadmin on 4/4/17.
 */

public class FragmentListItem extends Fragment {
    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_listitem,container,false);
        initData();
        setEvent();
        return v;
    }
    void initData(){

    }
    void setEvent(){
        
    }
}
