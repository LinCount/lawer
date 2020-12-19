package com.count.lawer.bean;

import lombok.Data;

import java.io.Serializable;
//新闻实体
@Data
public class News implements Serializable {
    private String newId;//新闻编号
    private String pupOrgan;//发布组织
    private String pupContent;//新闻内容
    private String pupTittle;//新闻题目
    private String newTime;//发布时间
}
