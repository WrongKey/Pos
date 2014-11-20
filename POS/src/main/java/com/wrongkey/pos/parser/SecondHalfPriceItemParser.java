package com.wrongkey.pos.parser;

import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Set;

/**
 *@author wrongkey
 *@description second_half_price item parser
 *@date 2014/11/20
 *@version v1.0
 *
 */
public class SecondHalfPriceItemParser implements Parser{
    private Set<String> secondHalfPriceItem = new HashSet<>();
    /**
     * @param in
     * @return void
     * @author wrongkey
     * @description text parser
     * @date 2014/11/20
     */
    @Override
    public void parser(BufferedReader in) throws Exception {
        String line = null;
        while((line = in.readLine())!=null){
            secondHalfPriceItem.add(line);
        }
    }
}
