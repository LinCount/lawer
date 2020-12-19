package com.count.lawer.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
//帖子实体
@Data
public class Invitation implements Serializable {
    private String invitationId;//帖子Id
    private String userId;//用户id
    private String content;//帖子内容
    private Date pupTime;//评论时间
    private Integer goodNo;//点赞数
    private Integer badNo;//点踩数
}
