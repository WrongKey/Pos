package com.wrongkey.pos.parser;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

/**
 *@author wrongkey
 *@description cart information parser
 *@date 2014/11/20
 *@version v1.0
 *
 */
public class CartInfoParser implements Parser{
    private  Map<String,Integer> cart = new HashMap<>();
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
            if(cart.containsKey(barcode)){
                quantity += cart.get(barcode);
                cart.remove(barcode);
            }
            cart.put(barcode,quantity);
        }
    }

    public  Map<String, Integer> getCart() {
        return cart;
    }
}
