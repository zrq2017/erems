package com.zrq.service.manager;

import com.zrq.dao.ExamDao;
import com.zrq.dao.manager.ManagerDao;
import com.zrq.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zrq on 2018-5-6.
 */
@Service
public class ManagerService {
    @Autowired
    private ManagerDao managerDao;

    public int addExaminee(User user) {
        return managerDao.insertExaminee(user);
    }

    /**
     * 根据用户姓名考试号查询
     * @param name
     * @param examId
     * @return
     */
    public List<User> searchByNameAndExam(String name, Integer examId) {
        List<User> l=null;
        l=managerDao.searchByNameAndExam(name,examId);
        if(l!=null){//设置用户密码为空
            for (User u:l){
                u.setPassword("");
            }
        }
        return l;
    }
    /**
     * 插入一条考生报名考试信息
     * 返回插入记录主键，需再使用对象的getter方法才可真正得到记录id，否则为记录数，如下：
     * userId=user.getId();
     * @param userId
     * @param examId
     * @return
     */
    public int addExamineeExam(Integer userId, Integer examId) {
        return managerDao.insertExam(userId,examId);
    }

    /**
     * 更新考生信息
     * @param user
     */
    public int updateUser(User user) {
        return managerDao.updateUser(user);
    }
}
