package com.michael.util;

public enum ServerResponseCode {


    /**
     * 基础状态
     */
    BASE_SUCCESS(200,"成功"),
    BASE_FAIL(400,"失败"),
    BASE_ERROR(500,"错误"),


    /**
     * 登录相关 1000 开头
     */
    LOGIN_SUCCESS(1000,"登录成功"),
    LOGIN_FAIL(1001,"账号或密码不正确,登录失败"),


    /**
     * 用户相关 2000 开头
     */
    USER_LOCK(2001,"用户被锁定,登录失败"),
    USER_PHONE_EXIST(2002,"手机号已存在"),
    USER_EMAIL_EXIST(2003,"邮箱已存在");

    private Integer code;
    private String msg;

    ServerResponseCode(Integer code, String msg) {
        this.code = code;
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
