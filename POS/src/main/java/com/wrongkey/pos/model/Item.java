package com.wrongkey.pos.model;

/**
 *@author wrongkey
 *@description calculate the cost
 *@date 2014/11/20
 *@version v1.0
 *
 */
public abstract class Item implements Caculate{

    private String barcode; //item's barcode
    private float price;    //item's price
    private int quantity;   //item's quantity

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getQuantity() {
        return quantity;
    }

}
