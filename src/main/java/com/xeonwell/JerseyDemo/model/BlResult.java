package com.xeonwell.JerseyDemo.model;

import com.xeonwell.JerseyDemo.Enum.BlStatus;

import java.io.Serializable;

/**
 * Created by xeonwell on 2017-04-24.
 */
public class BlResult implements Serializable {
    public int status;
    public Object data;

    public BlResult(BlStatus status, Object data) {
        this.status = status.ordinal();
        this.data = data;
    }
}
