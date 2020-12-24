package com.count.lawer.controller;

import com.count.lawer.Api.Response;
import com.count.lawer.Api.ResponseResult;
import com.count.lawer.bean.Law;
import com.count.lawer.service.LawService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/law")
public class LawController {
    private final Logger logger= LoggerFactory.getLogger(LawController.class);
    @Autowired
    LawService lawService;
    @ApiOperation(value = "保存law信息")
    @RequestMapping(value = "/saveLaw",method= RequestMethod.POST)
    public ResponseResult saveLaw(Law law){
        return Response.makeOKRsp(lawService.saveLaw(law));
    }
    @ApiOperation(value = "删除law信息")
    @RequestMapping(value = "/delLaw/{lawId}",method= RequestMethod.GET)
    public ResponseResult delLawById(@RequestParam String lawerId){
        return Response.makeOKRsp(lawService.delLawById(lawerId));
    }
    @ApiOperation(value = "更新law信息")
    @RequestMapping(value = "/updateLaw",method= RequestMethod.POST)
    public ResponseResult updateLaw(Law law){
        return Response.makeOKRsp(lawService.updateLaw(law));
    }
    @ApiOperation(value = "根据id查询law信息")
    @RequestMapping(value = "/getLaw/{lawId}",method= RequestMethod.GET)
    public ResponseResult<Law> selectLawById(@RequestParam String lawerId){
        return Response.makeOKRsp(lawService.selectLawById(lawerId));
    }
    @ApiOperation(value = "查询law信息")
    @RequestMapping(value = "/getLaw/{num}",method= RequestMethod.GET)
    public ResponseResult<List<Law>> selectLawByNum(@RequestParam Integer num){
        return Response.makeOKRsp(lawService.selectLawByNum(num));
    }
}
