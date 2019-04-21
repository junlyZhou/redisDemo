package com.redistest.result;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    //成功
    SUCCESS(1),
    //失败
    FAIL(-1),
    //未认证（签名错误）
    UNAUTHORIZED(-2),
    //接口不存在
    NOT_FOUND(-3),
    //服务器内部错误
    INTERNAL_SERVER_ERROR(-4);
    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
