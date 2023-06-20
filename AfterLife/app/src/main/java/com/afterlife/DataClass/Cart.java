package com.afterlife.DataClass;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Purchaseable> purchaseables = new ArrayList<>();
    private ArrayList<Integer> quantity = new ArrayList<Integer>();
    public Cart(ArrayList<Purchaseable> purchaseables) {
        this.purchaseables = purchaseables;
        for(int i=0;i< purchaseables.size();i++){
            quantity.add(1);
        }
    }

    public void addItem(Purchaseable newPurchaseable){
        this.purchaseables.add(newPurchaseable);
        this.quantity.add(1);
    }

    public Integer getQuantity(int index) {
        return quantity.get(index);
    }

    public void incrementQuantity(int index){
        int newValue = getQuantity(index) + 1;
        quantity.set(index, newValue);
    }

    public void decrementQuantity(int index){
        if(getQuantity(index) > 0){
            int newValue = getQuantity(index) - 1;
            quantity.set(index, newValue);
        }
    }

    public void setQuantity(ArrayList<Integer> quantity) {
        this.quantity = quantity;
    }

    public ArrayList<Purchaseable> getPurchaseables() {
        return purchaseables;
    }

    public Purchaseable getPurchasable(int position){
        return purchaseables.get(position);
    }

    public void setPurchaseables(ArrayList<Purchaseable> purchaseables) {
        this.purchaseables = purchaseables;
    }
}
