package com.afterlife;

public class Funeral {
    private String Name;
    private float rating;
    private String Location;
    private String religion;
    private String Url;

    private String feature1;
    private String feature2;
    private String feature3;
    private String feature4;

    public Funeral(String name, float rating, String location, String religion, String feature1, String feature2, String feature3, String feature4, String Url) {
        this.Name = name;
        this.rating = rating;
        this.Location = location;
        this.religion = religion;
        this.feature1 = feature1;
        this.feature2 = feature2;
        this.feature3 = feature3;
        this.feature4 = feature4;
        this.Url = Url;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
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

    public String getFeature1() {
        return feature1;
    }

    public void setFeature1(String feature1) {
        this.feature1 = feature1;
    }

    public String getFeature2() {
        return feature2;
    }

    public void setFeature2(String feature2) {
        this.feature2 = feature2;
    }

    public String getFeature3() {
        return feature3;
    }

    public void setFeature3(String feature3) {
        this.feature3 = feature3;
    }

    public String getFeature4() {
        return feature4;
    }

    public void setFeature4(String feature4) {
        this.feature4 = feature4;
    }

    public String getUrl(){
        return Url;
    }
    public void setUrl(String url){
        this.Url = url;
    }
}
