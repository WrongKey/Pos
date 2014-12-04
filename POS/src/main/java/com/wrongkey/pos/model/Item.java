package com.wrongkey.pos.model;

/**
 * @author wrongkey
 * @version v1.0
 * @description calculate the cost
 * @date 2014/11/20
 */
public abstract class Item implements Calculate {

    protected abstract float getPrice();
    protected abstract int getQuantity();

    protected abstract void setQuantity(int quantity);

    public Item add(Item item){
        this.setQuantity(this.getQuantity()+item.getQuantity());
        return this;
    }

    public float beforePromotionCost() {
        return getQuantity()*getPrice();
    }
}

