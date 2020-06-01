package com.count.lawer.bean;

import java.io.Serializable;
import java.util.Date;
//帖子实体
public class Invitation implements Serializable {
    private String invitationId;//帖子Id
    private String userId;//用户id
    private String content;//帖子内容
    private Date pupTime;//评论时间
    private Integer goodNo;//点赞数
    private Integer badNo;//点踩数

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPupTime() {
        return pupTime;
    }

    public void setPupTime(Date pupTime) {
        this.pupTime = pupTime;
    }

    public Integer getGoodNo() {
        return goodNo;
    }

    public void setGoodNo(Integer goodNo) {
        this.goodNo = goodNo;
    }

    public Integer getBadNo() {
        return badNo;
    }

    public void setBadNo(Integer badNo) {
        this.badNo = badNo;
    }
}
