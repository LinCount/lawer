package com.count.lawer.mapper;
/*
 *@Author LinCount
 *@Data 2020/10/5 18:37
 *@Vesion 1.0
 */

import com.count.lawer.bean.ChartMessage;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ChatMessageMapper {
    @Insert("insert into charMessage(messageId,senderId,receiverId,sendContent,sendTime)" +
            "values(#{messageId},#{senderId},#{receiverId},#{sendContent},#{sendTime})")
    Integer saveChatMessage(ChartMessage chartMessage);
    @Delete("delete from chatMessage where messageId=#{messageId}")
    Integer delChatMessageById(@Param("messageId") String messageId);
    @Update("update chatMessage " +
            "set senderId=#{senderId},receiverId=#{receiverId},sendContent=#{sendContent},sendTime=#{sendTime}" +
            "where messageId=#{messageId}")
    Integer updateChatMessage(ChartMessage chartMessage);
    @Select("select messageId,senderId,receiverId,sendContent,sendTime from charMessage limit 0,#{num}")
    List<ChartMessage> selectChatMessages(@Param("num") Integer num);
    @Select("select messageId,senderId,receiverId,sendContent,sendTime from charMessage " +
            "where messageId=#{messageId} limit 1")
    ChartMessage selectChatMessageById(@Param("messageId")String messageId);
    @Select("select messageId,senderId,receiverId,sendContent,sendTime from charMessage " +
            "where senderId=#{senderId} and receiverId=#{receiverId} " +
            "order by sendTime asc")
    List<ChartMessage> selectChatMessageBySendAndReceiverId(@Param("senderId")String senderId,@Param("receiverId")String receiverId);
}
