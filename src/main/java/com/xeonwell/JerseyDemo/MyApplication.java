package com.xeonwell.JerseyDemo;

import com.xeonwell.JerseyDemo.common.filter.CORSResponseFilter;
import com.xeonwell.JerseyDemo.common.filter.LoggingResponseFilter;
import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by xeonwell on 2017-04-26.
 */
public class MyApplication extends ResourceConfig {
    public MyApplication() {

        Logger logger = Logger.getLogger(MyApplication.class);

        logger.info("app init. ");

        packages(this.getClass().getPackage().getName() + ".controller");
//        register(HelloWorldController.class);
//        register(UserController.class);
//        register(PodcastsController.class);
//        register(RedisController.class);

        register(CORSResponseFilter.class);
        register(LoggingResponseFilter.class);
    }
}
