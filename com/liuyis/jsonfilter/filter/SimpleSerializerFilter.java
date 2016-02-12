package com.liuyis.jsonfilter.filter;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import java.util.*;

/**
 * Created by Liuyis on 2016/2/12.
 */
public class SimpleSerializerFilter extends SimplePropertyPreFilter{
    private  Map<Class, HashSet<String>> includes;
    private  Map<Class, HashSet<String>> excludes;

    public SimpleSerializerFilter(Map<Class, HashSet<String>> includes, Map<Class, HashSet<String>> excludes) {
        this.includes = includes;
        this.excludes = excludes;
    }

    @Override
    public boolean apply(JSONSerializer serializer, Object source, String name) {
        if(!isEmpty(includes)){
            for (Map.Entry<Class, HashSet<String>> include :includes.entrySet()){
                Class objClass = include.getKey();
                Set<String> includeProp = include.getValue();
                if(objClass.isAssignableFrom(source.getClass())){
                    return includeProp.contains(name);
                }else {
                    continue;
                }
            }
        }
        else if(!isEmpty(excludes)){
            for (Map.Entry<Class, HashSet<String>> exclude :excludes.entrySet()){
                Class objClass = exclude.getKey();
                Set<String> includeProp = exclude.getValue();
                if(objClass.isAssignableFrom(source.getClass())){
                    return !includeProp.contains(name);
                }else {
                    continue;
                }
            }
        }else {
            return true;
        }
        return true;
    }

    public boolean isEmpty(Map map){
        return map == null || map.size() < 1;
    }
}
