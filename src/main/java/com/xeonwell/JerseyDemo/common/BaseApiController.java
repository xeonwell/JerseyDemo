package com.xeonwell.JerseyDemo.common;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

/**
 * Created by xeonwell on 2017-04-24.
 */
public class BaseApiController implements IBaseApiController {
    @Context
    protected HttpServletRequest request;

    public static Logger logger = null;

    public BaseApiController()
    {
        logger = Logger.getLogger(BaseApiController.class);
    }
}
