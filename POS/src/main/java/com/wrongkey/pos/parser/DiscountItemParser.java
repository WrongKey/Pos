package com.wrongkey.pos.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 *@author wrongkey
 *@description discount item information parser
 *@date 2014/11/20
 *@version v1.0
 *
 */
public class DiscountItemParser implements Parser{
    private static final String DISCOUNT_FILE_PATH =
            "G:\\ThoughtWorks\\POS\\src\\main\\resources\\com.wrongkey.pos\\discount_promotion.txt";

    private Map<String,Integer> discountInfo = new HashMap<>();

    /**
     * @param in
     * @return void
     * @author wrongkey
     * @description text parser
     * @date 2014/11/20
     */
    @Override
    public void parser() throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File(DISCOUNT_FILE_PATH)));
        String line = null;
        while((line = in.readLine())!=null){
            String tokens[] = line.split(":");
            String barcode = tokens[0];
            int discount = Integer.parseInt(tokens[1]);

            discountInfo.put(barcode,discount);
        }
    }

    public Map<String, Integer> getDiscountInfo(){
        return discountInfo;
    }
}
