package com.redistest.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.redistest.model.Captcha;
import com.redistest.result.Result;
import com.redistest.result.ResultGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: Administrator
 * @Date: 2019/4/21 0021 21:52
 * @Description:
 */
@RestController
public class CaptchaController {

    /*@Autowired
    private JedisUtil jedisUtil;*/

    /**
     * 初始化图形验证码 保存到redis缓存
     * @return
     */
    @RequestMapping(value = "/init",method = RequestMethod.GET)
    public Result initCaptcha() {
        Captcha captcha = new Captcha();
        String captchaId = UUID.randomUUID().toString().replace("-","");
        //生成图片验证码
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36, 4, 20);
        String image = "data:image/jpeg;base64," + lineCaptcha.getImageBase64();
        String code = lineCaptcha.getCode();
        captcha.setCaptchaId(captchaId).setCode(code).setCodeImage(image);
        //缓存验证码 3分钟失效
        //jedisUtil.setex(captchaId, 180, code);

        //redisTemplate.opsForValue().set(captchaId,code,3L, TimeUnit.MINUTES);

        return ResultGenerator.genSuccessResult(captcha);
    }



}
