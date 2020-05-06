package com.syhdeclan.onlineform.common;

public enum Code {

    SUCCESS(0,"请求成功"),
    SERVER_ERROR(1,"服务端错误"),
    ENTITY_NOT_EXISTS(2,"请求实体不存在"),
    PARAMETER_ERROR(3,"参数错误"),
    UNAUTHORIZED(10,"未认证，请重新登陆")
    ;

    private int code;
    private String msg;

    private Code(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
