package com.count.lawer.bean;

import java.io.Serializable;
//新闻实体
public class News implements Serializable {
    private String newId;//新闻编号
    private String pupOrgan;//发布组织
    private String pupContent;//新闻内容
    private String pupTittle;//新闻题目
    private String newTime;//发布时间

    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId;
    }

    public String getPupOrgan() {
        return pupOrgan;
    }

    public void setPupOrgan(String pupOrgan) {
        this.pupOrgan = pupOrgan;
    }

    public String getPupContent() {
        return pupContent;
    }

    public void setPupContent(String pupContent) {
        this.pupContent = pupContent;
    }

    public String getPupTittle() {
        return pupTittle;
    }

    public void setPupTittle(String pupTittle) {
        this.pupTittle = pupTittle;
    }

    public String getNewTime() {
        return newTime;
    }

    public void setNewTime(String newTime) {
        this.newTime = newTime;
    }
}
