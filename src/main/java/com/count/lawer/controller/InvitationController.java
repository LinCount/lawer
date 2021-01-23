package com.count.lawer.controller;

import com.count.lawer.Api.Response;
import com.count.lawer.Api.ResponseResult;
import com.count.lawer.RequeestBean.Discuss;
import com.count.lawer.bean.Invitation;
import com.count.lawer.service.InvitationDiscussService;
import com.count.lawer.service.InvitationService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/invitation")
public class InvitationController {
    private final Logger logger= LoggerFactory.getLogger(InvitationController.class);

    @Autowired
    InvitationService invitationService;
    @Autowired
    InvitationDiscussService discussService;
    @ApiOperation(value = "保存帖子信息")
    @RequestMapping(value = "/saveInvitation",method= RequestMethod.POST)
    public ResponseResult saveInvitation(
            @PathVariable(value = "userId") String userId,
            @PathVariable(value = "textarea") String text,
            @PathVariable(value = "withtype")String type){
        Invitation invitation = new Invitation();
        invitation.setInvitationId(UUID.randomUUID().toString());
        invitation.setUserId(userId);
        invitation.setType(type);
        invitation.setContent(text);
        invitation.setBadNo(0);
        invitation.setGoodNo(0);
        invitation.setPupTime(new Date());
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
    @RequestMapping(value = "/getInvitation/{invitationId}",method= RequestMethod.GET)
    public ResponseResult<Invitation> selectInvitationById(@RequestParam String invitationId){
        return Response.makeOKRsp(invitationService.selectInvitationById(invitationId));
    }
    @ApiOperation(value = "根据帖子类型获取帖子信息")
    @RequestMapping(value = "/getInvitations/{type}",method= RequestMethod.GET)
    public ResponseResult<List<Invitation>> selectInvitationByType(@RequestParam String type){
        return Response.makeOKRsp(invitationService.selectInvitationAsType(type));
    }
    @ApiOperation(value = "根据内容获取帖子信息")
    @RequestMapping(value = "/getInvitations/{content}",method= RequestMethod.GET)
    public ResponseResult<List<Invitation>> selectInvitationByContent(@RequestParam String content){
        return Response.makeOKRsp(invitationService.selectInvitationLikeContent(content));
    }
    @ApiOperation(value = "根据内容和类型获取帖子信息")
    @RequestMapping(value = "/getInvitations/{content}/{type}",method= RequestMethod.GET)
    public ResponseResult<List<Invitation>> selectInvitationByContentAndType(
            @RequestParam(required = false) String content,
            @RequestParam(required = false) String type){
        return Response.makeOKRsp(invitationService.selectInvitationByContentAndType(type,content));
    }
    @ApiOperation(value = "获取论坛信息数据")
    @RequestMapping(value = "/getDiscussMessage/{userId}",method = RequestMethod.GET)
    public ResponseResult getDiscussMessage(@RequestParam String userId){
        if(userId==""||userId.equals(null)){
            return Response.makeErrRsp("参数错误");
        }
        Discuss discuss = new Discuss();
        //已发帖数据
        discuss.sendInvites=invitationService.selectInvitationByUserId(userId);
        //用户评论内容

        //用户回复我的评论内容
        //律师的评论
        //
        return Response.makeOKRsp(discuss);
    }

}
