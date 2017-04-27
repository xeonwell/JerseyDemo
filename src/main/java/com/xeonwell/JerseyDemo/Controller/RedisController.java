package com.xeonwell.JerseyDemo.Controller;

import com.xeonwell.JerseyDemo.Common.BaseApiController;
import com.xeonwell.JerseyDemo.Model.BlResult;
import com.xeonwell.JerseyDemo.Service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by xeonwell on 2017-04-26.
 */
@Path("/redistest")
public final class RedisController extends BaseApiController {

    @Autowired
    private RedisService redisService;

    @GET
    @Path("/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    public BlResult getKey(@PathParam("key") String key) {

        String result = redisService.get(key);
        return ok(result);
    }
}
