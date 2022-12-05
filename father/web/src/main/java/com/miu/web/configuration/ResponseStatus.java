package com.miu.web.configuration;

/**
 * @author
 */
public enum ResponseStatus {
    SUCCESS(200, "成功"),
    TOKEN_INVALID(10401, "令牌无效"),
    SIGN_INVALID(10402, "签名不匹配"),
    UNAUTHORIZED(20001, "资源未授权:请刷新页面后重试"),
    PARAMETER_ILLEGAL(30001, "参数不合法:%s"),
    REQUEST_ERROR(30002, "请求失败:%s"),
    BUSINESS_PARAM_ERROR(30003, "%s"),
    UNKNOWN_ERROR(40001, "%s"),

    RPC_ERROR(50001, "服务返回异常:%s"),
    BUSINESS_EXCEPTION(60001, "业务异常：%s"),

    STOCK_STATUS_SEND_ERROR(60002, "发件扫描库存状态异常"),
    STOCK_STATUS_ARRIVE_ERROR(60003, "到件扫描库存状态异常"),

    ;


    private int code;
    private String messageFormat;

    ResponseStatus(int code, String messageFormat) {
        this.code = code;
        this.messageFormat = messageFormat;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessageFormat() {
        return messageFormat;
    }

    public void setMessageFormat(String messageFormat) {
        this.messageFormat = messageFormat;
    }
}
