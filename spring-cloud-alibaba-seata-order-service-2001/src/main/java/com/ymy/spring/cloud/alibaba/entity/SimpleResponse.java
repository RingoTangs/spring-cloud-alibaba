package com.ymy.spring.cloud.alibaba.entity;

public class SimpleResponse {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息提示
     */
    private String message;

    /**
     * 具体数据
     */
    private Object data;

    public SimpleResponse() {

    }

    public SimpleResponse(Integer code, String message) {
        this(code, message, null);
    }

    public SimpleResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
