package com.wrongkey.pos.model;

import com.wrongkey.pos.parser.*;

import java.io.IOException;
import java.util.*;

/**
 * @author wrongkey
 * @version v1.0
 * @description generate cartMap
 * @date 2014/11/20
 */
public class Cart {
    private  Map<String, Item> cartMap;

    public Cart() {
        this.cartMap = new TreeMap<>();
    }

    /**
     * @param []
     * @return void
     * @author wrongkey
     * @description generate cartMap
     * @date 2014/11/20
     */
    public void generateCart(List<Pair> cartInfo) throws Exception {
        Iterator<Pair> iterator = cartInfo.iterator();
        Pair info;
        while (iterator.hasNext()) {
            info = iterator.next();
            Item item = ConvertToItem.convertItem(info);

            if (cartMap.containsKey(info.getKey())) {
                item = item.add(cartMap.get(info.getKey()));
                cartMap.remove(info.getKey());
            }
            cartMap.put(info.getKey(), item);
        }
    }


    /**
     * @param []
     * @return String
     * @author wrongkey
     * @description generate statement
     * @date 2014/11/20
     */
    public String generateStatement() {
        return generateDetails()+generateTotal();
    }

    /**
     *@author wrongkey
     *@description 生成详细购物信息单
     *@param []
     *@return java.lang.String
     *@date 2014/12/4
     */
    private String generateDetails(){
        String result = "";
        result += "购物明细         数量     单 价    小 计\n";
        for (String code : cartMap.keySet()) {
            Item item = cartMap.get(code);
            result += item;
        }
        return result;
    }

    /**
     *@author wrongkey
     *@description 生成购物信息总计单
     *@param []
     *@return java.lang.String
     *@date 2014/12/4
     */
    private String generateTotal(){
        float total = 0;
        float totalBeforeDiscount = 0;
        for (String code : cartMap.keySet()) {
            Item item = cartMap.get(code);
            total += item.calculateTheCost();
            totalBeforeDiscount += item.beforePromotionCost();
        }
        String result = "\n-----------------总计-----------------\n-------新的优惠，总消费满100减5元-------\n\n总计金额    优惠前    优惠后    优惠差价\n";
        total = totalCostFullHundredMinus(total, 5);
        result += "  " + total + "     " + totalBeforeDiscount + "    " + total + "     " + (totalBeforeDiscount - total);
        return result;
    }

    /**
     * @param [total, decrease]
     * @return int
     * @author wrongkey
     * @description 新的优惠，总消费满100减5元
     * @date 2014/11/28
     */
    protected float totalCostFullHundredMinus(float total, int decrease) {
        return total - (int)total / 100 * decrease;
    }
}
