package com.wrongkey.pos.model;

/**
 * @author wrongkey
 * @version v1.0
 * @description 新的优惠，满一百减多少的Item
 * @date 2014/11/28
 */
public class FullHundredMinusItem extends Item {
    private Item item;
    private int decrease;

    public FullHundredMinusItem(int decrease, Item item) {
        this.decrease = decrease;
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
        return item.calculateTheCost()-(int)(item.calculateTheCost())/100*decrease;
    }
}
