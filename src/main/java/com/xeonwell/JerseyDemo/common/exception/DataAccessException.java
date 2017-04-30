package com.xeonwell.JerseyDemo.common.exception;

/**
 * Created by xeowell on 2017/4/29.
 *
 * data access exception
 */
public class DataAccessException extends BusinessException {
    public DataAccessException(String message) {
        super(message);
    }
}
