package com.wrongkey.pos.model;

/**
 * @author wrongkey
 * @version v1.0
 * @description discount promotion item
 * @date 2014/11/20
 */
public class DiscountItem extends Item {
    private Item item;
    private int discount;

    public DiscountItem( int discount,Item item) {
        this.discount = discount;
        this.item = item;
    }

    @Override
    protected void setQuantity(int quantity) {
        item.setQuantity(quantity);
    }

    @Override
    protected float getPrice() {
        return item.getPrice();
    }

    @Override
    protected int getQuantity() {
        return item.getQuantity();
    }

    /**
     * @return float
     * @author wrongkey
     * @description calculate the cost
     * @date 2014/11/20
     */
    @Override
    public float calculateTheCost() {
        return item.calculateTheCost()*discount/100;
    }

}
