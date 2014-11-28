package com.wrongkey.pos.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *@author wrongkey
 *@description text parse
 *@date 2014/11/20
 *@version v1.0
 *
 */
public abstract class Parse<V>{
    /**
     *@author wrongkey
     *@description text parser
     *@param [path]
     *@return java.util.List<V>
     *@date 2014/11/27
     */
    public  List<V> parse(String path) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        List<V> valueList = new ArrayList<V>();
        String line = null;
        while ((line=reader.readLine())!=null){
            valueList.add(convert(line));
        }
        return valueList;
    }

    /**
     *@author wrongkey
     *@description convert a line
     *@param [line]
     *@return V
     *@date 2014/11/27
     */
    protected abstract V convert(String line);
}
