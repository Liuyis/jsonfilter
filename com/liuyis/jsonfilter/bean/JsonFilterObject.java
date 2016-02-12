package com.liuyis.jsonfilter.bean;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Liuyis on 2016/2/11.
 */
public class JsonFilterObject {

    private Object jsonObject;

    private Map<Class, HashSet<String>> includes = new HashMap<Class, HashSet<String>>();

    private Map<Class, HashSet<String>>  excludes = new HashMap<Class, HashSet<String>>();

    public JsonFilterObject() {
    }

    public JsonFilterObject(Object jsonObject, Map<Class, HashSet<String>> includes, Map<Class, HashSet<String>> excludes) {
        this.jsonObject = jsonObject;
        this.includes = includes;
        this.excludes = excludes;
    }

    public Object getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(Object jsonObject) {
        this.jsonObject = jsonObject;
    }

    public Map<Class, HashSet<String>> getIncludes() {
        return includes;
    }

    public void setIncludes(Map<Class, HashSet<String>> includes) {
        this.includes = includes;
    }

    public Map<Class, HashSet<String>> getExcludes() {
        return excludes;
    }

    public void setExcludes(Map<Class, HashSet<String>> excludes) {
        this.excludes = excludes;
    }
}
