package com.miu.web.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 */
@ControllerAdvice
public class ExceptionConfig {

    private final Logger log = LoggerFactory.getLogger(ExceptionConfig.class);

    /**
     * 处理业务异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public Object handleMallException(BaseException ex) {
        log.error("统一处理系统异常-业务异常:", ex);
        return Result.error(ex.getMessage(), ex.getStatus().toString());
    }

    /**
     * 处理业务异常
     *
     * @param ex 异常
     * @return Object
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Object handleMallException(BindException ex) {
        log.error("统一处理系统异常-业务参数校验异常:", ex);
        return new Result<>(ex.getFieldError().getDefaultMessage(), String.valueOf(ResponseStatus.PARAMETER_ILLEGAL.getCode()), false, "");
    }

    /**
     * 处理业务异常
     *
     * @param ex 异常
     * @return Object
     */
    @ExceptionHandler(BusinessValidateException.class)
    @ResponseBody
    public Object handleMallException(BusinessValidateException ex) {
        log.error("统一处理系统异常-业务校验异常:", ex);
        return new Result<>(ex.getMessage(), String.valueOf(ex.getStatus().getCode()), false, "");
    }

    /**
     * 处理系统异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleException(Exception ex) {
        log.error("统一处理系统异常-报错信息为:", ex);
        return Result.error("system","system");
    }
}