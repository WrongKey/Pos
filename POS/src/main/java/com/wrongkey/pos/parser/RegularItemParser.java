package com.wrongkey.pos.parser;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
/**
 *@author wrongkey
 *@description regular item information parser
 *@date 2014/11/20
 *@version v1.0
 *
 */
public class RegularItemParser implements Parser{
    private Map<String,Float> itemInfo = new HashMap<>();

    /**
     * @param in
     * @return void
     * @author wrongkey
     * @description text parser
     * @date 2014/11/20
     */
    @Override
    public void parser(BufferedReader in) throws Exception{
        String line = null;
        while((line = in.readLine())!=null){
            String tokens[] = line.split(":");
            String barcode = tokens[0];
            float price = Float.parseFloat(tokens[1]);

            itemInfo.put(barcode,price);
        }

    }
}
