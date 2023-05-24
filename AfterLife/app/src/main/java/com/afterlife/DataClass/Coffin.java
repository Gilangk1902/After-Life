package com.afterlife.DataClass;

import java.util.ArrayList;

public class Coffin extends Purchaseable{
    private int price;
    private String detail;
    private String description;
    private ArrayList<String> size;
    private ArrayList<String> design;

    public Coffin(String name, float rating, int sold, String url) {
        super(name, rating, sold, url);
    }
}
