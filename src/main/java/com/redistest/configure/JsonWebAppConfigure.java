package com.redistest.configure;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @Author: Administrator
 * @Date: 2019/4/21 0021 10:48
 * @Description: WebMvcConfigurerAdapter 抽象类已经过时，直接实现接口的方式实现消息格式序列化。
 */
@Configuration
public class JsonWebAppConfigure implements WebMvcConfigurer {

    private static final Logger logger = LogManager.getLogger(JsonWebAppConfigure.class);

    /**
     * @Desc 消息转换器，以下是转换成fastjson格式。
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        logger.info("converters : " + converters);
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonHttpMessageConverter.setDefaultCharset(Charset.forName("UTF-8"));
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastJsonHttpMessageConverter);
        WebMvcConfigurer.super.configureMessageConverters(converters);
    }
}
