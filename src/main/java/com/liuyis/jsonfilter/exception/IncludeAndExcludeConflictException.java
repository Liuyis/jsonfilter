package com.liuyis.jsonfilter.exception;

/**
 * Created by Liuyis on 2016/2/11.
 */
public class IncludeAndExcludeConflictException extends RuntimeException{

    public IncludeAndExcludeConflictException() {
    }
    public IncludeAndExcludeConflictException(String message) {
        super(message);
    }
}
