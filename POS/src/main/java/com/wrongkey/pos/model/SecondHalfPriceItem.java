package com.wrongkey.pos.model;

/**
 *@author wrongkey
 *@description second half price promotion item
 *@date 2014/11/20
 *@version v1.0
 *
 */
public class SecondHalfPriceItem extends Item {

    public SecondHalfPriceItem(String barcode,float price,int quantity) {
        this.barcode = barcode;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * @return float
     * @author wrongkey
     * @description calculate the cost
     * @date 2014/11/20
     */
    @Override
    public float calculateTheCost() {
        return getPrice()*1.5f*(getQuantity()/2) +(getQuantity()%2)*getPrice();
    }
}
