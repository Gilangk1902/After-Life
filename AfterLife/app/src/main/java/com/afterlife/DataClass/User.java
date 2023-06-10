package com.afterlife.DataClass;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private String name, email, password, profilePic, SIN, religion, gender;
    private Date DOB;
    private ArrayList<Address> addresses = new ArrayList<>();

    public User(String name, String email, String password, String profilePic, ArrayList<Address> addresses
    , String SIN, String religion, String gender, Date DOB) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.addresses = addresses;
        this.profilePic = profilePic;
        this.SIN = SIN;
        this.religion = religion;
        this.gender = gender;
        this.DOB = DOB;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public void setSIN(String SIN) {
        this.SIN = SIN;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public String getSIN() {
        return SIN;
    }

    public String getReligion() {
        return religion;
    }

    public String getGender() {
        return gender;
    }

    public Date getDOB() {
        return DOB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Address> getAddresses(){
        return this.addresses;
    }
    public String getProfilePic(){
        return this.profilePic;
    }
}
