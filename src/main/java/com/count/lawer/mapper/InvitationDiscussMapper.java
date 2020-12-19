package com.count.lawer.mapper;

import com.count.lawer.bean.InvitationDiscuss;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface InvitationDiscussMapper {
    @Insert("insert into invitationDiscuss(discussId,invitationId,userId,discussContent,discussTime)" +
            "values(#{discussId},#{invitationId},#{userId},#{discussContent},#{discussTime})")
    Integer saveDiscuss(InvitationDiscuss discuss);
    @Delete("delete from invitationDiscuss where discussId=#{discussId}")
    Integer delById(@Param("discussId") String discussId);
    @Update("update invitationDiscuss set" +
            "invitationId=#{invitationId},userId=#{userId},discussContent=#{discussContent},discussTime=#{discussTime}" +
            "where discussId=#{discussId}")
    Integer update(InvitationDiscuss discuss);
    @Select("select discussId,invitationId,userId,discussContent,discussTime from invitationDiscuss limit 0,#{num}")
    List<InvitationDiscuss> selectDiscussByNum(@Param("num")Integer num);
    @Select("select discussId,invitationId,userId,discussContent,discussTime from invitationDiscuss" +
            "where discussId=#{discussId} limit 1")
    InvitationDiscuss selectDiscussById(@Param("num")String discussId);
}
