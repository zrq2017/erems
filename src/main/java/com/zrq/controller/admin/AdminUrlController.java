package com.zrq.controller.admin;

import com.zrq.entity.Address;
import com.zrq.entity.Exam;
import com.zrq.entity.MyExam;
import com.zrq.entity.Room;
import com.zrq.service.ExamService;
import com.zrq.service.admin.AdminService;
import com.zrq.service.examinee.ExamineeService;
import com.zrq.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by zrq on 2018-4-21.
 */
@Controller
@RequestMapping("/admin")
public class AdminUrlController {
    @Autowired
    private ExamService examService;
    @Autowired
    private ExamineeService examineeService;
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = {"","index"})
    public String index(){return "home";}

    @RequestMapping("panel-tabs")
    public String panelTabs(){return "panel-tabs";}


    /**
     * 根据考点名及考点区域查询考生
     * @param map
     * @param name
     * @param area
     * @return
     */
    @RequestMapping("search")
    public String search(Map<String,Object> map,
                         @RequestParam(value = "sname",required = false)String name,@RequestParam(value ="sarea",required = false)Integer area){
        List<Room> roomList=adminService.searchByNameAndArea(name,area);
        map.put("roomList",roomList);
        return "admin/room-list";
    }
    /**
     * 查询所有考点区域
     * @return
     */
    @RequestMapping("areaList")
    @ResponseBody
    public List<Address> areaList(){
        List<Address> areaList=adminService.findArea();
        return areaList;
    }

    /**
     * 更新、新增考试
     * @param exam
     * @return
     */
    @RequestMapping("saveExam")
    public String saveExam(Exam exam){
        if(exam.getId()!=null){//id不空即为更新操作
            examService.updateExam(exam);
        }else {
            examService.saveExam(exam);
        }
        return "admin/list";
    }

    /**
     * 更新考试页面跳转
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("exam")
    public String exam(@RequestParam("id")Integer id, Map<String,Object> map){
        Exam exam=examService.findById(id);
        map.put("currentExam",exam);
        return "admin/update-exam";
    }

    @RequestMapping("examineeInfo")
    public String examineeInfo(@RequestParam(value = "examId",required = false)Integer id, Map<String,Object> map){
        List<MyExam> examineeList=null;
        Exam currentExam=examService.findById(id);
        if(id!=null&&!id.equals("")){
           examineeList=examineeService.findMyExamByExamId(id);
        }else {
            examineeList=examineeService.findMyExam();
        }
        map.put("currentExam",currentExam);
        map.put("examineeList",examineeList);
        return "admin/examinee-info";
    }

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
     * 返回任何路径对应页面
     * 如果未定义方法会默认使用该方法
     * 若是定义了跳转方法会优先使用已定义的
     * @param url
     * @return
     */
    @RequestMapping("{url}")
    public String viewDistribute(@PathVariable("url")String url){
        url= StringUtil.humpToLine(url);//驼峰法与横线转换
        System.out.println("MyPagedefault-all:"+url);
        return url;
    }

    /**
     * 返回任何路径对应页面，进入admin文件夹
     * 如果未定义方法会默认使用该方法
     * 若是定义了跳转方法会优先使用已定义的
     * @param url
     * @return
     */
    @RequestMapping("/a/{url}")
    public String list(@PathVariable("url")String url){
        url= StringUtil.humpToLine(url);//驼峰法与横线转换
        return "admin/"+url;
    }
}
