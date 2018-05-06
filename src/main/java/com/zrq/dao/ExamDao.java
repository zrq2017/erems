package com.zrq.dao;

import com.zrq.entity.Exam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zrq on 2018-4-25.
 */
@Repository
public interface ExamDao {
    /**
     * 查询所有社会考试信息
     * @return 社会考试列表
     */
    @Select("select * from exam")
    public List<Exam> findAll();

    /**
     * 查询考试列表条数
     * @return
     */
    @Select("select count(*) from exam")
    public Integer count();

    @Select("select * from exam where id=#{id}")
    public Exam findById(Integer id);

    @Insert("insert myexam(user_id,exam_id) values(#{userId},#{examId})")
    public int insertExam(@Param("userId") Integer userId,@Param("examId") Integer examId);
}
