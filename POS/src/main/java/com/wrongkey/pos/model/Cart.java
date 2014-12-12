package com.wrongkey.pos.model;

import com.wrongkey.pos.parser.ConvertToItem;
import com.wrongkey.pos.parser.Pair;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author wrongkey
 * @version v1.0
 * @description generate cartMap
 * @date 2014/11/20
 */
public class Cart {
    private  Map<String, Item> cartMap;
    private ConvertToItem convert;

    public Cart() {
        this.cartMap = new TreeMap<>();
        this.convert = new ConvertToItem();
    }

    protected void setConvert(ConvertToItem convert) {
        this.convert = convert;
    }

    public Map<String, Item> getCartMap() {
        return cartMap;
    }

    /**
     * @param []
     * @return void
     * @author wrongkey
     * @description generate cartMap
     * @date 2014/11/20
     */
    public void initCart(List<Pair> cartInfo) throws Exception {
        for (Pair info : cartInfo){
            Item item = convert.convertItem(info);
            addItem(item);
        }
    }

    protected void addItem(Item item){
        if (cartMap.containsKey(item.getBarcode())) {
            item = item.add(cartMap.get(item.getBarcode()));
            cartMap.remove(item.getBarcode());
        }
        cartMap.put(item.getBarcode(), item);
    }

    public Item getItemByBarcode(String barcode){
        return cartMap.get(barcode);
    }

}
