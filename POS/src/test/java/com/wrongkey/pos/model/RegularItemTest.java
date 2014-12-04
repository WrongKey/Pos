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
        price = 40;
        quantity = 5;
        item = new RegularItem(barcode,price,quantity);
    }

    //测试RegularItem的calculateTheCost方法
    @Test
    public void should_return_quantity_multiplied_by_price_when_calculate_regular_cost(){
        assertEquals(quantity*price,item.calculateTheCost());
    }

    //测试RegularItem的toString方法
    @Test
    public void should_return_item_info_string_when_to_string(){
        String expected = "  item1           5      40.0    200.0\n";
        assertEquals(expected,item.toString());
    }

    //测试RegularItem的add方法,两个RegularItem相加，得到一个新的RegularItem
    // 新RegularItem的quantity等于原来两个quantity的和
    @Test
    public void should_return_RegularItem_which_quantity_changed_when_item_add_another_item(){
        int expectedQuantity = 10;
        assertEquals(expectedQuantity,item.add(item).getQuantity());
    }
}