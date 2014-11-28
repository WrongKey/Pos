package com.wrongkey.pos.model;

/**
 * @author wrongkey
 * @version v1.0
 * @description RegularItem
 * @date 2014/11/20
 */
public class RegularItem extends Item {

    public RegularItem(String barcode, int price, int quantity) {
        this.barcode = barcode;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * @return int
     * @author wrongkey
     * @description calculate the cost
     * @date 2014/11/20
     */
    @Override
    public int calculateTheCost() {
        return getPrice() * getQuantity();
    }

}
