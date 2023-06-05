package com.afterlife.DataClass;

import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private String password;
    private String profilePic;
    private ArrayList<Address> addresses = new ArrayList<>();

    public User(String name, String email, String password, String profilePic,ArrayList<Address> addresses) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.addresses = addresses;
        this.profilePic = profilePic;
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
