package com.xeonwell.JerseyDemo.controller;

import com.xeonwell.JerseyDemo.common.BaseApiController;
import com.xeonwell.JerseyDemo.model.BlResult;
import com.xeonwell.JerseyDemo.model.User;
import com.xeonwell.JerseyDemo.service.RedisService;
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
    @Path("/get/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    public BlResult getKey(@PathParam("key") String key) {

        String result = redisService.get(key);
        return ok(result);
    }

    @GET
    @Path("/set/{key}/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public BlResult setKey(@PathParam("key") String key, @PathParam("value") String value) {
        redisService.set(key, value);
        return ok();
    }

    @GET
    @Path("/login/{user}/{pass}")
    @Produces(MediaType.APPLICATION_JSON)
    public BlResult login(@PathParam("user") String user, @PathParam("pass") String pass) {
        User u = new User();
        u.firstName = user;
        u.password = pass;
        request.getSession().setAttribute(user, u);
        return ok();
    }

    @GET
    @Path("/islogin/{user}")
    @Produces(MediaType.APPLICATION_JSON)
    public BlResult isLogin(@PathParam("user") String user) {
        Object u = request.getSession().getAttribute(user);
        if (u == null) return needLogin();
        return ok(u);
    }
}
