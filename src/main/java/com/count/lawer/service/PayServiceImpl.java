package com.count.lawer.service;

import com.alipay.api.AlipayApiException;
import com.count.lawer.Api.Alipay;
import com.count.lawer.bean.AlipayBean;
import com.count.lawer.service.inter.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private Alipay alipay;

    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return alipay.pay(alipayBean);
    }
}
