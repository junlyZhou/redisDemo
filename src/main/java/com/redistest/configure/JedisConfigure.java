package com.redistest.configure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author zhoujunli
 * @date 2019/4/19 0019
 * @desc jedis配置，可以实现使用jedis来操作redis数据库
 */
@Configuration
public class JedisConfigure {

    public static final Logger log = LogManager.getLogger(JedisConfigure.class);

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWaitMillis;

    @Value("${spring.redis.password}")
    private String password;

    @Bean(name="jedisPool")
    public JedisPool redisPoolFactory(){
        log.info("JedisPool注入成功！！");
        log.info("redis地址：" + host + ":" + port);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        //jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        // 是否启用pool的jmx管理功能, 默认true
        jedisPoolConfig.setJmxEnabled(true);
        //没有密码用这个构造方式生成jedisPool
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);

        //如果redis缓存设置了密码，使用下面的构造方式
        //JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout,password);
        return jedisPool;
    }

}
