package com.count.lawer.mapper;

import com.count.lawer.bean.News;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 *@Author LinCount
 *@Data 2020/10/5 14:23
 *@Vesion 1.0
 */
@Repository
@Mapper
public interface NewsMapper {
    @Select("select newId,pupOrgan,pupContent,pupTittle,newTime from news where newId=#{id}")
    News findNewsById(@Param("id") String id);
    @Select("select newId,pupOrgan,pupContent,pupTittle,newTime from news order by newTime desc limit 10")
    List<News> getListNewsByTime();
    @Insert("insert into news(newId,pupOrgan,pupContent,pupTittle,newTime)" +
            "values(#{newId},#{pupOrgan},#{pupContent},#{pupTittle},#{newTime})")
    Integer saveNews(News news);
    @Delete("delete from news where newId=#{newId}")
    Integer delNewsById(@Param("newId")String newId);
    @Update("update news set pupOrgan=#{pupOrgan},pupContent=,#{pupContent},pupTittle=#{pupTittle},newTime=#{newTime}" +
            "where newId=#{newId}")
    Integer updateNews(News news);
}
