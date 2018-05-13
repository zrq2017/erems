package com.zrq.controller.manager;

import com.zrq.entity.User;
import com.zrq.service.manager.ManagerService;
import com.zrq.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by zrq on 2018-5-6.
 */
@Controller
@RequestMapping("manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    /**
     * 跳转到个人信息页面
     * myInfo:查看个人信息页面
     * confirmInfo:信息确认逻辑
     * cancelInfo：撤销信息修改逻辑
     * @return
     */
    @RequestMapping({"myInfo","confirmInfo","cancelInfo"})
    public  String info(){
        System.out.println("MyPagedefault-info");
        return "my-info";
    }


    /**
     * 保存个人信息，并跳转到相应页面
     * 当前考试存在继续确认页面即个人信息页
     * 不存在跳到个人信息页
     * @return
     */
    @RequestMapping("saveInfo")
    public  String saveInfo(HttpServletRequest request, Map<String,Object> map,User user){
        //此处书写保存个人信息代码，不需要判断当前考试是否存在
        if(managerService.updateUser(user)>0){
            String name=(String)request.getSession().getAttribute("name");
            Integer sexam=(Integer)request.getSession().getAttribute("name");
            List<User> examineeList=managerService.searchByNameAndExam(name,sexam);
            map.put("examineeList",examineeList);
        }
        return "my-info";
    }


    /**
     * 添加考生信息并插入对应考生的考试项
     * @return
     */
    @RequestMapping("saveExaminee")
    public  String saveExaminee(HttpServletRequest request, User user, Map<String,Object> map){
        Integer examId=Integer.parseInt(request.getParameter("examId"));
        System.out.println("saveExaminee1:"+examId);
        managerService.addExaminee(user);
        Integer userId=user.getId();//插入考生信息并返回主键
        System.out.println("saveExaminee2:"+userId);
        if(userId==null){
            map.put("msg","增加考生信息错误，请重新输入！");
        }//添加考生成功，加入考试信息
        Integer x=managerService.addExamineeExam(userId,examId);
        System.out.println("saveExaminee3:"+x);
        map.put("msgSuccess","添加考生信息成功");
        return "entry";
    }

    /**
     * 根据考生姓名及考试id查询考生
     * @param map
     * @param name
     * @param examId
     * @return
     */
    @RequestMapping("search")
    public String search(Map<String,Object> map,
                         @RequestParam("sname")String name,@RequestParam("sexam")Integer examId){
        List<User> examineeList=managerService.searchByNameAndExam(name,examId);
        map.put("examineeList",examineeList);
        return "manage";
    }

    /**
     * 返回任何路径对应页面
     * 如果未定义方法会默认使用该方法
     * 若是定义了跳转方法会优先使用已定义的
     * @param url
     * @return
     */
    @RequestMapping("{url}")
    public String viewDistribute(@PathVariable("url")String url){
        url=StringUtil.humpToLine(url);//驼峰法与横线转换
        System.out.println("MyPagedefault-all:"+url);
        return url;
    }
}
