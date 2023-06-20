package com.afterlife.DataClass;

import java.util.ArrayList;

public class Funeral extends Purchaseable{
    private String Location;
    private String religion;

    private ArrayList<String> features;

    public Funeral(String name, int price,float rating, String location, String religion,
                   int sold,String url, ArrayList<String> features)
    {
        super(name, price,rating, sold, url, location);
        this.religion = religion;
        this.features = features;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getFeature(int index){
        if(index < this.features.size())
            return this.features.get(index);
        else
            return "";
    }
}
