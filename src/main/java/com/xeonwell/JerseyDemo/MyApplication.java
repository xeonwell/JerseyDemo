package com.xeonwell.JerseyDemo;

import com.xeonwell.JerseyDemo.Controller.HelloWorldController;
import com.xeonwell.JerseyDemo.Controller.UserController;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by xeonwell on 2017-04-26.
 */
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        register(HelloWorldController.class);
        register(UserController.class);
    }
}
