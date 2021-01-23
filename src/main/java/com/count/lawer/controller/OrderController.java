package com.count.lawer.controller;

import com.alipay.api.AlipayApiException;
import com.count.lawer.bean.AlipayBean;
import com.count.lawer.service.inter.PayService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单接口
 *
 * @author Louis
 * @date Dec 12, 2018
 */
@RestController()
@RequestMapping("order")
public class OrderController {

    @Autowired
    private PayService payService;
    @ApiOperation(value = "支付宝支付")
    @RequestMapping(value = "alipay",method = RequestMethod.POST)
    public String alipay(
            @RequestParam String outTradeNo,
            @RequestParam String subject,
            @RequestParam String totalAmount,
            @RequestParam(required = false) String body) throws AlipayApiException {
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(outTradeNo);
        alipayBean.setSubject(subject);
        alipayBean.setTotal_amount(totalAmount);
        alipayBean.setBody(body);
        return payService.aliPay(alipayBean);
    }

    //支付成功支付宝调用方法：
    @RequestMapping(value = "ok",method = RequestMethod.GET)
    public void ok(){
        System.out.println("付款成功！");
    }
}
