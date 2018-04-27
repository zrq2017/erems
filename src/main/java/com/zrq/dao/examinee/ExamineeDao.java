package com.zrq.dao.examinee;

import com.zrq.entity.User;
import com.zrq.entity.examinee.Examinee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zrq on 2018-4-18.
 */
@Repository
public interface ExamineeDao{
    @Select("select * from user")
    public List<Examinee> findAll();

    @Select("select * from user where username=#{username} and password=#{password}")
    public User findByUser(@Param("username") String username,@Param("password") String password);
}
