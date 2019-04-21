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
 * @Description:
 */
@Configuration
public class JsonWebAppConfigure implements WebMvcConfigurer {

    private static final Logger logger = LogManager.getLogger(JsonWebAppConfigure.class);

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
