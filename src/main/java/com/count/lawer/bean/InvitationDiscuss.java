package com.count.lawer.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
//帖子评论实体
@Data
public class InvitationDiscuss implements Serializable {
    private String discussId;//帖子评论id
    private String invitationId;//帖子id
    private String userId;//用户id
    private String discussContent;//评论内容
    private Date discussTime;//评论时间
}
