package com.redistest.controller;

import com.alibaba.fastjson.JSON;
import com.redistest.model.User;
import com.redistest.utils.JedisUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Administrator
 * @Date: 2019/4/20 0020 16:18
 * @Description:
 */
@RestController
public class TestRedisController {
    private static final Logger logger = LogManager.getLogger(TestRedisController.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/redis")
    public Object testRedis(){
        logger.info("  test reids .... >>>>>");

        /*redisTemplate.opsForValue().set("kk1", "vv1");
        Object kk1 = redisTemplate.opsForValue().get("kk1");
        logger.info(" kk1 ===> "+ kk1);*/

        User user = new User();
        user.setUserName("张三");
        user.setAddr("武汉");
        user.setUserAge(19);

        redisTemplate.opsForValue().set("user", user);
        //User userRedis = redisTemplate.opsForValue().get("user");
        Object userRedis = redisTemplate.opsForValue().get("user");
        User userR = (User)userRedis;

        logger.info(" userRedis ===> "+ userR.getUserName());

        return userRedis;
    }

    @GetMapping("/redis2")
    public Object testRedis2(){
        User user = new User();
        user.setUserName("李四");
        user.setAddr("武汉");
        user.setUserAge(19);

        redisUtil.set("redistaa", user);

        User redist = redisUtil.get("redistaa", User.class);
        logger.info("user redisaa : " + redist);

        return redist;

    }

    @Autowired
    private JedisUtil jedisUtil;

    @GetMapping("/redis3")
    public Object testRedis3(){
        User user = new User();
        user.setUserName("王五");
        user.setAddr("武汉");
        user.setUserAge(19);

        jedisUtil.setex("jediskey", 60, JSON.toJSONString(user));

        String jediskey = jedisUtil.get("jediskey", 0);
        User user1 = JSON.parseObject(jediskey, User.class);
        logger.info("user jediskey : " + user1);

        return user1;

    }

    @PostMapping("/redis4")
    public Object testRedis3(@RequestBody User userparam){

        logger.info(" userparam : " + userparam);

        User user = new User();
        user.setUserName("王五");
        user.setAddr("武汉");
        user.setUserAge(19);

        jedisUtil.setex("jediskey", 60, JSON.toJSONString(user));

        String jediskey = jedisUtil.get("jediskey", 0);
        User user1 = JSON.parseObject(jediskey, User.class);
        logger.info("user jediskey : " + user1);

        return user1;

    }

}
