package com.count.lawer.utils;

import java.util.List;

public class ListResultUtil<T>{
    private final int status;//数据获取状态码
    private final String message;//运行信息
    private final String token;//登录验证信息
    private List<T> data;//返回的数据

    public ListResultUtil(int status, String message,String token, List<T> data) {
        this.status = status;
        this.message = message;
        this.token=token;
        this.data = data;
    }
    public ListResultUtil(int state,String token, List<T> data) {
        if(state==1){
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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
