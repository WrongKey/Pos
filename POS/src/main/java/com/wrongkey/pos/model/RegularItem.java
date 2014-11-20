package com.wrongkey.pos.model;

/**
 *@author wrongkey
 *@description RegularItem
 *@date 2014/11/20
 *@version v1.0
 *
 */
public class RegularItem extends Item {

    public RegularItem() {
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
