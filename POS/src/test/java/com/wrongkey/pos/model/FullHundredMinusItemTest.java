package com.wrongkey.pos.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class FullHundredMinusItemTest {
    private FullHundredMinusItem fullHundredMinusItem;
    private String barcode;
    private float price;
    private int quantity;
    private int decrease;

    @Before
    public void setUp() throws Exception {
        barcode = "ITEM0001";
        price = 40;
        quantity = 5;
        decrease = 5;
        fullHundredMinusItem = new FullHundredMinusItem(decrease,new RegularItem(barcode,price,quantity));
    }

    @Test
    public void should_calculate_cost_by_full_hundred_minus_ptomotion(){
        float expected = 190;
        assertEquals(expected, fullHundredMinusItem.calculateTheCost(),1e-6);
    }

//    @Test
//    public void should_return_fullHundredMinusItem_info_string_when_to_string(){
//        String expected = "  item1           5      40.0    190.0\n";
//        assertEquals(expected,fullHundredMinusItem.toString());
//    }

    @Test
    public void should_return_fullHundredMinusItem_which_quantity_changed_when_item_add_another_item(){
        int expectedQuantity = 10;
        assertEquals(expectedQuantity,fullHundredMinusItem.add(fullHundredMinusItem).getQuantity());
        assertSame(fullHundredMinusItem,fullHundredMinusItem.add(fullHundredMinusItem));
    }

}
