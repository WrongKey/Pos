package com.wrongkey.pos.model;

import com.wrongkey.pos.parser.ConvertToItem;
import com.wrongkey.pos.parser.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CartTest {
    private Cart cart;
    private List<Pair> cartInfo;
    private ConvertToItem convert;
    private Item expectedItem;
    Pair info;

    @Before
    public void setUp(){
        cart = new Cart();
        info = new Pair("ITEM000001", 1);
        cartInfo = new ArrayList<>();
        cartInfo.add(info);
        convert = mock(ConvertToItem.class);
        cart.setConvert(convert);
        expectedItem = new RegularItem("ITEM000001",40,1);
    }

    @Test
    public void should_put_item_into_cart_when_get_a_info() throws Exception{

        when(convert.convertItem(info)).thenReturn(expectedItem);
        cart.initCart(cartInfo);

        verify(convert,times(1)).convertItem(info);
        assertEquals(expectedItem, cart.getCartMap().get("ITEM000001"));
    }

    @Test
    public void should_change_Item_quantity_when_add_same_barcode_item(){
        int expectedQuantity = expectedItem.getQuantity()+expectedItem.getQuantity();
        cart.addItem(expectedItem);
        cart.addItem(expectedItem);
        assertEquals(expectedQuantity,cart.getItemByBarcode(expectedItem.getBarcode()).getQuantity());
    }

}