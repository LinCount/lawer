package com.count.lawer.mapper;

import com.count.lawer.RequeestBean.DataInfo;
import com.count.lawer.bean.Data;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 *@Author LinCount
 *@Data 2020/10/5 18:33
 *@Vesion 1.0
 */
@Repository
@Mapper
public interface DataMapper {
    @Insert("insert into data(dataId,userId,type,dataTime,phone,dataContent,dataUrl,replay)" +
            " values(#{dataId},#{userId},#{type},#{dataTime},#{phone},#{dataContent},#{dataUrl},#{replay})")
    int saveDataInfo(Data data);
    @Select("select dataId,type,dataContent,finishTag,dataTime from data where userId=#{userId} and finishTag=#{finishTag}")
    List<DataInfo>  getListDataAsUserId(@Param("userId") String userId, @Param("finishTag") Integer finishTag);
    @Update("update data set userId=#{userId},type=#{type},dataTime=#{dataTime}" +
            ",phone=#{phone},dataContent=#{dataContent},dataUrl=#{dataUrl},replay=#{replay}" +
            "where dataId=#{dataId}")
    Integer updateData(Data data);
    @Delete("delete from data where dataId=#{dataId}")
    Integer delData(@Param("dataId") String dataId);

}
