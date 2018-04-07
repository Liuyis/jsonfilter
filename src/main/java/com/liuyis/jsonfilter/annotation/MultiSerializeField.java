package com.liuyis.jsonfilter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Liuyis on 2016/2/11.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MultiSerializeField{


    Class clazz() ;

    /**
     * The field will be returned
     * @return
     */
    String[] includes() default {};

    /**
     * The field will not be returned
     * @return
     */
    String[] excludes() default {};


}
