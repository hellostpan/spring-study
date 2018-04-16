package com.stpan.springstudy.utils;

/**
 * author:  STPAN
 * time:    2018/4/14 19:48
 */
public enum ResultEnum {
    SUCCESS(1, "成功"),
    FAILED(0, "失败"),
    FAILED_REDIS(2, "redis出错"),
    FAILED_OTHER(3, "其他错误");

    private Integer code;
    private String msg;

    ResultEnum(Integer coed, String msg) {
        this.code = coed;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
