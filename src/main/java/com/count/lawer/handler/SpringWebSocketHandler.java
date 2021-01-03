package com.count.lawer.handler;

import com.alibaba.fastjson.JSONObject;
import com.count.lawer.RequeestBean.Message;
import com.count.lawer.bean.ChartMessage;
import com.count.lawer.service.ChartMessageService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class SpringWebSocketHandler extends TextWebSocketHandler {
    /**
     * 存储用户id和其对应的session
     */
    private static final Map<String, WebSocketSession> users = new HashMap<>();
    /**
     * 用户名key值
     */
    private static final String USER_ID = "WEBSOCKET_USERID";
    /**
     * 连接建立后触发
     */
    @Autowired
    ChartMessageService messageService;
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        System.out.println("成功建立websocket连接!");
        String userId = (String) session.getAttributes().get(USER_ID);//取出在拦截器中存储的user_id
        users.put(userId, session);
        System.out.println("当前线上用户数量:" + users.size());
    }
    /**
     * 关闭连接时触发
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
        String userId = (String) session.getAttributes().get(USER_ID);
        System.out.println("用户" + userId + "已退出！");
        users.remove(userId);
        System.out.println("剩余在线用户" + users.size());
    }
    /**
     * 接收消息
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        //解析message的Payload的json数据{sendId:'',receiver:'',message:''}
        Message message1=JSONObject.parseObject(message.getPayload(),Message.class);
        System.out.println(message1.toString());
        //判断信息的有效性，判断users是否存在receiverId,有则发送，无则保存数据库，连接成功后再查询数据库
        if (message1.getReceiverId().equals("")||message1.getReceiverId().equals("")) {
//        if(false){
            log.error("发送信息错误");
        }else {
            new ChartMessage();
            ChartMessage chartMessage=new ChartMessage();
            chartMessage.setMessageId(UUID.randomUUID().toString());
            chartMessage.setSenderId(message1.getSenderId());
            chartMessage.setReceiverId(message1.getReceiverId());
            chartMessage.setSendContent(message1.getMessage());
            chartMessage.setSendTime(new Date());
            System.out.println(new Date());
            if(users.get(message1.getReceiverId())==null){
                //数据保存到数据库
                messageService.saveChatMessage(chartMessage);
            }else {
                //发送并保存到数据库
                for (String id : users.keySet()) {
                    if (id.equals(message1.getReceiverId())) {
                        try {
                            if (users.get(id).isOpen()) {
                                users.get(id).sendMessage(message);
                                messageService.saveChatMessage(chartMessage);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            }
        }
    }

    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        System.out.println("传输出现异常，关闭websocket连接... ");
        String userId = (String) session.getAttributes().get(USER_ID);
        users.remove(userId);
    }

    public boolean supportsPartialMessages() {
        return false;
    }
    /**
     * 给某个用户发送消息
     */
    public void sendMessageToUser(String userId, TextMessage message) {
        for (String id : users.keySet()) {
            if (id.equals(userId)) {
                try {
                    if (users.get(id).isOpen()) {
                        users.get(id).sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
    /**
     * 给所有在线用户发送消息
     */
    public void sendMessageToUsers(TextMessage message) {
        for (String userId : users.keySet()) {
            try {
                if (users.get(userId).isOpen()) {
                    users.get(userId).sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
