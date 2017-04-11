package com.example.sysadmin.alilayoutdemo1.Model;

/**
 * Created by sysadmin on 4/5/17.
 */

public class Product {
    private int id;
    private String name;
    private String urlImg;
    private int resImg;
    private double price;
    private double priceGroup;
    private double discountPrice;

    public Product(int id, String name, String urlImg, int resImg, double price, double priceGroup, double discountPrice) {
        this.id = id;
        this.name = name;
        this.urlImg = urlImg;
        this.resImg = resImg;
        this.price = price;
        this.priceGroup = priceGroup;
        this.discountPrice = discountPrice;
    }

    public Product() {
    }

    public double getPriceGroup() {
        return priceGroup;
    }

    public void setPriceGroup(double priceGroup) {
        this.priceGroup = priceGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }
}
