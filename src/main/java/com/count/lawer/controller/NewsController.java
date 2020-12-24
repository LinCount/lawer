package com.count.lawer.controller;

import com.count.lawer.Api.Response;
import com.count.lawer.Api.ResponseResult;
import com.count.lawer.bean.News;
import com.count.lawer.service.NewsService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 *@Author LinCount
 *@Data 2020/10/5 18:31
 *@Vesion 1.0
 */
@RestController
@RequestMapping(value = "/news")
public class NewsController {
    private final Logger logger= LoggerFactory.getLogger(NewsController.class);
    @Autowired
    NewsService newsService;
    @ApiOperation(value = "根据id查询news信息")
    @RequestMapping(value = "/getNews/{Id}",method= RequestMethod.GET)
    public ResponseResult<News> findNewsById(@RequestParam String id){
        return Response.makeOKRsp(newsService.findNewsById(id));
    }
    @ApiOperation(value = "查询多个news信息")
    @RequestMapping(value = "/getNews",method= RequestMethod.GET)
    public ResponseResult<List<News>> getListNewsByTime(){
        return Response.makeOKRsp(newsService.getListNewsByTime());
    }
    @ApiOperation(value = "保存news信息")
    @RequestMapping(value = "/saveNews",method= RequestMethod.POST)
    public ResponseResult saveNews(News news){
        return Response.makeOKRsp(newsService.saveNews(news));
    }
    @ApiOperation(value = "删除news信息")
    @RequestMapping(value = "/delNews/{newId}",method= RequestMethod.GET)
    public ResponseResult delNewsById(@RequestParam String newId){
        return Response.makeOKRsp(newsService.delNewsById(newId));
    }
    @ApiOperation(value = "更新news信息")
    @RequestMapping(value = "/updateNews",method= RequestMethod.POST)
    public ResponseResult updateNews(News news){
        return Response.makeOKRsp(newsService.updateNews(news));
    }
}
