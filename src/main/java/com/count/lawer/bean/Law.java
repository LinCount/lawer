package com.count.lawer.bean;

import lombok.Data;

import java.io.Serializable;
//律师实体
@Data
public class Law implements Serializable {
    private String lawerId;//律师编号
    private String name;//姓名
    private String idCard;//身份证号
    private String phone;//联系电话
    private String licenseNo;//执业证号
    private String licenseUrl;//执业证图片
    private String brief;//律师简介
}
