package com.wrongkey.pos.parser;

import com.wrongkey.pos.model.Cart;

/**
 * Created by Administrator on 2014/12/3.
 */
public class TestMain {
    public static void main(String[] args) throws Exception{
        Cart cart = new Cart();
        cart.generateCart();
        System.out.println(cart.generateStatement());
    }
}
