package com.zrq.dao;

import com.zrq.entity.Exam;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zrq on 2018-4-25.
 */
@Repository
public interface ExamDao {
    /**
     * 查询所有社会考试信息（未过期）
     * @return 社会考试列表
     */
    @Select("select * from exam where outed=0")
    public List<Exam> findAll();

    /**
     * 查询所有社会考试信息（过期）
     * @return 社会考试列表
     */
    @Select("select * from exam where outed=1")
    List<Exam> findAllOuted();

    /**
     * 查询考试列表条数
     * @return
     */
    @Select("select count(*) from exam")
    public Integer count();

    /**
     * 根据考试id查询单条考试信息
     * @param id
     * @return
     */
    @Select("select * from exam where id=#{id}")
    public Exam findById(Integer id);

    /**
     * 根据用户及考试插入某用户考试信息
     * @param userId
     * @param examId
     * @return
     */
    @Insert("insert myexam(user_id,exam_id) values(#{userId},#{examId})")
    public int insertExam(@Param("userId") Integer userId,@Param("examId") Integer examId);

    /**
     * 根据id更新考试信息
     * @param exam
     * @return
     */
    @Update("update exam set name=#{name},description=#{description},time=#{time} where id=#{id}")
    public int updateExam(Exam exam);

    /**
     * 新增考试信息
     * @param exam
     * @return
     */
    @Insert("insert exam(name,description,time) values(#{name},#{description},#{time})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int saveExam(Exam exam);

    /**
     * 设置考试是否过期
     * @param id
     * @param outed
     * @return
     */
    @Update("update exam set outed=#{outed} where id=#{id}")
    public int updateExamOuted(@Param("id")Integer id, @Param("outed")Integer outed);

}
