package com.count.lawer.service;
/*
 *@Author LinCount
 *@Data 2020/10/5 19:13
 *@Vesion 1.0
 */

import com.count.lawer.bean.ChartMessage;
import com.count.lawer.mapper.ChatMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChartMessageService {
    @Autowired
    ChatMessageMapper messageMapper;
    public Integer saveChatMessage(ChartMessage chartMessage){
        return messageMapper.saveChatMessage(chartMessage);
    }
    public Integer delChatMessageById(String messageId){
        return messageMapper.delChatMessageById(messageId);
    }
    public Integer updateChatMessage(ChartMessage chartMessage){
        return messageMapper.updateChatMessage(chartMessage);
    }
    public List<ChartMessage> selectChatMessages(Integer num){
        return messageMapper.selectChatMessages(num);
    }
    public ChartMessage selectChatMessageById(String messageId){
        return messageMapper.selectChatMessageById(messageId);
    }
    public List<ChartMessage> selectChatMessageBySendAndReceiverId(String senderId,String receiverId){
        return messageMapper.selectChatMessageBySendAndReceiverId(senderId,receiverId);
    }
}
