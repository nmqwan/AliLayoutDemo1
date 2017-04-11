package com.example.sysadmin.alilayoutdemo1.Activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import com.example.sysadmin.alilayoutdemo1.Adapter.ViewPagerAdapter;
import com.example.sysadmin.alilayoutdemo1.CustomView.CustomEditText;
import com.example.sysadmin.alilayoutdemo1.CustomView.DrawableClickListener;
import com.example.sysadmin.alilayoutdemo1.R;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();

    private ViewPager pager;
    private TabLayout tabLayout;
    private CustomEditText edtSearch;
    private Toolbar toolbar;
    private LinearLayout lineMain;
    private LinearLayout lineDrawer;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    private float lastTranslate = 0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customActionBar();
        initData();
        setEvent();
    }

    void initData() {
        lineMain = (LinearLayout) findViewById(R.id.lineMain);
        lineDrawer = (LinearLayout) findViewById(R.id.lineDrawer);
        //clear focus edittext
        lineMain.requestFocus();

        //set viewpager
        pager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        pager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        FragmentManager manager = getSupportFragmentManager();
        PagerAdapter adapter = new ViewPagerAdapter(manager);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);

        //init drawer
        initDrawerLayout();
    }

    void setEvent() {
        edtSearch.setDrawableClickListener(new DrawableClickListener() {
            @Override
            public void onClick(DrawablePosition target) {
                switch (target) {
                    case LEFT:
                        //Do something here
                        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
                            //drawer is open
                            drawerLayout.closeDrawers();
                        }else {
                            drawerLayout.openDrawer(GravityCompat.START);
                        }
                        break;

                    case RIGHT:
                        Log.e(TAG, "onClick: " + "RIGHT");
                        break;
                }
            }
        });

    }

    void customActionBar() {
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle("");
        edtSearch = (CustomEditText) findViewById(R.id.edtSearch);
        setSupportActionBar(toolbar);
    }

    void initDrawerLayout() {

        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.acc_drawer_open, R.string.acc_drawer_close) {
            @SuppressLint("NewApi")
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float moveFactor = (lineDrawer.getWidth() * slideOffset);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    lineMain.setTranslationX(moveFactor);
                } else {
                    TranslateAnimation anim = new TranslateAnimation(lastTranslate, moveFactor, 0.0f, 0.0f);
                    anim.setDuration(0);
                    anim.setFillAfter(true);
                    lineMain.startAnimation(anim);

                    lastTranslate = moveFactor;
                }
            }
        };
        drawerLayout.setDrawerListener(mDrawerToggle);
        drawerLayout.setFitsSystemWindows(true);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
    }
}
