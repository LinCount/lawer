package com.count.lawer.mapper;/*
 *@Author LinCount
 *@Data 2020/10/5 18:32
 *@Vesion 1.0
 */

import com.count.lawer.bean.Law;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
@Mapper
public interface LawMapper {
    @Insert("insert into law(lawerId,name,idCard,phone,licenseNo,licenseUrl,brief)" +
            "values(#{lawerId},#{name},#{idCard},#{phone},#{licenseNo},#{licenseUrl},#{brief})")
    Integer saveLaw(Law law);
    @Delete("delete from law where lawerId=#{lawerId}")
    Integer delLawById(@Param("lawerId")String lawerId);
    @Update("update law set " +
            "name=#{name},idCard=#{idCard},phone=#{phone},licenseNo=#{licenseNo},licenseUrl=#{licenseUrl},brief=#{brief}" +
            "where lawerId=#{lawerId}")
    Integer updateLaw(Law law);
    @Select("select lawerId,name,idCard,phone,licenseNo,licenseUrl,brief from law where lawerId=#{lawerId}" +
            "limit 1")
    Law selectLawById(@Param("lawerId")String lawerId);
    @Select("select lawerId,name,idCard,phone,licenseNo,licenseUrl,brief from law " +
            " limit #{num}")
    List<Law> selectLawByNum(@Param("num")Integer num);
}
