package com.wrongkey.pos.parser;

/**
 * Created by Administrator on 2014/11/28.
 */
public class FullHundredMinusParse extends Parse {
    /**
     * @param line
     * @return V
     * @author wrongkey
     * @description convert a line
     * @date 2014/11/27
     */
    @Override
    protected Pair convert(String line) {
        String[] tokens = line.split("-");
        return new Pair(tokens[0], Integer.valueOf(tokens[1]));
    }
}
