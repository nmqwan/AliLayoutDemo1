package com.example.sysadmin.alilayoutdemo1.CustomView;

/**
 * Created by sysadmin on 4/4/17.
 */

public interface DrawableClickListener {
    public static enum DrawablePosition { TOP, BOTTOM, LEFT, RIGHT };
    public void onClick(DrawablePosition target);
}
