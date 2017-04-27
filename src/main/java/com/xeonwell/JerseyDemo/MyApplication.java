package com.xeonwell.JerseyDemo;

import com.xeonwell.JerseyDemo.Common.filter.CORSResponseFilter;
import com.xeonwell.JerseyDemo.Common.filter.LoggingResponseFilter;
import com.xeonwell.JerseyDemo.Controller.HelloWorldController;
import com.xeonwell.JerseyDemo.Controller.RedisController;
import com.xeonwell.JerseyDemo.Controller.UserController;
import com.xeonwell.JerseyDemo.Service.PodcastRestService;
import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by xeonwell on 2017-04-26.
 */
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        Logger.getLogger(MyApplication.class).info("app init.");

        register(HelloWorldController.class);
        register(UserController.class);
        register(PodcastRestService.class);
        register(RedisController.class);

        register(CORSResponseFilter.class);
        register(LoggingResponseFilter.class);
    }
}
