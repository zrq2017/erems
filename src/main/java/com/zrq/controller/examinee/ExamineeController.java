package com.zrq.controller.examinee;

import com.zrq.entity.examinee.Examinee;
import com.zrq.service.examinee.ExamineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by zrq on 2018-4-18.
 */
@Controller
@RequestMapping("/examinee")
public class ExamineeController {
    @Autowired
    private ExamineeService examineeService;

    @RequestMapping("/list")
    public String findAll(Map<String,Object> map){
        List<Examinee> list=examineeService.findAll();
        String examString="";
        for (Examinee e:list) {
            examString+=e.getId()+e.getUsername()+"\n";
        }
        map.put("hello",examString);
        return "admin/index";
    }
}
