package com.example.sysadmin.alilayoutdemo1.Model;

/**
 * Created by sysadmin on 4/5/17.
 */

public class Category {
    private String name;
    private int id;
    private String urlImg;
    private int resImg;

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public int getResImg() {
        return resImg;
    }

    public void setResImg(int resImg) {
        this.resImg = resImg;
    }
}
