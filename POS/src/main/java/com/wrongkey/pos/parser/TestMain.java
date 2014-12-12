package com.wrongkey.pos.parser;

import com.wrongkey.pos.model.Cart;
import com.wrongkey.pos.model.CartStatement;

import java.util.List;

/**
 * Created by Administrator on 2014/12/3.
 */
public class TestMain {
    public static void main(String[] args) throws Exception{
        String CARTINFO_PATH = "G:\\ThoughtWorks\\POS\\src\\main\\resources\\com.wrongkey.pos\\cart.txt";
        List<Pair> cartInfo = new CartInfoParse().parse(CARTINFO_PATH);

        Cart cart = new Cart();
        cart.initCart(cartInfo);
        CartStatement cartStatement = new CartStatement(cart);
        System.out.println(cartStatement.generateStatement());
    }

}
