package com.xeonwell.JerseyDemo.Common.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import java.io.IOException;

/**
 * Created by xeonwell on 2017-04-26.
 */
public class LoggingResponseFilter implements ContainerResponseFilter {
    private final static Logger logger = Logger.getLogger(LoggingResponseFilter.class);
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        String method = requestContext.getMethod();

        logger.debug("Requesting " + method + " for path " + requestContext.getUriInfo().getPath());
        Object entity = responseContext.getEntity();
        if (entity != null) {
            logger.debug("Response " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(entity));
        }
    }
}
