package com.count.lawer.RequeestBean;

import lombok.Data;

import java.util.Date;

@Data
public class UserDiscuss {
    private String name;
    private String content;
    private String contented;//回复评论特有
    private Date time;
}
