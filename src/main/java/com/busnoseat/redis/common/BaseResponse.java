package com.busnoseat.redis.common;


/**
 * The type BaseResponse.
 *
 * @author xubo
 * @Description:
 * @Date 2017/4/25
 */
public class BaseResponse {
    private String respCode;
    private String respMessage;

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMessage() {
        return respMessage;
    }

    public void setRespMessage(String respMessage) {
        this.respMessage = respMessage;
    }
}
