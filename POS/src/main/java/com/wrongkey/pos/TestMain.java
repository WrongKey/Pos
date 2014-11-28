package com.wrongkey.pos;

import com.wrongkey.pos.model.Cart;

public class TestMain {
    public static void main(String[] args) throws Exception {
        Cart.generateCart();
        System.out.println(Cart.generateStatement());
    }
}
