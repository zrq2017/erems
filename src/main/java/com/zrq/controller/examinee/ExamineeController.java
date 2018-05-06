package com.zrq.controller.examinee;

import com.zrq.controller.BaseController;
import com.zrq.entity.Exam;
import com.zrq.entity.MyExam;
import com.zrq.entity.User;
import com.zrq.entity.examinee.Examinee;
import com.zrq.service.ExamService;
import com.zrq.service.examinee.ExamineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zrq on 2018-4-18.
 */
@Controller
@RequestMapping("/examinee")
public class ExamineeController extends BaseController{
    @Autowired
    private ExamineeService examineeService;
    @Autowired
    private ExamService examService;

    /**
     * 显示个人列表，无用
     * @param map
     * @return
     */
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

    /**
     * 跳转到个人信息页面
     * myInfo:查看个人信息页面
     * confirmInfo:信息确认逻辑
     * cancelInfo：撤销信息修改逻辑
     * @return
     */
    @RequestMapping({"myInfo","confirmInfo","cancelInfo"})
    public  String confirmInfo(){
        return "my-info";
    }

    /**
     * 参与考试
     * @param request
     * @return
     */
    @RequestMapping("joinExam")
    public  String joinExam(HttpServletRequest request){
        Integer id=((Exam)request.getSession().getAttribute("currentExam")).getId();
        Integer userId=((User)request.getSession().getAttribute("user")).getId();
        if(examineeService.insertExam(userId,id)>0)
            return "paypage";
        return "my-info";
    }

    /**
     * 跳转到更新个人信息页面
     * @return
     */
    @RequestMapping("updateInfo")
    public  String updateInfo(){return "update-info";}

    /**
     * 保存个人信息，并跳转到相应页面
     * 当前考试存在继续确认页面即个人信息页
     * 不存在跳到个人信息页
     * @return
     */
    @RequestMapping("saveInfo")
    public  String saveInfo(HttpServletRequest request,User user){
        //此处书写保存个人信息代码，不需要判断当前考试是否存在
        user.setId(((User)request.getSession().getAttribute("user")).getId());
        if(examineeService.updateUser(user)>0){
            User newUser=examineeService.findUserById(user.getId());
            request.getSession().setAttribute("user",newUser);
        }
        return "my-info";
    }

    /**
     * 支付考试
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("pay")
    public  String pay(HttpServletRequest request,Map<String,Object> map){
        Exam exam=(Exam)request.getSession().getAttribute("currentExam");
        Integer userId=((User)request.getSession().getAttribute("user")).getId();
        if(exam!=null) {//当前考试存在则跳转相关信息，不存在则返回考试列表页面
            MyExam myExam=examineeService.payByUserAndExam(userId,exam.getId());
            map.put("myExam",myExam);
            request.getSession().removeAttribute("currentExam");
            return "my-exam";
        }
        return "my-exam";
    }

    /**
     * 继续支付
     * 跳转到支付考试页面
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("continuePay")
    public  String pay(HttpServletRequest request,Map<String,Object> map,
                       @RequestParam(name = "id")Integer id){
        Exam exam=examService.findById(id);
        request.getSession().setAttribute("currentExam",exam);
        System.out.println("continuePayId:"+id);
        return "paypage";
    }

    /**
     *
     * @param request
     * @param map
     * @param pay 是否支付,0未支付，1支付
     * @param examed 是否考试，有参数即代表已考试
     * @return
     */
    @RequestMapping("examList")
    public  String examList(HttpServletRequest request,
                            Map<String,Object> map,
                            @RequestParam(name="pay",required = false) Integer pay,
                            @RequestParam(name = "examed",required = false) Integer examed){
        Integer userId=((User)request.getSession().getAttribute("user")).getId();
        if(pay==0||pay==1){
            List<MyExam> myExam=null;
            if(examed!=null){
                myExam=examineeService.findByUserAndExamed(userId);
            }else {
                myExam=examineeService.findByUserAndPay(userId,pay);
            }
            map.put("myExam",myExam);
        }
        return "my-exam";
    }

    /**
     * 跳转考试查询页面
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("score")
    public  String score(HttpServletRequest request,Map<String,Object> map,
                         @RequestParam(name = "id",required = false) Integer id){
        Integer userId=((User)request.getSession().getAttribute("user")).getId();
        List<MyExam> myExam=null;
        if(id!=null){
            //考试id存在查询单条考试所有记录
            if(id==0){//id=0查询所有
                myExam=examineeService.findByUserAndExamed(userId);
            }else {
                myExam = examineeService.findOneByUserAndExamed(userId, id);
            }
            map.put("myExam",myExam);//用传递的参数不同控制页面是否显示搜索框
        }else{
            //考试id存在查询所有考试记录
            myExam=examineeService.findByUserAndExamed(userId);
            Map<Integer,String> search=new TreeMap<Integer,String>();
            for (MyExam e:myExam){
                search.put(e.getExam().getId(),e.getExam().getName());
            }
            map.put("search",search);
        }
        return "score";
    }

}
