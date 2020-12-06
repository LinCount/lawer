package com.count.lawer.mapper;

import com.count.lawer.bean.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

}
