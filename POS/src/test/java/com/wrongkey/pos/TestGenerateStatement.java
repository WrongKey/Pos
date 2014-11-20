package com.wrongkey.pos;

import com.wrongkey.pos.model.Cart;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 *@author wrongkey
 *@description test generate statement
 *@date 2014/11/20
 *@version v1.0
 *
 */
public class TestGenerateStatement {
    /**
     *@author wrongkey
     *@description
     *@param []
     *@return void
     *@date 2014/11/20
     */
    @Test
    public void testGenerateStatement()throws Exception{
        String statement = "购物明细        数量     单 价    小 计\n" +
                "  item1          5      40.0    120.0\n" +
                "  item3          2      50.0    75.0\n" +
                "  item5          4      60.0    216.0\n" +
                "-----------------总计-----------------\n" +
                "总计金额    优惠前    优惠后    优惠差价\n" +
                "  411.0    540.0     411.0     129.0";
        Cart.generateCart();//生成购物车
        String result = Cart.generateStatement();
        assertEquals(statement, result);
    }
}
