package com.wrongkey.pos.parser;

import java.io.BufferedReader;
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
    private Map<String,Integer> discountInfo = new HashMap<>();

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
            String tokens[] = line.split(":");
            String barcode = tokens[0];
            int discount = Integer.parseInt(tokens[1]);

            discountInfo.put(barcode,discount);
        }
    }
}