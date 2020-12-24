package com.count.lawer.controller;

import com.count.lawer.Api.Response;
import com.count.lawer.Api.ResponseResult;
import com.count.lawer.bean.ChartMessage;
import com.count.lawer.service.ChartMessageService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chart")
public class ChartMessageController {
    private final Logger logger= LoggerFactory.getLogger(ChartMessageController.class);
    @Autowired
    private ChartMessageService messageService;
    @ApiOperation(value = "保存聊天信息")
    @RequestMapping(value = "/saveMessage",method = RequestMethod.POST)
    public ResponseResult saveMessage(ChartMessage chartMessage){
        messageService.saveChatMessage(chartMessage);
        return Response.makeOKRsp();
    }
    @ApiOperation(value = "保存聊天信息")
    @RequestMapping(value = "/delMessage/{messageId}",method = RequestMethod.GET)
    public ResponseResult delChatMessageById(
            @RequestParam(value = "messageId")String messageId){
        return Response.makeOKRsp(messageService.delChatMessageById(messageId));
    }
    @ApiOperation(value = "更新聊天信息")
    @RequestMapping(value = "/updateMessage",method = RequestMethod.POST)
    public ResponseResult updateChatMessage(ChartMessage message){
        return Response.makeOKRsp(messageService.updateChatMessage(message));
    }
    @ApiOperation(value = "查询聊天信息")
    @RequestMapping(value = "/getMessage/{num}",method = RequestMethod.GET)
    public ResponseResult selectChatMessages(@RequestParam Integer num){
        return Response.makeOKRsp(messageService.selectChatMessages(num));
    }
    @ApiOperation(value = "根据id查询信息")
    @RequestMapping(value = "/getMessage/{messageId}",method = RequestMethod.GET)
    public ResponseResult selectChatMessageById(@RequestParam String messageId){
        return Response.makeOKRsp(messageService.selectChatMessageById(messageId));
    }
    @ApiOperation(value = "根据id查询信息")
    @RequestMapping(value = "/getMessage/{messageId}/{receiverId}",method = RequestMethod.GET)
    public ResponseResult selectChatMessageBySendAndReceiverId(@RequestParam String messageId,@RequestParam String receiverId){
        return Response.makeOKRsp(messageService.selectChatMessageBySendAndReceiverId(messageId,receiverId));
    }
}
