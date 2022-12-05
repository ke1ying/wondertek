package com.miu.web.configuration;



/**
 * 自定义异常
 *
 */
public class BaseException extends RuntimeException {
    //状态码
    private ResponseStatus status = ResponseStatus.UNKNOWN_ERROR;
    //附加信息
    private String additionMsg = "";

    public BaseException(ResponseStatus status, String additionMsg){
        super(String.format(status.getMessageFormat(),additionMsg));
        this.status = status;
        this.additionMsg = additionMsg;
    }

    public BaseException(ResponseStatus status){
        super(String.format(status.getMessageFormat(),""));
        this.status = status;
    }

    public BaseException(String additionMsg){
        super(String.format(ResponseStatus.UNKNOWN_ERROR.getMessageFormat(),additionMsg));
        this.additionMsg = additionMsg;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getAdditionMsg() {
        return additionMsg;
    }

    public void setAdditionMsg(String additionMsg) {
        this.additionMsg = additionMsg;
    }
}
