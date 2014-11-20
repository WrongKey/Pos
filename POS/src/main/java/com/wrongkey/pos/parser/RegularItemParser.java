package com.wrongkey.pos.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
    private static final String REGULAR_ITEM_FILE_PATH =
            "G:\\ThoughtWorks\\POS\\src\\main\\resources\\com.wrongkey.pos\\itemlist.txt";

    private Map<String,Float> itemInfo = new HashMap<>();

    /**
     * @param in
     * @return void
     * @author wrongkey
     * @description text parser
     * @date 2014/11/20
     */
    @Override
    public void parser() throws Exception{
        BufferedReader in = new BufferedReader(new FileReader(new File(REGULAR_ITEM_FILE_PATH)));
        String line = null;
        while((line = in.readLine())!=null){
            String tokens[] = line.split(":");
            String barcode = tokens[0];
            float price = Float.parseFloat(tokens[1]);

            itemInfo.put(barcode,price);
        }

    }

    public Map<String, Float> getItemInfo(){
        return itemInfo;
    }
}
