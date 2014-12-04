package com.wrongkey.pos.model;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RegularItemTest{

    private RegularItem item;
    private String barcode;
    private float price;
    private int quantity;

    @Before
    public void setUp(){
        barcode = "ITEM0001";
        price = 50;
        quantity = 5;
        item = new RegularItem(barcode,50,5);
    }

    @Test
    public void should_get_price_which_price_in_set_up(){
        assertEquals(price,item.getPrice());
    }

    @Test
    public void should_get_quantity_which_quantity_in_set_up(){
        assertEquals(quantity,item.getQuantity());
    }

    @Test
    public void should_return_quantity_multiplied_by_price_when_calculate_regular_cost(){
        assertEquals(quantity*price,item.calculateTheCost());
    }

    @Test
    public void should_set_new_quantity_when_set_quantity(){
        quantity = 6;
        item.setQuantity(6);
        assertEquals(6,item.getQuantity());
    }

}