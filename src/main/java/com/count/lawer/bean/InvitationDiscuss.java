package com.count.lawer.bean;

import java.io.Serializable;
import java.util.Date;
//帖子评论实体
public class InvitationDiscuss implements Serializable {
    private String discussId;//帖子评论id
    private String invitationId;//帖子id
    private String userId;//用户id
    private String discussContent;//评论内容
    private Date discussTime;//评论时间

    public String getDiscussId() {
        return discussId;
    }

    public void setDiscussId(String discussId) {
        this.discussId = discussId;
    }

    public String getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(String invitationId) {
        this.invitationId = invitationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDiscussContent() {
        return discussContent;
    }

    public void setDiscussContent(String discussContent) {
        this.discussContent = discussContent;
    }

    public Date getDiscussTime() {
        return discussTime;
    }

    public void setDiscussTime(Date discussTime) {
        this.discussTime = discussTime;
    }
}
