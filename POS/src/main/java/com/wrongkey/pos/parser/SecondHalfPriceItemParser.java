package com.wrongkey.pos.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
    private static final String SHPITEM_FILE_PATH =
            "G:\\ThoughtWorks\\POS\\src\\main\\resources\\com.wrongkey.pos\\second_half_price_promotion.txt";

    private Set<String> secondHalfPriceItem = new HashSet<>();
    /**
     * @param in
     * @return void
     * @author wrongkey
     * @description text parser
     * @date 2014/11/20
     */
    @Override
    public void parser() throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File(SHPITEM_FILE_PATH)));
        String line = null;
        while((line = in.readLine())!=null){
            secondHalfPriceItem.add(line);
        }
    }

    public Set<String> getSecondHalfPriceItem(){
        return secondHalfPriceItem;
    }
}
