package com.count.lawer.controller;
/*
 *@Author LinCount
 *@Data 2020/10/12 22:12
 *@Vesion 1.0
 */

import com.count.lawer.Api.Response;
import com.count.lawer.Api.ResponseResult;
import com.count.lawer.RequeestBean.DataInfo;
import com.count.lawer.RequeestBean.OrderForm;
import com.count.lawer.bean.Data;
import com.count.lawer.service.DataSerice;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

@RestController
@RequestMapping(value = "/data")
public class DataController {
    private final Logger logger= LoggerFactory.getLogger(DataController.class);
    @Autowired
    DataSerice dataSerice;
    @ApiOperation(value="文件上传接口",notes = "返回文件名")
    @RequestMapping("/upload")
    public ResponseResult uploadToUser(@RequestParam("file") MultipartFile file) {
        logger.info("接收到的文件数据为：" + file);
        if (file.isEmpty()) {

            return Response.makeErrRsp("上传文件为空");
        }
        // 获取文件全名a.py
        String fileName = file.getOriginalFilename();
        logger.info("文件全名："+fileName);
        // 文件上传路径
        String templatePath = "/data/";
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //获取文件名
        String prefixName = fileName.substring(0, fileName.lastIndexOf("."));
        // 解决中文问题,liunx 下中文路径,图片显示问题
        fileName = UUID.randomUUID()+ suffixName;
        File dest0 = new File(templatePath);
        File dest = new File(dest0, prefixName + File.separator + fileName);
        logger.info("保存文件名："+dest.getName());
        //文件上传-覆盖
        try {
            // 检测是否存在目录
            if (!dest0.getParentFile().exists()) {
                dest0.getParentFile().mkdirs();
                //检测文件是否存在
            }
            if (!dest.exists()) {
                dest.mkdirs();
            }
            file.transferTo(dest);
            return Response.makeOKRsp(fileName);
        } catch (Exception e) {
            logger.error("文件上传错误");
            return Response.makeErrRsp("文件上传错误");
        }
    }
    @ApiOperation(value="订单生成接口",notes = "咨询订单")
    @RequestMapping(value = "/uploadInfo",method = RequestMethod.POST)
    public ResponseResult uploadDataInfo(@RequestBody OrderForm orderForm){
        System.out.println(orderForm.toString());
        String dataId=UUID.randomUUID().toString();
        Data data=new Data();
        data.setDataId(dataId);
        data.setUserId(orderForm.userId);
        data.setType(orderForm.type);
        data.setDataTime(new Date(System.currentTimeMillis()));
        data.setPhone(orderForm.phone);
        data.setDataUrl(orderForm.fileName);
        data.setDataContent(orderForm.content);
        data.setReplay(orderForm.money);
        //支付业务和保存订单,加事务，加锁
        dataSerice.saveDataInfo(data);
        logger.info(dataId+"  订单建立成功！！");

        return  Response.makeOKRsp("成功");
    }
    @ApiOperation(value = "订单消息接口",notes = "返回律师是否接单等信息")
    @RequestMapping(value = "/initNumber/{userId}",method= RequestMethod.GET)
    public ResponseResult<List<DataInfo>> getDataInfo(@RequestParam("userId") String userId){
        List dataList=new ArrayList<DataInfo>();
        //根据用户订单分别查询未完成订单，进行中订单，已完成订单
        dataList.add(dataSerice.getListDataAsUserId(userId,0));
        dataList.add(dataSerice.getListDataAsUserId(userId,1));
        dataList.add(dataSerice.getListDataAsUserId(userId,2));
        return Response.makeOKRsp(dataList);
    }
}
