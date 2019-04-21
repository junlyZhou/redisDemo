package com.redistest.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: FengJie
 * @Date: 2018/12/21 19:15
 * @Description:
 */
@Data
@Accessors(chain = true)
public class Captcha {

    private String captchaId;

    private String code;

    private String codeImage;
}
