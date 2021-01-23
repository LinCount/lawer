package com.count.lawer.mapper;/*
 *@Author LinCount
 *@Data 2020/10/5 18:34
 *@Vesion 1.0
 */

import com.count.lawer.RequeestBean.SendInvite;
import com.count.lawer.bean.Invitation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
@Mapper
public interface InvitationMapper {
    @Insert("insert into invitation(invitationId,userId,type,content,pupTime,goodNo,badNo)" +
            "values(#{invitationId},#{userId},#{type},#{content},#{pupTime},#{goodNo},#{badNo})")
    Integer saveInvitation(Invitation invitation);
    @Delete("delete from invitation where invitationId=#{invitationId}")
    Integer delInvitationById(@Param("invitationId") String invitationId);
    @Update("update invitation set " +
            "userId=#{userId},type=#{type}content=#{content},pupTime=#{pupTime},goodNo=#{goodNo},badNo=#{badNo}" +
            "where invitationId=#{invitationId}")
    Integer updateInvitation(Invitation invitation);
    @Select("select invitationId,userId,type,content,pupTime,goodNo,badNo from invitation limit #{num}")
    List<Invitation> selectInvitationByNum(@Param("num")Integer num);
    @Select("select invitationId,userId,type,content,pupTime,goodNo,badNo from invitation " +
            "where invitationId=#{invitationId} limit 1")
    Invitation selectInvitationById(@Param("invitationId")String invitationId);
    @Select("select invitationId,userId,type,content,pupTime,goodNo,badNo from invitation " +
            " where content like '%#{content}%'")
    List<Invitation> selectInvitationLikeContent(@Param("content")String content);
    @Select("select invitationId,userId,type,content,pupTime,goodNo,badNo from invitation " +
            "where type=#{type} '")
    List<Invitation> selectInvitationAsType(@Param("type")String type);
    @Select("select invitationId,userId,type,content,pupTime,goodNo,badNo from invitation " +
            "where type=#{type} and content like '%#{content}%'")
    List<Invitation> selectInvitationByContentAndType(@Param("type")String type,@Param("content")String content);
    @Select("select type,content,pupTime from invitation where userId=#{userId} order by pupTime asc")
    List<SendInvite> selectInvitationByUserId(@Param("userId")String userId);
}
