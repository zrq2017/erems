package com.zrq.service;

import com.github.pagehelper.PageHelper;
import com.zrq.dao.ExamDao;
import com.zrq.entity.Exam;
import com.zrq.entity.Statistics;
import com.zrq.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zrq on 2018-4-25.
 */
@Service
public class ExamService {
    @Autowired
    private ExamDao examDao;

    /**
     * 分页查找考试信息
     * @return
     */
    public PageBean<Exam> findByPage(int currentPage, int pageSize){
//        PageHelper.startPage(currentPage,pageSize);
        List<Exam> list=examDao.findAll();
//        for (Exam e:list) {
//            System.out.println("exam"+e.getId()+e.getName());
//        }
        Integer totalNum=examDao.count();
        PageBean<Exam>  page=new PageBean<Exam>(currentPage,pageSize,totalNum);
        page.setItems(list);
        return page;
    }

    public List<Exam> findAll(){
        return examDao.findAll();
    }

    /**
     * 根据考试id查找考试信息
     * @param id
     * @return
     */
    public Exam findById(Integer id) {
        return examDao.findById(id);
    }

    /**
     * 根据id更新考试信息
     * @param exam
     * @return
     */
    public int updateExam(Exam exam) {
        return examDao.updateExam(exam);
    }

    /**
     * 新增考试信息
     * @param exam
     * @return
     */
    public int saveExam(Exam exam) {
        return examDao.saveExam(exam);
    }

    /**
     * 设置考试是否过期
     * @param id
     * @param outed
     * @return
     */
    public int updateExamOuted(Integer id,Integer outed) {
        return examDao.updateExamOuted(id,outed);
    }

    /**
     * 发现所有过期考试
     * @return
     */
    public List<Exam> findAllOuted() {
        return examDao.findAllOuted();
    }

    /**
     * 统计未过期的考试报名人数数据
     * @return
     */
    public List<Statistics> findRegisterInfo() {
        return examDao.findRegisterInfo();
    }
}
