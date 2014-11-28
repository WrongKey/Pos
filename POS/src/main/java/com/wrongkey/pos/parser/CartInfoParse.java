package com.wrongkey.pos.parser;

/**
 * @author wrongkey
 * @version v1.0
 * @description cart information parse
 * @date 2014/11/20
 */
public class CartInfoParse extends Parse {

    /**
     * @param line
     * @return Pair<String,Integer>
     * @author wrongkey
     * @description convert a line
     * @date 2014/11/27
     */
    @Override
    protected Pair convert(String line) {
        String[] tokens = line.split("-");
        if (tokens.length == 1)
            return new Pair(tokens[0]);
        return new Pair(tokens[0], Integer.valueOf(tokens[1]));
    }
}
