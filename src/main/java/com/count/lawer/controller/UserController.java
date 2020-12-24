package com.count.lawer.controller;

import com.count.lawer.Api.Response;
import com.count.lawer.Api.ResponseResult;
import com.count.lawer.Api.ResponseUser;
import com.count.lawer.bean.User;
import com.count.lawer.service.UserService;
import com.count.lawer.RequeestBean.UserBean;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;
    @ApiOperation(value="测试接口",notes = "测试程序是否成功运行")
    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public ResponseResult getAllUser(){
        System.out.println("用户测试！！！！！！！！！！！！！！！！！");
        return Response.makeOKRsp("测试成功");
    }
    @ApiOperation(value = "登录接口",notes = "用户登录提交数据，返回token")
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResponseResult<ResponseUser> login(@RequestBody UserBean userBean){
        User user=userService.findUserByAccount(userBean.account);
        System.out.println(user.getAccount()+"   "+user.getPassword()+"  "+user.getUserId()+"  "+user.getToken());
        if(user!=null){
            if(userBean.account.equals(user.getAccount())&&userBean.password.equals(user.getPassword())){
                ResponseUser ruser=new ResponseUser();
                ruser.userName=user.getAccount();
                ruser.userId=user.getUserId();
                ruser.token=user.getToken();
                return Response.makeOKRsp(ruser);
            }
            return Response.makeErrRsp("用户信息不正确");
        }else {
            return Response.makeErrRsp("用户信息不正确");
        }
    }
    @ApiOperation(value = "注册接口",notes = "用户注册提交数据，返回注册状态")
    @RequestMapping(value = "/register",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResponseResult saveUser(@RequestBody UserBean userBean){
        if(userService.findUserByAccount(userBean.account)!=null){
            return Response.makeErrRsp("用户已存在");
        }
        String token =UUID.randomUUID().toString();
        User user=new User();
        System.out.println(userBean.account + userBean.password);
        user.setAccount(userBean.account);
        user.setPassword(userBean.password);
        System.out.println(token);
        user.setUserId(UUID.randomUUID().toString());
        user.setToken(token);
        Integer flag=userService.saveUser(user);
        if (flag>=0){
            return Response.makeRsp(200,"注册成功");
        }else {
            return Response.makeErrRsp("注册失败");
        }

    }


}
