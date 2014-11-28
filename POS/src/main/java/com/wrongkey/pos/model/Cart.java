package com.wrongkey.pos.model;

import com.wrongkey.pos.parser.*;

import java.io.IOException;
import java.util.*;

/**
 * @author wrongkey
 * @version v1.0
 * @description generate cart
 * @date 2014/11/20
 */
public class Cart {

    private static Map<String, Item> cart = new TreeMap<>();
    /**
     * @param []
     * @return void
     * @author wrongkey
     * @description generate cart
     * @date 2014/11/20
     */
    public static void generateCart() throws Exception {
        Iterator<Pair> iterator = ConvertToItem.getCartInfo().iterator();
        String barcode = null;
        Pair info = null;
        while (iterator.hasNext()) {
            info = iterator.next();
            Item item = ConvertToItem.convertItem(info);

            if (cart.containsKey(info.getKey())) {
                item = item.add(cart.get(info.getKey()));
                cart.remove(info.getKey());
            }
            cart.put(info.getKey(), item);
        }
    }



    /**
     * @param []
     * @return String
     * @author wrongkey
     * @description generate statement
     * @date 2014/11/20
     */
    public static String generateStatement() {
        String result = "";
        int total = 0;
        int totalBeforeDiscount = 0;
        result += "购物明细         数量     单 价    小 计\n";
        for (String code : cart.keySet()) {
            Item item = cart.get(code);
            result += "  "+(code.toLowerCase().replaceAll("0","")) + "           " + item.getQuantity()
                    + "        " + item.getPrice() + "      " + item.calculateTheCost() + "\n";
            total += item.calculateTheCost();
            totalBeforeDiscount += item.beforePromotionCost();
        }
        result += "\n-----------------总计-----------------\n";
        result += "-------新的优惠，总消费满100减5元-------\n\n";
        total = totalCostFullHundredMinus(total,5);
        result += "总计金额    优惠前    优惠后    优惠差价\n";
        result += "    " + total + "      " + totalBeforeDiscount
                + "       " + total + "       " + (totalBeforeDiscount - total);
        return result;
    }

    /**
     *@author wrongkey
     *@description 新的优惠，总消费满100减5元
     *@param [total, decrease]
     *@return int
     *@date 2014/11/28
     */
    protected static int totalCostFullHundredMinus(int total,int decrease){
        return total-total/100*decrease;
    }
}
