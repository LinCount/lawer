package com.count.lawer.controller;

import com.count.lawer.bean.User;
import com.count.lawer.service.UserService;
import com.count.lawer.utils.ListResultUtil;
import com.count.lawer.utils.ResultUtil;
import com.count.lawer.webBean.RegisterUser;
import com.count.lawer.webBean.WebUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;


@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public ListResultUtil getAllUser(){
        System.out.println("用户测试！！！！！！！！！！！！！！！！！");
        return new ListResultUtil(200,"测试成功",null,userService.findAllUser());
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultUtil login(@RequestBody WebUser webUser){
        User user=userService.findUserByAccount(webUser.account);
        System.out.println(user.getAccount()+"   "+user.getPassword()+"  "+user.getUserId()+"  "+user.getToken());
        if(user!=null){
            if(webUser.account.equals(user.getAccount())&&webUser.password.equals(user.getPassword()))
            return new ResultUtil(200,"登录成功",user.getToken(),"success");
            return new ResultUtil(200,"信息错误","","failed");
        }else {
            return new ResultUtil(200,"信息错误","","failed");
        }
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultUtil saveUser(@RequestBody RegisterUser user){
        if(userService.findUserByAccount(user.account)!=null){
            return new ResultUtil(200,"账户已存在","","failed");
        }
        String token =UUID.randomUUID().toString();
        User beanUser=new User();
        System.out.println(user.account + user.password);
        beanUser.setAccount(user.account);
        beanUser.setPassword(user.password);
        System.out.println(token);
        beanUser.setUserId(UUID.randomUUID().toString());
        beanUser.setToken(token);
        Integer flag=userService.saveUser(beanUser);
        if (flag==1){
            return new ResultUtil(200,"注册成功",token,"success");
        }else {
            return new ResultUtil(201,"注册失败","","failed");
        }

    }


}
