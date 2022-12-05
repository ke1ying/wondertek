package com.miu.web.configuration;

import lombok.Data;

import java.io.Serializable;

/**
 * @author keying
 * @date 2022-11-07 17:38:51
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String msg;
    private String code;
    private boolean success = false;
    private T result;

    public Result() {
    }

    public Result(String msg, String code, boolean success, T result) {
        this.success = success;
        this.msg = msg;
        this.result = result;
        this.code = code;
    }

    public Result(String msg, String code, T result) {
        this.msg = msg;
        this.code = code;
        this.result = result;
    }

    public static <T> Result<T> ok() {
        return new Result("请求成功", "200", true, (Object) null);
    }

    public static <T> Result<T> ok(T result) {
        return new Result("请求成功", "200", true, result);
    }

    public static <T> Result<T> error(String message, String statusCode) {
        return new Result(message, statusCode, (Object) null);
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }


}