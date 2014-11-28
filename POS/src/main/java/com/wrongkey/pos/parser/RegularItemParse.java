package com.wrongkey.pos.parser;

/**
 * @author wrongkey
 * @version v1.0
 * @description regular item information parse
 * @date 2014/11/20
 */
public class RegularItemParse extends Parse {
    /**
     * @param line
     * @return V
     * @author wrongkey
     * @description convert a line
     * @date 2014/11/27
     */
    @Override
    protected Pair convert(String line) {
        String[] tokens = line.split(":");
        return new Pair(tokens[0], Integer.valueOf(tokens[1]));
    }
}
