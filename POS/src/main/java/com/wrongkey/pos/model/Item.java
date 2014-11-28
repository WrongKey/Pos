package com.wrongkey.pos.model;

/**
 *@author wrongkey
 *@description calculate the cost
 *@date 2014/11/20
 *@version v1.0
 *
 */
public abstract class Item implements Caculate{

    protected String barcode;
    protected int price;
    protected int quantity;

    protected int getPrice() {
        return price;
    }
    protected int getQuantity() {
        return quantity;
    }
    protected String getBarcode(){
        return barcode;
    }
    public Item add(Item item){
        setQuantity(getQuantity() + item.getQuantity());
        return this;
    }

    protected void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int beforePromotionCost(){
        return getPrice()*getQuantity();
    }

    @Override
    public String toString() {
        return "barcode:"+getBarcode()+"    price: "+getPrice()+"   quantity: "+getQuantity();
    }
}
