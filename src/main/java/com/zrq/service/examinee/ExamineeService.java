package com.zrq.service.examinee;

import com.zrq.dao.ExamDao;
import com.zrq.dao.examinee.ExamineeDao;
import com.zrq.entity.MyExam;
import com.zrq.entity.User;
import com.zrq.entity.examinee.Examinee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zrq on 2018-4-18.
 */
@Service
public class ExamineeService {
    @Autowired
    private ExamineeDao examineeDao;
    @Autowired
    private ExamDao examDao;

    public List<Examinee> findAll(){
        return examineeDao.findAll();
    }

    public User findUserById(Integer id) {
        return examineeDao.findById(id);
    }
    /**
     * 插入一条考生报名考试信息
     * @param userId
     * @param examId
     * @return
     */
    public int insertExam(Integer userId, Integer examId){
        return examDao.insertExam(userId,examId);
    };

    /**
     * 根据考生及考试更改支付信息
     * @param userId
     * @param examId
     * @return
     */
    public MyExam payByUserAndExam(Integer userId, Integer examId) {
        MyExam myExam=examineeDao.findByUserAndExam(userId, examId);
        examineeDao.updateMyExamPay(myExam);
        //由上一步更新代表已成功修改支付状态
        // 但是由于先查询了原先未修改状态时的数据，故自我更新
        myExam.setPay(1);
        return myExam;
    }

    /**
     * 根据用户查询已考试信息
     * @param userId
     * @return
     */
    public List<MyExam> findByUserAndExamed(Integer userId) {
        return examineeDao.findByUserAndExamed(userId);
    }

    /**
     *查询单项考试个人成绩
     * @param userId
     * @param examId
     * @return
     */
    public List<MyExam> findOneByUserAndExamed(Integer userId, Integer examId) {
        return examineeDao.findOneByUserAndExamed(userId,examId);
    }
    /**
     * 根据考生及支付状态查询
     * @param userId
     * @param pay
     * @return
     */
    public List<MyExam> findByUserAndPay(Integer userId, Integer pay) {
        return examineeDao.findByUserAndPay(userId,pay);
    }

    /**
     * 更新用户信息
     * @param user
     */
    public int updateUser(User user) {
       return examineeDao.updateUser(user);
    }

}
