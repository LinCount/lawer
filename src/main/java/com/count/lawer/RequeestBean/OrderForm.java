package com.count.lawer.RequeestBean;
/*
 *@Author LinCount
 *@Data 2020/10/13 14:46
 *@Vesion 1.0
 */

import java.math.BigDecimal;

public class OrderForm {
    public String userId;//用户id
    public String type;//咨询类型
    public String content;//用户要求内容
    public Long phone;//电话号码
    public String fileName;//用户提交资料路径
    public BigDecimal money;//赏金

    @Override
    public String toString() {
        return "OrderForm{" +
                "userId='" + userId + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", phone=" + phone +
                ", fileName='" + fileName + '\'' +
                ", money=" + money +
                '}';
    }
}
