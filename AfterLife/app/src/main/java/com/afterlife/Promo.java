package com.afterlife;

import java.util.ArrayList;

public class Promo {
    private String name;
    private int price;
    private ArrayList<String> feature = new ArrayList<String>();
    private boolean popular;

    public Promo(String name, int price, ArrayList<String> feature, boolean popular) {
        this.name = name;
        this.price = price;
        this.feature = feature;
        this.popular = popular;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<String> getFeature() {
        return feature;
    }

    public void setFeature(ArrayList<String> feature) {
        this.feature = feature;
    }

    public boolean getPopular(){
        return popular;
    }

    public void setPopular(boolean popular){
        this.popular = popular;
    }
}
