package com.wrongkey.pos.main;

import com.wrongkey.pos.parser.CartInfoParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *@author wrongkey
 *@description TestMain
 *@date 2014/11/20
 *@version v1.0
 *
 */
public class TestMain {
    public static void main(String[] args) throws Exception{
        File in = new File("G:\\ThoughtWorks\\POS\\src\\main\\resources\\com.wrongkey.pos\\cart.txt");
        CartInfoParser cartInfoParser = new CartInfoParser();
        cartInfoParser.parser(new BufferedReader(new FileReader(in)));

        System.out.println(cartInfoParser.getCart());
    }
}
