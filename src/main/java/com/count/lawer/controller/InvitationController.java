package com.count.lawer.controller;

import com.count.lawer.Api.Response;
import com.count.lawer.Api.ResponseResult;
import com.count.lawer.bean.Invitation;
import com.count.lawer.service.InvitationService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/invitation")
public class InvitationController {
    private final Logger logger= LoggerFactory.getLogger(InvitationController.class);

    @Autowired
    InvitationService invitationService;
    @ApiOperation(value = "保存帖子信息")
    @RequestMapping(value = "/saveInvitation",method= RequestMethod.POST)
    public ResponseResult saveInvitation(Invitation invitation){
        return Response.makeOKRsp(invitationService.saveInvitation(invitation));
    }
    @ApiOperation(value = "删除帖子信息")
    @RequestMapping(value = "/delInvitation/{invitationId}",method= RequestMethod.GET)
    public ResponseResult delInvitationById(@RequestParam String invitationId) {
        return Response.makeOKRsp(invitationService.delInvitationById(invitationId));
    }
    @ApiOperation(value = "更新帖子信息")
    @RequestMapping(value = "/updateInvitation",method= RequestMethod.POST)
    public ResponseResult updateInvitation(Invitation invitation){
        return Response.makeOKRsp(invitationService.updateInvitation(invitation));
    }
    @ApiOperation(value = "根据数量获取帖子信息")
    @RequestMapping(value = "/getInvitation/{num}",method= RequestMethod.GET)
    public ResponseResult<List<Invitation>> selectInvitationByNum(@RequestParam Integer num){
        return Response.makeOKRsp(invitationService.selectInvitationByNum(num));
    }
    @ApiOperation(value = "根据id获取帖子信息")
    @RequestMapping(value = "/saveInvitation/{invitationId}",method= RequestMethod.GET)
    public ResponseResult<Invitation> selectInvitationById(@RequestParam String invitationId){
        return Response.makeOKRsp(invitationService.selectInvitationById(invitationId));
    }
}
