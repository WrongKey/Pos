package com.wrongkey.pos.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class DiscountItemTest {
    private DiscountItem discountItem;
    private String barcode;
    private float price;
    private int quantity;
    private int discount;

    @Before
    public void setUp() throws Exception {
        barcode = "ITEM0001";
        price = 40;
        quantity = 5;
        discount = 90;
        discountItem = new DiscountItem(discount,new RegularItem(barcode,price,quantity));
    }

    @Test
    public void should_calculate_cost_by_discount_ptomotion(){
        float expected = 180;
        assertEquals(expected, discountItem.calculateTheCost(),1e-6);
    }

//    @Test
//    public void should_return_discountItem_info_string_when_to_string(){
//        String expected = "  item1           5      40.0    180.0\n";
//        assertEquals(expected,discountItem.toString());
//    }

    @Test
    public void should_return_discountItem_which_quantity_changed_when_item_add_another_item(){
        int expectedQuantity = 10;
        assertEquals(expectedQuantity,discountItem.add(discountItem).getQuantity());
        assertSame(discountItem,discountItem.add(discountItem));
    }

}