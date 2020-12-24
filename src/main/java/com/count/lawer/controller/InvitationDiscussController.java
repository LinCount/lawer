package com.count.lawer.controller;

import com.count.lawer.Api.Response;
import com.count.lawer.Api.ResponseResult;
import com.count.lawer.bean.InvitationDiscuss;
import com.count.lawer.service.InvitationDiscussService;
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
@RequestMapping("/discuss")
public class InvitationDiscussController {
    private final Logger logger= LoggerFactory.getLogger(InvitationDiscussController.class);
    @Autowired
    InvitationDiscussService discussService;
    @ApiOperation(value = "发表评论信息")
    @RequestMapping(value = "/saveDiscuss",method= RequestMethod.POST)
    public ResponseResult saveDiscuss(InvitationDiscuss discuss) {
        return Response.makeOKRsp(discussService.saveDiscuss(discuss));
    }
    @ApiOperation(value = "删除评论信息")
    @RequestMapping(value = "/delDiscuss/{discussId}",method= RequestMethod.GET)
    public ResponseResult delDiscussById(@RequestParam String discussId){
        return Response.makeOKRsp(discussService.delDiscussById(discussId));
    }

    @ApiOperation(value = "修改评论信息")
    @RequestMapping(value = "/updateDiscuss",method= RequestMethod.POST)
    public ResponseResult updateDiscuss(InvitationDiscuss discuss) {
        return Response.makeOKRsp(discussService.update(discuss));
    }

    @ApiOperation(value = "查询评论信息")
    @RequestMapping(value = "/getDiscuss/{num}",method= RequestMethod.GET)
    public ResponseResult<List<InvitationDiscuss>> selectDiscussByNum(@RequestParam Integer num){
        return Response.makeOKRsp(discussService.selectDiscussByNum(num));
    }

    @ApiOperation(value = "根据id查询评论信息")
    @RequestMapping(value = "/getDiscuss/{id}",method= RequestMethod.GET)
    public ResponseResult<InvitationDiscuss> selectDiscussById(@RequestParam String discussId){
        return Response.makeOKRsp(discussService.selectDiscussById(discussId));
    }
}
