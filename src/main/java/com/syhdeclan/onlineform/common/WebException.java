package com.syhdeclan.onlineform.common;

/**
 * 手动抛出错误时候的类，可用于事务回滚
 * @Author syh
 */
public class WebException extends RuntimeException{

    private int code;
    private String msg;

    public WebException(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
