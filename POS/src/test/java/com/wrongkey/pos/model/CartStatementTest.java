package com.wrongkey.pos.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class CartStatementTest {
    private String expectedStatement;
    private Cart cart;
    private  CartStatement cartStatement;
    @Before
    public void setUp(){
        cart = Mockito.mock(Cart.class);
        cartStatement = new CartStatement(cart);
//        Mockito.when(cart.getCartMap()).thenReturn()
    }

    @Test
    public void should_generate_statement(){

    }

    @Test
    public void testTotalCostFullHundredMinus(){
        float total = 456f;
        int decrease = 5;
        float expected = total - (int)total/100*5;
        assertEquals(expected,cartStatement.totalCostFullHundredMinus(total,decrease),1e-6);
    }
}