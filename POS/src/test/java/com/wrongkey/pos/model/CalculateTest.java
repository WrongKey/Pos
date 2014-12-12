package com.wrongkey.pos.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculateTest {
    Calculate calculate;
    private String barcode;
    private float price;
    private int quantity;
    private int discount;
    private int decrease;
    private float expectedCost;

    @Before
    public void setUp(){
        barcode = "ITEM0001";
        discount = 80;
        decrease = 5;
        price = 40;
        quantity = 5;
    }

    @Test
    public void should_calculate_cost_by_regular_item(){
        calculate = new RegularItem(barcode,price,quantity);
        expectedCost = price*quantity;
        assertEquals(expectedCost, calculate.calculateTheCost(), 1e-6);
    }

    @Test
    public void should_calculate_cost_by_second_half_price_promotion(){
        calculate = new SecondHalfPriceItem(new RegularItem(barcode,price,quantity));
        expectedCost = price*quantity-quantity/2*price/2;
        assertEquals(expectedCost, calculate.calculateTheCost(), 1e-6);
    }

    @Test
    public void should_calculate_cost_by_discount_promotion(){
        calculate = new DiscountItem(discount,new RegularItem(barcode,price,quantity));
        expectedCost = price * quantity*discount/100;
        assertEquals(expectedCost, calculate.calculateTheCost(), 1e-6);
    }

    @Test
    public void should_calculate_cost_by_full_hundred_minus_promotion(){
        calculate = new FullHundredMinusItem(decrease,new RegularItem(barcode,price,quantity));
        expectedCost = quantity*price-(int)(quantity*price)/100*5;
        assertEquals(expectedCost, calculate.calculateTheCost(), 1e-6);
    }
}