package com.count.lawer.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
//聊天信息实体
@Data
public class ChartMessage implements Serializable {
    private String messageId;//信息id
    private String senderId;//发送者id
    private String receiverId;//接受者id
    private String sendContent;//发送内容
    private Date sendTime;//发送时间
}
