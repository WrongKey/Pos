package com.wrongkey.pos.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

/**
 *@author wrongkey
 *@description cart information parser
 *@date 2014/11/20
 *@version v1.0
 *
 */
public class CartInfoParser implements Parser{
    private static final String CART_FILE_PATH =
            "G:\\ThoughtWorks\\POS\\src\\main\\resources\\com.wrongkey.pos\\cart.txt";

    private Map<String,Integer> cartInfo = new TreeMap<>();
    /**
     * @param in
     * @return void
     * @author wrongkey
     * @description text parser
     * @date 2014/11/20
     */
    @Override
    public void parser() throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File(CART_FILE_PATH)));
        String line = null;
        String barcode = null;
        while((line = in.readLine())!=null){
            int quantity = 1;
            if(line.contains("-")) {
                String tokens[] = line.split("-");
                barcode = tokens[0];
                quantity = Integer.parseInt(tokens[1]);
            }else{
                barcode = line;
            }
            if(cartInfo.containsKey(barcode)){
                quantity += cartInfo.get(barcode);
                cartInfo.remove(barcode);
            }
            cartInfo.put(barcode,quantity);
        }
    }

    public Map<String, Integer> getCartInfo(){
        return cartInfo;
    }
}
