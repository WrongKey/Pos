package com.wrongkey.pos.model;
/**
 *@author wrongkey
 *@description discount promotion item
 *@date 2014/11/20
 *@version v1.0
 *
 */
public class DiscountItem extends Item {
    private Item item;
    private int discount;

    public DiscountItem(int discount, Item item) {
        this.discount = discount;
        this.item = item;
    }

    /**
     * @return float
     * @author wrongkey
     * @description calculate the cost
     * @date 2014/11/20
     */
    @Override
    public float calculateTheCost() {
        return getItem().calculateTheCost()*getDiscount()/100f;
    }

    public Item getItem() {
        return item;
    }

    public int getDiscount() {
        return discount;
    }
}
