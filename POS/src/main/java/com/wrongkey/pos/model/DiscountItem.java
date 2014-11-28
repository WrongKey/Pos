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

    public DiscountItem(int discount, Item item) {
        this.discount = discount;
        this.item = item;
    }

    /**
     * @return int
     * @author wrongkey
     * @description calculate the cost
     * @date 2014/11/20
     */
    @Override
    public int calculateTheCost() {
        return getItem().calculateTheCost() * getDiscount() / 100;
    }

    public Item getItem() {
        return item;
    }

    private int getDiscount() {
        return discount;
    }

    @Override
    protected int getQuantity() {
        return getItem().getQuantity();
    }

    @Override
    protected int getPrice() {
        return getItem().getPrice();
    }

    protected String getBarcode() {
        return getItem().getBarcode();
    }

    @Override
    protected void setQuantity(int quantity) {
        getItem().setQuantity(quantity);
    }
}
