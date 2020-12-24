package com.count.lawer.service;
/*
 *@Author LinCount
 *@Data 2020/10/5 18:59
 *@Vesion 1.0
 */

import com.count.lawer.bean.Invitation;
import com.count.lawer.mapper.InvitationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitationService {
    @Autowired
    InvitationMapper invitationMapper;
    public Integer saveInvitation(Invitation invitation){
        return invitationMapper.saveInvitation(invitation);
    }
    public Integer delInvitationById(String invitationId) {
        return invitationMapper.delInvitationById(invitationId);
    }
    public Integer updateInvitation(Invitation invitation){
        return invitationMapper.updateInvitation(invitation);
    }
    public List<Invitation> selectInvitationByNum(Integer num){
        return invitationMapper.selectInvitationByNum(num);
    }

    public Invitation selectInvitationById(String invitationId){
        return invitationMapper.selectInvitationById(invitationId);
    }
}
