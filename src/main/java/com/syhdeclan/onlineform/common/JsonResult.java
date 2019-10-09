package com.syhdeclan.onlineform.common;


//@ApiModel(description = "全局统一返回对象")

public class JsonResult<T> {

//    @ApiModelProperty(value = "响应状态码",name = "code",required = true,example = "0")

    private int code;

//    @ApiModelProperty(value = "响应消息",name = "msg",required = true,example = "数据获取成功")

    private String msg;

//    @ApiModelProperty(value = "响应数据",name = "data")

    private T data;

    public JsonResult(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
