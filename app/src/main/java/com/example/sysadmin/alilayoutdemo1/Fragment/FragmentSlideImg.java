package com.example.sysadmin.alilayoutdemo1.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.sysadmin.alilayoutdemo1.Adapter.SlideImgFragNewAdapter;
import com.example.sysadmin.alilayoutdemo1.R;

/**
 * Created by sysadmin on 4/5/17.
 */

public class FragmentSlideImg extends BaseFragment  implements ViewPager.OnPageChangeListener {

    private ViewPager intro_images;
    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;
    private SlideImgFragNewAdapter mAdapter;
    private View v;
    private int[] mImageResources = {
            R.drawable.img_slide,
            R.drawable.img_slide,
            R.drawable.img_slide,
            R.drawable.img_slide,
            R.drawable.img_slide
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_slide_img,container,false);
        addCreateView();
        return v;
    }


    @Override
    protected void initData() {
        intro_images = (ViewPager) v.findViewById(R.id.pager_introduction);
        pager_indicator = (LinearLayout) v.findViewById(R.id.viewPagerCountDots);
        mAdapter = new SlideImgFragNewAdapter(getActivity(), mImageResources);
        intro_images.setAdapter(mAdapter);
        intro_images.setCurrentItem(0);
        intro_images.setOnPageChangeListener(this);
        setUiPageViewController();
    }

    @Override
    protected void setData() {

    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
        }

        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    private void setUiPageViewController() {

        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }


}
