package com.wrongkey.pos.model;

/**
 * @author wrongkey
 * @version v1.0
 * @description second half price promotion item
 * @date 2014/11/20
 */
public class SecondHalfPriceItem extends Item {
    private Item item;

    public SecondHalfPriceItem(Item item) {
        this.item = item;
    }

    private Item getItem() {
        return item;
    }

    @Override
    protected String getBarcode() {
        return getItem().getBarcode();
    }

    protected int getPrice() {
        return getItem().getPrice();
    }

    protected int getQuantity() {
        return getItem().getQuantity();
    }

    @Override
    protected void setQuantity(int quantity) {
        getItem().setQuantity(quantity);
    }

    /**
     * @return int
     * @author wrongkey
     * @description calculate the cost
     * @date 2014/11/20
     */
    @Override
    public int calculateTheCost() {
        return (getPrice() + getPrice() / 2) * (getQuantity() / 2) + (getQuantity() % 2) * getPrice();
    }
}
