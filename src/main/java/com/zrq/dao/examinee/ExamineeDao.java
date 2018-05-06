package com.zrq.dao.examinee;

import com.zrq.entity.MyExam;
import com.zrq.entity.User;
import com.zrq.entity.examinee.Examinee;
import org.apache.ibatis.annotations.*;
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

    @Select("select * from user where id=#{id}")
    public User findById(Integer id);

    /**
     * 根据用户及考试id查询个人考试信息
     * 使用级联查询之一对一关联映射
     * @param userId
     * @param examId
     * @return
     */
    @Select("select * from myexam where user_id=#{userId} and exam_id=#{examId}")
    @Results({
         @Result(property="user",
                 column = "user_id",
                 one = @One(select = "com.zrq.dao.examinee.ExamineeDao.findById")
         ),
        @Result(property="exam",
                column = "exam_id",
                one = @One(select = "com.zrq.dao.ExamDao.findById")
        )
    })
    public MyExam findByUserAndExam(@Param("userId") Integer userId, @Param("examId") Integer examId);

    /**
     * 根据支付状态判断是否支付：0未支付，1支付
     * @param userId
     * @param pay
     * @return
     */
    @Select("select * from myexam where user_id=#{userId} and pay=#{pay} and score<0")
    @Results({
            @Result(property="exam",
                    column = "exam_id",
                    one = @One(select = "com.zrq.dao.ExamDao.findById")
            )
    })
    public List<MyExam> findByUserAndPay(@Param("userId") Integer userId,@Param("pay") Integer pay);

    /**
     * 根据分数状态判断是否考试：score为负代表未参加，大于等于0表示参加，
     * 另外由考试中心给分时
     * @param userId
     * @return
     */
    @Select("select * from myexam where user_id=#{userId} and score>=0")
    @Results({
            @Result(property="exam",
                    column = "exam_id",
                    one = @One(select = "com.zrq.dao.ExamDao.findById")
            )
    })
    public List<MyExam> findByUserAndExamed(@Param("userId") Integer userId);

    /**
     * 查询单项考试个人成绩
     * @param userId
     * @param examId
     * @return
     */
    @Select("select * from myexam where user_id=#{userId} and exam_id=#{examId} and score>=0")
    @Results({
            @Result(property="exam",
                    column = "exam_id",
                    one = @One(select = "com.zrq.dao.ExamDao.findById")
            )
    })
    public List<MyExam> findOneByUserAndExamed(@Param("userId") Integer userId,@Param("examId")  Integer examId);

    /**
     * 更新支付状态
     * @param myExam
     */
    @Update("update myexam set pay=1 where id=#{id}")
    public void updateMyExamPay(MyExam myExam);

    /**
     * 更新用户信息
     * @param user
     */
    @Update("update user set name=#{name},sex=#{sex},email=#{email},phone=#{phone},idnumber=#{idnumber}," +
            "eduback=#{eduback},address=#{address} where id=#{id}")
    public int updateUser(User user);

}
