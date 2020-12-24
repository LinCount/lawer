package com.count.lawer.service;/*
 *@Author LinCount
 *@Data 2020/10/5 18:58
 *@Vesion 1.0
 */

import com.count.lawer.bean.InvitationDiscuss;
import com.count.lawer.mapper.InvitationDiscussMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitationDiscussService {
    @Autowired
    InvitationDiscussMapper discussMapper;
    public Integer saveDiscuss(InvitationDiscuss discuss) {
        return discussMapper.saveDiscuss(discuss);
    }
    public Integer delDiscussById(String discussId){
        return discussMapper.delDiscussById(discussId);
    }
    public Integer update(InvitationDiscuss discuss) {
        return discussMapper.update(discuss);
    }
    public List<InvitationDiscuss> selectDiscussByNum(Integer num){
        return discussMapper.selectDiscussByNum(num);
    }
    public InvitationDiscuss selectDiscussById(String discussId){
        return discussMapper.selectDiscussById(discussId);
    }

}
