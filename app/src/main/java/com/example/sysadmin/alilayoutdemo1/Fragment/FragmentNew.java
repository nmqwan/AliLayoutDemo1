package com.example.sysadmin.alilayoutdemo1.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.sysadmin.alilayoutdemo1.Adapter.ImageCatAdapter;
import com.example.sysadmin.alilayoutdemo1.Model.Category;
import com.example.sysadmin.alilayoutdemo1.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by sysadmin on 4/4/17.
 */

public class FragmentNew extends Fragment {
    View v;

    Unbinder unbinder;

    @BindView(R.id.recylcerImgCat)
    RecyclerView recylcerImgCat;
    @BindView(R.id.lineFlashSale)
    LinearLayout lineFlashSale;

    private FragmentTransaction transaction;
    private Fragment fragSlideImg,fragFlashSale;

    private ArrayList<Category> categories;
    private RecyclerView.Adapter adapterCatimg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_new, container, false);
        unbinder = ButterKnife.bind(this, v);
        initData();
        setEvent();
        return v;
    }

    void initData() {
        fragSlideImg = new FragmentSlideImg();
        fragFlashSale = new FragmentFlashSale();
        //set img slide
        setFragment(fragSlideImg, R.id.lineContaierImgSlide);
        setFragment(fragFlashSale, R.id.lineFlashSale);

        categories = new ArrayList<>();
        Category c1 = new Category();
        c1.setName("Cafe");
        c1.setResImg(R.drawable.cafe);
        Category c2 = new Category();
        c2.setName("Cafe");
        c2.setResImg(R.drawable.cafe);
        Category c3 = new Category();
        c3.setName("Cafe");
        c3.setResImg(R.drawable.cafe);
        Category c4 = new Category();
        c4.setName("Cafe");
        c4.setResImg(R.drawable.cafe);
        Category c5 = new Category();
        c5.setName("Cafe");
        c5.setResImg(R.drawable.cafe);
        Category c6 = new Category();
        c6.setName("Cafe");
        c6.setResImg(R.drawable.cafe);
        Category c7 = new Category();
        c7.setName("Cafe");
        c7.setResImg(R.drawable.cafe);
        Category c8 = new Category();
        c8.setName("Cafe");
        c8.setResImg(R.drawable.cafe);
        Category c9 = new Category();
        c9.setName("Cafe");
        c9.setResImg(R.drawable.cafe);
        Category c10 = new Category();
        c10.setName("Cafe");
        c10.setResImg(R.drawable.cafe);

        categories.add(c1);
        categories.add(c2);
        categories.add(c3);
        categories.add(c4);
        categories.add(c5);
        categories.add(c6);
        categories.add(c7);
        categories.add(c8);
        categories.add(c9);
        categories.add(c10);

        adapterCatimg = new ImageCatAdapter(getContext(), categories);
        recylcerImgCat.setAdapter(adapterCatimg);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recylcerImgCat.setLayoutManager(linearLayoutManager);

    }

    void setEvent() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    void setFragment(Fragment fragment, int layout) {
        transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(layout, fragment);
        transaction.commit();

    }
}
