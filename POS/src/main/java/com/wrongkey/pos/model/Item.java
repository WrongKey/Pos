package com.wrongkey.pos.model;

/**
 *@author wrongkey
 *@description calculate the cost
 *@date 2014/11/20
 *@version v1.0
 *
 */
public abstract class Item implements Caculate{

    protected String barcode;
    protected float price;
    protected int quantity;

    protected float getPrice() {
        return price;
    }
    protected int getQuantity() {
        return quantity;
    }

    public float beforePromotionCost(){
        return getPrice()*getQuantity();
    }

}
