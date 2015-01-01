package com.wrongkey.pos.parser;

import com.wrongkey.pos.model.*;

import java.io.IOException;
import java.util.List;

/**
 * @author wrongkey
 * @version v1.0
 * @description 把解析出来的信息转换成对象
 * @date 2014/11/28
 */
public class ConvertToItem {

    private static final String DISCINFO_PATH = "/home/wrongkey/IdeaProjects/Pos/POS/src/main/resources/com.wrongkey.pos/discount_promotion.txt";
    private static final String ITEMINFO_PATH = "/home/wrongkey/IdeaProjects/Pos/POS/src/main/resources/com.wrongkey.pos/itemlist.txt";
    private static final String FULL_HUNDRED_MINUS_INFO_PATH = "/home/wrongkey/IdeaProjects/Pos/POS/src/main/resources/com.wrongkey.pos/full_hundred_minus.txt";
    private static final String SECOND_HALF_PRICE_PATH = "/home/wrongkey/IdeaProjects/Pos/POS/src/main/resources/com.wrongkey.pos/second_half_price_promotion.txt";


    private static List<Pair> regularItemInfo;
    private static List<Pair> discountItemInfo;
    private static List<Pair> fullHundredMinusInfo;
    private static List<String> secondHalfPriceInfo;

    static {
        try {
            regularItemInfo = new RegularItemParse().parse(ITEMINFO_PATH);
            discountItemInfo = new DiscountItemParse().parse(DISCINFO_PATH);
            fullHundredMinusInfo = new FullHundredMinusParse().parse(FULL_HUNDRED_MINUS_INFO_PATH);
            secondHalfPriceInfo = new SecondHalfPriceItemParse().parse(SECOND_HALF_PRICE_PATH);
        } catch (IOException e) {
            System.out.println("failed to parse file");
            e.printStackTrace();
        }
    }

    /**
     * @param [info]
     * @return com.wrongkey.pos.model.Item
     * @author wrongkey
     * @description convert info to Item
     * @date 2014/11/28
     */
    public Item convertItem(Pair info) {
        String barcode = info.getKey();
        Item item = new RegularItem(barcode, getInfoByBarcode(barcode, regularItemInfo), info.getValue());
        if (secondHalfPriceInfo.contains(barcode)) {
            item = new SecondHalfPriceItem(item);
        }
        if (containBarcode(barcode, discountItemInfo)) {
            item = new DiscountItem(getInfoByBarcode(barcode, discountItemInfo), item);
        }
        if (containBarcode(barcode, fullHundredMinusInfo)) {
            item = new FullHundredMinusItem(getInfoByBarcode(barcode, fullHundredMinusInfo), item);
        }
        return item;
    }

    /**
     * @param [barcode, list]
     * @return boolean
     * @author wrongkey
     * @description check barcode exist in list
     * @date 2014/11/28
     */
    private boolean containBarcode(String barcode, List<Pair> list) {
        for (Pair pair : list) {
            if (pair.getKey().equals(barcode))
                return true;
        }
        return false;
    }


    /**
     * @param [barcode]
     * @return int
     * @author wrongkey
     * @description get price_info or discount_info by barcode from regularItemInfo
     * @date 2014/11/28
     */
    private int getInfoByBarcode(String barcode, List<Pair> list) {
        for (Pair pair : list) {
            if (pair.getKey().equals(barcode))
                return pair.getValue();
        }
        return -1;
    }
}

