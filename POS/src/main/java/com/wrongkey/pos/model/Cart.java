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
    private static final String CARTINFO_PATH = "G:\\ThoughtWorks\\POS\\src\\main\\resources\\com.wrongkey.pos\\cart.txt";
    private static List<Pair> cartInfo;

    private  Map<String, Item> cart = new TreeMap<>();

    static{
        try {
            cartInfo = new CartInfoParse().parse(CARTINFO_PATH);
        } catch (IOException e) {
            System.out.println("解析购物车信息失败");
            e.printStackTrace();
        }
    }
    /**
     * @param []
     * @return void
     * @author wrongkey
     * @description generate cart
     * @date 2014/11/20
     */
    public void generateCart() throws Exception {
        Iterator<Pair> iterator = cartInfo.iterator();
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
    public String generateStatement() {
        String result = "";
        float total = 0;
        float totalBeforeDiscount = 0;
        result += "购物明细         数量     单 价    小 计\n";
        for (String code : cart.keySet()) {
            Item item = cart.get(code);
            result += "  " + (code.toLowerCase().replaceAll("0", "")) + "           " + item.getQuantity()
                    + "      " + item.getPrice() + "    " + item.calculateTheCost() + "\n";
            total += item.calculateTheCost();
            totalBeforeDiscount += item.beforePromotionCost();
        }
        result += "\n-----------------总计-----------------\n";
        result += "-------新的优惠，总消费满100减5元-------\n\n";
        total = totalCostFullHundredMinus(total, 5);
        result += "总计金额    优惠前    优惠后    优惠差价\n";
        result += "  " + total + "     " + totalBeforeDiscount
                + "    " + total + "     " + (totalBeforeDiscount - total);
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
