package com.wrongkey.pos.model;

import com.wrongkey.pos.parser.*;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *@author wrongkey
 *@description generate cart
 *@date 2014/11/20
 *@version v1.0
 *
 */
public class Cart {
    private static Map<String,Item> cart = new TreeMap<>();

    /**
     *@author wrongkey
     *@description generate cart
     *@param []
     *@return void
     *@date 2014/11/20
     */
    public static void generateCart() throws Exception{
        CartInfoParser cartInfoParser = new CartInfoParser();
        cartInfoParser.parser();
        RegularItemParser regularItemParser = new RegularItemParser();
        regularItemParser.parser();
        SecondHalfPriceItemParser secondHalfPriceItemParser = new SecondHalfPriceItemParser();
        secondHalfPriceItemParser.parser();
        DiscountItemParser discountItemParser = new DiscountItemParser();
        discountItemParser.parser();

        Set<String> set = cartInfoParser.getCartInfo().keySet();
        Iterator<String> iter = set.iterator();
        String barcode = null;
        while(iter.hasNext()){
            barcode = iter.next();
            Item item = new RegularItem(barcode, regularItemParser.getItemInfo().
                    get(barcode), cartInfoParser.getCartInfo().get(barcode));
            if (secondHalfPriceItemParser.getSecondHalfPriceItem().contains(barcode)) {
                item = new SecondHalfPriceItem(barcode, regularItemParser.getItemInfo().
                        get(barcode), cartInfoParser.getCartInfo().get(barcode));
            }
            if (discountItemParser.getDiscountInfo().containsKey(barcode)) {
                item = new DiscountItem(discountItemParser.getDiscountInfo().get(barcode), item);
            }
            cart.put(barcode.toLowerCase().replaceAll("0", ""), item);
        }
    }

    /**
     *@author wrongkey
     *@description generate statement
     *@param []
     *@return void
     *@date 2014/11/20
     */
        public static String generateStatement(){
            String result = "";
            float total = 0;
            float totalBeforeYouhui = 0;
            result+="购物明细        数量     单 价    小 计\n";
            for (String code:cart.keySet()){
                Item item = cart.get(code);
                result+="  "+code+"          "+item.getQuantity()
                        +"      "+item.getPrice()+"    "+item.calculateTheCost()+"\n";
                total+=item.calculateTheCost();
                totalBeforeYouhui+=item.beforeYouhuiCost();
            }
            result+="-----------------总计-----------------\n";
            result+="总计金额    优惠前    优惠后    优惠差价\n";
            result+="  "+total+"    "+totalBeforeYouhui
                    +"     "+total+"     "+(totalBeforeYouhui-total);
            return result;
        }
    }
