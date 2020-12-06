package com.count.lawer.controller;

import com.count.lawer.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@Author LinCount
 *@Data 2020/10/5 18:31
 *@Vesion 1.0
 */
@RestController
@RequestMapping(value = "/news")
public class NewsController {
    @Autowired
    NewsService newsService;
}
