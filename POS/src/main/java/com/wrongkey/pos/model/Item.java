package com.wrongkey.pos.model;

/**
 *@author wrongkey
 *@description calculate the cost
 *@date 2014/11/20
 *@version v1.0
 *
 */
public abstract class Item implements Caculate{

    protected String barcode; //item's barcode
    protected float price;    //item's price
    protected int quantity;   //item's quantity

    public float getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public float beforePromotionCost(){
        return getPrice()*getQuantity();
    }

}
