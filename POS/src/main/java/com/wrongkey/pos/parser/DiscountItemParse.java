package com.wrongkey.pos.parser;

/**
 *@author wrongkey
 *@description discount item information parse
 *@date 2014/11/20
 *@version v1.0
 *
 */
public class DiscountItemParse extends Parse {
    /**
     * @param line
     * @return Pair
     * @author wrongkey
     * @description convert a line
     * @date 2014/11/27
     */
    @Override
    protected Pair convert(String line) {
        String[] tokens = line.split(":");
        return new Pair(tokens[0],Integer.valueOf(tokens[1]));
    }
}
