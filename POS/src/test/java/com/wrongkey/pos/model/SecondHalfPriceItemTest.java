package com.wrongkey.pos.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class SecondHalfPriceItemTest{
    private SecondHalfPriceItem secondHalfPriceItem;
    private String barcode;
    private float price;
    private int quantity;

    @Before
    public void setUp() {
        barcode = "ITEM0001";
        price = 40;
        quantity = 5;
        secondHalfPriceItem = new SecondHalfPriceItem(new RegularItem(barcode,price,quantity));
    }

    @Test
    public void should_calculate_cost_by_second_half_ptomotion(){
        float expected = 160;
        assertEquals(expected, secondHalfPriceItem.calculateTheCost(),1e-6);
    }

//    @Test
//    public void should_return_secondHalfPriceItem_info_string_when_to_string(){
//        String expected = "  item1           5      40.0    160.0\n";
//        assertEquals(expected,secondHalfPriceItem.toString());
//    }

    @Test
    public void should_return_SecondHalfPriceItem_which_quantity_changed_when_item_add_another_item(){
        int expectedQuantity = 10;
        assertEquals(expectedQuantity,secondHalfPriceItem.add(secondHalfPriceItem).getQuantity());
        assertSame(secondHalfPriceItem,secondHalfPriceItem.add(secondHalfPriceItem));
    }


}