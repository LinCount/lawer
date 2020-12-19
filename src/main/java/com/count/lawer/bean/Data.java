package com.count.lawer.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
//资料实体
@lombok.Data
public class Data implements Serializable {
    private String dataId;//资料id
    private String lawerId;//接受律师id
    private String userId;//用户id
    private String type;//咨询类型
    private Long phone;//用户电话
    private String dataContent;//用户要求内容
    private Date dataTime;//用户发布资料时间
    private String dataUrl;//用户提交资料
    private Date lawerTime;//律师接单时间
    private String backDataUrl;//律师返回资料
    private String backSug;//律师返回建议
    private BigDecimal replay;//赏金
    private String appeal;//是否申诉
    private Integer finishTag;//订单完成状态（0 未接单  1 进行中 2 完成）
    private Date finishTime;//订单完成时间
}
