package com.wrongkey.pos.model;

/**
 * @author wrongkey
 * @version v1.0
 * @description RegularItem
 * @date 2014/11/20
 */
public class RegularItem extends Item {
    private String barcode;
    private float price;
    private int quantity;

    public RegularItem(String barcode, float price, int quantity) {
        this.barcode = barcode;
        this.price = price;
        this.quantity = quantity;
    }

    protected float getPrice() {
        return price;
    }

    protected int getQuantity() {
        return quantity;
    }

    @Override
    protected void setQuantity(int quantity) {
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
        return getPrice()*getQuantity();
    }

}
