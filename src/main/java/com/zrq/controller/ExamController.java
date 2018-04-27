package com.zrq.controller;

import com.zrq.entity.Exam;
import com.zrq.service.ExamService;
import com.zrq.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by zrq on 2018-4-25.
 */
@Controller
@RequestMapping("exam")
public class ExamController {
    //获取配置文件属性
    @Value("${page.size}")
    private Integer pageSize;

    @Autowired
    private ExamService examService;

    @RequestMapping("list")
    public String list(@RequestParam(name="currentPage",defaultValue ="1")Integer currentPage,
                       Map<String,Object> map){
        PageBean<Exam> examPage=examService.findByPage(currentPage,pageSize);
//        System.out.println("pageSize:"+examPage.getTotalNum()+currentPage.toString()+pageSize);
//        System.out.println("pageSize:"+examPage.getItems().get(1).getName());
        map.put("examPage",examPage);
        return "exam-list";
    }
}
