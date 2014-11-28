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
        this.item = item;
        this.decrease = decrease;
    }

    private Item getItem() {
        return item;
    }

    private int getDecrease() {
        return decrease;
    }

    protected int getQuantity() {
        return getItem().getQuantity();
    }

    @Override
    protected void setQuantity(int quantity) {
        getItem().setQuantity(quantity);
    }

    @Override
    protected int getPrice() {
        return getItem().getPrice();
    }

    protected String getBarcode() {
        return getItem().getBarcode();
    }

    /**
     * @return int
     * @author wrongkey
     * @description calculate the cost
     * @date 2014/11/20
     */
    @Override
    public int calculateTheCost() {
        return getItem().calculateTheCost() -
                getItem().calculateTheCost() / 100 * getDecrease();
    }
}
