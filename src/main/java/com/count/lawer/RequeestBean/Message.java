package com.count.lawer.RequeestBean;

import lombok.Data;

@Data
public class Message {
    private String messageId;//信息id
    private String senderId;//发送者id
    private String receiverId;//接受者id
    private String message;//发送内容
}
