package com.count.lawer.utils;

//接口json数据拼接类
public class ResultUtil<T> {
    private final int status;//数据获取状态码
    private final String message;//运行信息
    private final String token;//登录验证信息
    private T data;//返回的数据
    public ResultUtil(int status, String message,String token, T data) {
        this.status = status;
        this.message = message;
        this.token=token;
        this.data = data;
    }
    public ResultUtil(int state,String token, T data) {
        if (state==1){
            this.status = 200;
            this.message = "success";
        }else {
            this.status = 201;
            this.message = "fail";
        }
        this.token=token;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
