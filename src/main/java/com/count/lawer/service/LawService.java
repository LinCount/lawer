package com.count.lawer.service;/*
 *@Author LinCount
 *@Data 2020/10/5 18:57
 *@Vesion 1.0
 */

import com.count.lawer.bean.Law;
import com.count.lawer.mapper.LawMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LawService {
    @Autowired
    LawMapper lawMapper;
    public Integer saveLaw(Law law){
        return lawMapper.saveLaw(law);
    }
    public Integer delLawById(String lawerId){
        return lawMapper.delLawById(lawerId);
    }
    public Integer updateLaw(Law law){
        return lawMapper.updateLaw(law);
    }
    public Law selectLawById(String lawerId){
        return lawMapper.selectLawById(lawerId);
    }
    public List<Law> selectLawByNum(Integer num){
        return lawMapper.selectLawByNum(num);
    }
}
