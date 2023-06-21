package com.afterlife.DataClass;

import java.util.ArrayList;

public class Coffin extends Purchaseable{
    private String detail;
    private String description;
    private ArrayList<String> size;
    private ArrayList<String> design;

    public Coffin(Purchaseable purchaseable, String detail, String description,
                  ArrayList<String> size, ArrayList<String> design) {
        super(purchaseable.getName(), purchaseable.getPrice(), purchaseable.getRating(),
                purchaseable.getSold(), purchaseable.getUrl(), purchaseable.getLocation());
        this.detail = detail;
        this.size = size;
        this.design = design;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getSize() {
        return size;
    }

    public void setSize(ArrayList<String> size) {
        this.size = size;
    }

    public ArrayList<String> getDesign() {
        return design;
    }

    public void setDesign(ArrayList<String> design) {
        this.design = design;
    }
}
