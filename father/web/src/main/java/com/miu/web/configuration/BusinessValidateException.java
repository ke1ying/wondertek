package com.miu.web.configuration;

/**
 * @date 2022-10-31 15:01
 */
public class BusinessValidateException extends BaseException {

    /**
     * 状态码
     */
    private ResponseStatus status = ResponseStatus.UNKNOWN_ERROR;

    /**
     * 附加信息
     */
    private String additionMsg = "";

    public BusinessValidateException(ResponseStatus status, String additionMsg) {
        super(String.format(status.getMessageFormat(), additionMsg));
        this.status = status;
        this.additionMsg = additionMsg;
    }

    public BusinessValidateException(ResponseStatus status) {
        super(String.format(status.getMessageFormat(), ""));
        this.status = status;
    }

    public BusinessValidateException(String additionMsg) {
        super(String.format(ResponseStatus.UNKNOWN_ERROR.getMessageFormat(), additionMsg));
        this.additionMsg = additionMsg;
    }

    public static void throwException(ResponseStatus status) {
        throw new BaseException(status);
    }

    public static void throwException(String additionMsg) {
        throw new BaseException(additionMsg);
    }

    public static void throwException(ResponseStatus status, String additionMsg) {
        throw new BaseException(status, additionMsg);
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
