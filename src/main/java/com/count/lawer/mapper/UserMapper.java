package com.count.lawer.mapper;

import com.count.lawer.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> findAllUser();
    //检查account是否存在
    @Select("select userId,account,password,token from user where account=#{account}")
    User findUserByAccount(@Param("account")String account);
    //插入一条数据
    @Insert("insert into user(userId,lawerId,account,password,email,sex,token,registerTime,online,headerUrl)" +
            "values(#{userId},#{lawerId},#{account},#{password},#{email},#{sex},#{token},#{registerTime,jdbcType=TIMESTAMP},#{online},#{headerUrl})")
    Integer saveUser(User user);
}
