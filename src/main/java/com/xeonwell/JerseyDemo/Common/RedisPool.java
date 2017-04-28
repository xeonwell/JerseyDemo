package com.xeonwell.JerseyDemo.Common;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisPool;

/**
 * Created by xeonwell on 2017-04-28.
 *
 * jedis在选择database时，必须要传入password
 */
public class RedisPool extends JedisPool {
    public RedisPool(final GenericObjectPoolConfig poolConfig, final String host, int port,
                     int timeout, final int database) {
        super(poolConfig, host, port, timeout, null, database, null);
    }
}
