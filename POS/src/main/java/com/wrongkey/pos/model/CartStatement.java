package com.wrongkey.pos.model;

/**
 * Created by Administrator on 2014/12/9.
 */
public class CartStatement {
    private Cart cart;

    public CartStatement(Cart cart) {
        this.cart = cart;
    }

    /**
     * @param []
     * @return String
     * @author wrongkey
     * @description generate statement
     * @date 2014/11/20
     */

    public String generateStatement() {
        return generateDetails() + generateTotal();
    }

    /**
     * @param []
     * @return java.lang.String
     * @author wrongkey
     * @description 生成详细购物信息单
     * @date 2014/12/4
     */
    private String generateDetails() {
        String result = "";
        result += "购物明细         数量     单 价    小 计\n";
        for (String code : cart.getCartMap().keySet()) {
            Item item = cart.getItemByBarcode(code);
            result += item;
        }
        return result;
    }

    /**
     * @param []
     * @return java.lang.String
     * @author wrongkey
     * @description 生成购物信息总计单
     * @date 2014/12/4
     */
    private String generateTotal() {
        float total = 0;
        float totalBeforeDiscount = 0;
        for (String code : cart.getCartMap().keySet()) {
            Item item = cart.getItemByBarcode(code);
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
        return total - (int) total / 100 * decrease;
    }
}
