package com.count.lawer.bean;

import java.io.Serializable;
import java.util.Date;
//聊天信息实体
public class ChartMessage implements Serializable {
    private String messageId;//信息id
    private String senderId;//发送者id
    private String receiverId;//接受者id
    private String sendContent;//发送内容
    private Date sendTime;//发送时间

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getSendContent() {
        return sendContent;
    }

    public void setSendContent(String sendContent) {
        this.sendContent = sendContent;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
