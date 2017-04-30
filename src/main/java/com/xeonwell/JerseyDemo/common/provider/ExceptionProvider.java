package com.xeonwell.JerseyDemo.common.provider;

import com.xeonwell.JerseyDemo.common.exception.BusinessException;
import com.xeonwell.JerseyDemo.enums.BlStatus;
import com.xeonwell.JerseyDemo.model.BlResult;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by xeowell on 2017/4/30.
 * <p>
 * exception provider
 * </p>
 */
@Provider
public class ExceptionProvider implements ExceptionMapper<Exception> {

    private static Logger logger = Logger.getRootLogger();
    @Context
    private HttpServletRequest request;

    @Override
    public Response toResponse(Exception exception) {
        logger.warn("Exception Api:" + request.getRequestURI());
        logger.warn(exception);
        if (exception instanceof BusinessException) {
            return Response.ok(new BlResult(BlStatus.Fail, exception.getMessage()), MediaType.APPLICATION_JSON).build();
        } else {
            return Response.ok(new BlResult(BlStatus.Fail, "系统错误，请联系管理员"), MediaType.APPLICATION_JSON).build();
        }
    }
}
