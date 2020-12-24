package com.count.lawer.service;/*
 *@Author LinCount
 *@Data 2020/10/5 19:12
 *@Vesion 1.0
 */

import com.count.lawer.RequeestBean.DataInfo;
import com.count.lawer.bean.Data;
import com.count.lawer.mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DataSerice {
    @Autowired
    DataMapper dataMapper;
    @Transactional
    public int saveDataInfo(Data data){
        //调用支付订单
       return dataMapper.saveDataInfo(data);
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
