package com.wrongkey.pos;

import com.wrongkey.pos.model.Cart;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author wrongkey
 * @version v1.0
 * @description test generate statement
 * @date 2014/11/20
 */
public class TestGenerateStatement {
    /**
     * @param []
     * @return void
     * @author wrongkey
     * @description
     * @date 2014/11/20
     */
    @Test
    public void testGenerateStatement() throws Exception {
        String statement = "购物明细         数量     单 价    小 计\n" +
                "  item1           5        40      116\n" +
                "  item3           2        50      75\n" +
                "  item5           4        60      204\n" +
                "\n" +
                "-----------------总计-----------------\n" +
                "-------新的优惠，总消费满100减5元-------\n" +
                "\n" +
                "总计金额    优惠前    优惠后    优惠差价\n" +
                "    380      540       380       160";

        Cart.generateCart();//生成购物车
        String result = Cart.generateStatement();//生成账单
        assertEquals(statement, result);
    }
}
