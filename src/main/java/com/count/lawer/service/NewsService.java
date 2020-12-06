package com.count.lawer.service;

import com.count.lawer.bean.News;
import com.count.lawer.mapper.NewsMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *@Author LinCount
 *@Data 2020/10/5 14:30
 *@Vesion 1.0
 */
@Service
public class NewsService {
    @Autowired
    NewsMapper newsMapper;
    public News findNewsById(@Param("id") String id){
        return newsMapper.findNewsById(id);
    }
    public List<News> getListNewsByTime(){
        return newsMapper.getListNewsByTime();
    }
}
