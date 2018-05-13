package com.zrq.dao.manager;

import com.zrq.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zrq on 2018-5-6.
 */
@Repository
public interface ManagerDao {
    /**
     * 插入一条考生信息，默认密码与用户名一致，返回插入记录主键
     * @param user
     * @return
     */
    @Insert("insert " +
            "user(name,username,password,sex,idnumber,eduback,address,email,phone,role) " +
            "values(#{name},#{username},#{username},#{sex},#{idnumber},#{eduback},#{address},#{email},#{phone},2)")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int insertExaminee(User user);

    /**
     * 根据用户姓名考试号查询
     * @param name
     * @param examId
     * @return
     */
    @Select("<script>"+
            "select * from user as u join myexam as me on u.id=me.user_id where 1=1" +
            "<if test='name!=null and name != \"\"'>" +
            "and u.name like CONCAT('%',#{name},'%')" +
            "</if>" +
            "<if test='examId!=null'>" +
            "and me.exam_id=#{examId}" +
            "</if>" +
            "</script>")
    public List<User> searchByNameAndExam(@Param("name") String name, @Param("examId") Integer examId);


    /**
     * 插入一条考生信息并设置为已支付
     * @param userId
     * @param examId
     * @return
     */
    @Insert("insert myexam(user_id,exam_id,pay) values(#{userId},#{examId},1)")
    public int insertExam(@Param("userId") Integer userId,@Param("examId") Integer examId);

    /**
     * 更新用户信息
     * @param user
     */
    @Update("update user set name=#{name},sex=#{sex},email=#{email},phone=#{phone},idnumber=#{idnumber}," +
            "eduback=#{eduback},address=#{address} where id=#{id}")
    public int updateUser(User user);
}
