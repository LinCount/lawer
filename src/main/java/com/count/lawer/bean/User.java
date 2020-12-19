package com.count.lawer.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
//用户实体
@Data
public class User implements Serializable {
    private String userId;//用户编号
    private String lawerId;//律师编号
    private String account;//账户
    private String password;//密码
    private String email;//邮箱
    private String sex;//性别
    private String token;//登录标识
    private Date registerTime;//注册时间
    private Integer online;//身份在线 0或1
    private String headerUrl;//头像路径
}
