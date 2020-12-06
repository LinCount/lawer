package com.count.lawer.RequeestBean;
/*
 *@Author LinCount
 *@Data 2020/10/19 0:53
 *@Vesion 1.0
 */

import java.util.Date;

public class DataInfo {
    public String dataId;//资料id
    public String type;//咨询类型
    public Date dataTime;//用户发布时间
    public String dataContent;//用户要求内容
    public Integer finishTag;//订单完成状态（0 未接单  1 进行中 2 完成）
}
