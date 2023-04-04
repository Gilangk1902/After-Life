package com.afterlife.DataClass;

import java.util.Date;

public class Deceased {
    String name;
    int SIN;
    Date date_of_birth;
    Date date_of_death;
    String gender;
    String religion;

    public Deceased(String name, int SIN, Date date_of_birth, Date date_of_death, String gender, String religion) {
        this.name = name;
        this.SIN = SIN;
        this.date_of_birth = date_of_birth;
        this.date_of_death = date_of_death;
        this.gender = gender;
        this.religion = religion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSIN() {
        return SIN;
    }

    public void setSIN(int SIN) {
        this.SIN = SIN;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Date getDate_of_death() {
        return date_of_death;
    }

    public void setDate_of_death(Date date_of_death) {
        this.date_of_death = date_of_death;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }
}
