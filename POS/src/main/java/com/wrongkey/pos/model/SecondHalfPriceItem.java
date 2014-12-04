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

    @Override
    protected void setQuantity(int quantity) {
        item.setQuantity(quantity);
    }

    /**
     * @return float
     * @author wrongkey
     * @description calculate the cost
     * @date 2014/11/20
     */
    @Override
    public float calculateTheCost() {
        return getPrice()*getQuantity()-(getPrice()/2)*(getQuantity()/2);
    }

    @Override
    protected float getPrice() {
        return item.getPrice();
    }

    @Override
    protected int getQuantity() {
        return item.getQuantity();
    }

    @Override
    protected String getBarcode() {
        return item.getBarcode();
    }
}
