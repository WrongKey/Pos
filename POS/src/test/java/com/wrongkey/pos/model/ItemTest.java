package com.wrongkey.pos.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ItemTest {
    private static final String EXCEPTION_INFO = "条码不同，不能加总...";
    private Item item1;
    private Item item2;


    @Before
    public void setUp() throws Exception {
        item1 = new RegularItem("ITEM0001",40,5);
        item2 = new RegularItem("ITEM0002",40,5);
    }

    @Test
    public void should_throw_ItemAddtionException_when_Items_barcode_different() throws Exception {
        try {
            item1.add(item2);
            fail();
        }catch (Exception e){
            assertThat((e instanceof ItemAddtionException),is(true));
        }
    }

    @Test
    public void should_contain_exception_messege_when_throw_ItemAddtionException(){
        try {
            item1.add(item2);
            fail();
        }catch (Exception e){
            assertEquals(EXCEPTION_INFO,e.getMessage());
        }
    }

    @Test
    public void should_calculate_the_cost_before_promotion() throws Exception {
        float expectedCost = 200f;
        assertEquals(expectedCost,item1.beforePromotionCost(),1e-6);
    }
}