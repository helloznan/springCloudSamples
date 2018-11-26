package com.zn.micro.demo.weathercollectionserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {
    /**
     * Database index used by the connection factory.
     */
    private int database = 0;

    /**
     * Redis url, which will overrule host, port and password if set.
     */
    private String url;

    /**
     * Redis server host.
     */
    private String host = "localhost";

    /**
     * Login password of the redis server.
     */
    private String password;

    /**
     * Redis server port.
     */
    private int port = 6379;
    // 其它参数略
}
