package com.zrq.service;

import com.github.pagehelper.PageHelper;
import com.zrq.dao.ExamDao;
import com.zrq.entity.Exam;
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
        PageHelper.startPage(currentPage,pageSize);
        List<Exam> list=examDao.findAll();
//        for (Exam e:list) {
//            System.out.println("exam"+e.getId()+e.getName());
//        }
        Integer totalNum=examDao.count();
        PageBean<Exam>  page=new PageBean<Exam>(currentPage,pageSize,totalNum);
        page.setItems(list);
        return page;
    }
}
