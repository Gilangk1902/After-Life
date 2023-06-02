package com.afterlife.DataClass;

public class Address {
    private String addressTitle, name, phoneNumber, addressDescription;

    public Address(String addressTitle, String name, String phoneNumber, String addressDescription) {
        this.addressTitle = addressTitle;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.addressDescription = addressDescription;
    }

    public String getAddressTitle() {
        return addressTitle;
    }

    public void setAddressTitle(String addressTitle) {
        this.addressTitle = addressTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressDescription() {
        return addressDescription;
    }

    public void setAddressDescription(String addressDescription) {
        this.addressDescription = addressDescription;
    }
}
