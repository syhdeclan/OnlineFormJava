package com.syhdeclan.onlineform.common;


//@ApiModel(description = "全局统一返回对象")

public class JsonResult<T> {

//    @ApiModelProperty(value = "响应状态码",name = "code",required = true,example = "0")

    private int code;

//    @ApiModelProperty(value = "响应消息",name = "msg",required = true,example = "数据获取成功")

    private String msg;

//    @ApiModelProperty(value = "响应数据",name = "data")

    private T data;

    private JsonResult(Code code){
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    private JsonResult(Code code, T data){
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.data = data;
    }

    private JsonResult(T data){
        this.code = Code.SUCCESS.getCode();
        this.msg = Code.SUCCESS.getMsg();
        this.data = data;
    }

    private JsonResult(int code, String msg){
        this.code = code;
        this.msg = msg;
    }


    public static <T> JsonResult success(T data){
        return new JsonResult<>(data);
    }

    public static <T> JsonResult error(Code code){
        return new JsonResult<>(code);
    }

    public static <T> JsonResult error(int code, String msg){
        return new JsonResult<>(code,msg);
    }

    public static <T> JsonResult error(Code code, T data){
        return new JsonResult<>(code,data);
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
