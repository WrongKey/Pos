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
        String statement = "";
        Cart.generateCart();//生成购物车
        String result = Cart.generateStatement();
        assertEquals(statement, result);
    }
}
