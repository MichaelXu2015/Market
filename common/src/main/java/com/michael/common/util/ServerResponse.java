package com.michael.common.util;

import java.io.Serializable;

/**
 * 服务器通用响应
 */
public class ServerResponse<T> implements Serializable {

    private Integer code;
    private T data;
    private String msg;

    public ServerResponse(Integer code){
        this.code = code;
    }

    public ServerResponse(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public ServerResponse(Integer code,T data){
        this.code = code;
        this.data = data;
    }

    public ServerResponse(Integer code,T data,String msg){
        this.code = code;
        this.data = data;
        this.msg = msg;
    }


    /* 创建成功消息 */
    public static <T> ServerResponse<T> createSuccessMsg(){
        return new ServerResponse<T>(ServerResponseCode.BASE_SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createSuccessMsg(T data){
        return new ServerResponse<T>(ServerResponseCode.BASE_SUCCESS.getCode(),data);
    }

    public static <T> ServerResponse<T> createSuccessMsg(Integer code,T data){
        return new ServerResponse<T>(code,data);
    }


    public static <T> ServerResponse<T> createSuccessMsg(Integer code,String msg){
        return new ServerResponse<T>(code,msg);
    }

    public static <T> ServerResponse<T> createSuccessMsg(Integer code,T data,String msg){
        return new ServerResponse<T>(code,data,msg);
    }



    /* 创建失败消息 */
    public static <T> ServerResponse<T> createFailMsg(Integer code,String msg){
        return new ServerResponse<T>(code,msg);
    }

    public static <T> ServerResponse<T> createFailMsg(String msg){
        return new ServerResponse<T>(ServerResponseCode.BASE_FAIL.getCode(),msg);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ServerResponse{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
