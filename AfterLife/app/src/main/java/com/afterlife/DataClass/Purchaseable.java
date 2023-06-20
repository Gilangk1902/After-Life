package com.afterlife.DataClass;

public class Purchaseable {
    private String name;
    private float rating;
    private int sold;
    private int price;
    private String Url;
    private String location;

    public Purchaseable(String name, int price,float rating, int sold, String url, String location) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.sold = sold;
        this.location = location;
        Url = url;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getLocation(){
        return this.location;
    }
}
