package com.count.lawer.service;/*
 *@Author LinCount
 *@Data 2020/10/5 19:12
 *@Vesion 1.0
 */

import com.alipay.api.AlipayApiException;
import com.count.lawer.RequeestBean.DataInfo;
import com.count.lawer.bean.AlipayBean;
import com.count.lawer.bean.Data;
import com.count.lawer.mapper.DataMapper;
import com.count.lawer.service.inter.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DataSerice {
    @Autowired
    DataMapper dataMapper;
    @Autowired
    PayService payService;
    @Transactional
    public String saveDataInfo(Data data) throws AlipayApiException {
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(data.getDataId());
        alipayBean.setSubject(data.getUserId()+"用户下单");//订单名称
        alipayBean.setTotal_amount(data.getReplay().toString());
        alipayBean.setBody(data.getDataContent());
        //调用支付订单
        dataMapper.saveDataInfo(data);
        return payService.aliPay(alipayBean);
    }
    public List<DataInfo> getListDataAsUserId(String userId, Integer finishTag){
        return dataMapper.getListDataAsUserId(userId,finishTag);
    }
    public Integer updateData(Data data){
        return dataMapper.updateData(data);
    }
    public Integer delData(String dataId){
        return dataMapper.delData(dataId);
    }
}
