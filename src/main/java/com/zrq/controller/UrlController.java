package com.zrq.controller;

import com.zrq.entity.User;
import com.zrq.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by zrq on 2018-4-18.
 *
 * 用于页面路径跳转
 */
@SessionAttributes({"user"})
@Controller
@RequestMapping("/")
public class UrlController extends BaseController{
    @Autowired
    private LoginService loginService;
    /**
     * 默认进入系统返回页面
     * @return
     */
    @RequestMapping(value = {"/","index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/url")
    public String url(){return "url";}

    @RequestMapping("/login")
    public String login(){return "login";}

    @RequestMapping("/regist")
    public String regist(){return "regist";}

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:"+path+"/index";
    }

    @RequestMapping("/home")
    public String home(){return "home";}

    /**
     * 登录验证
     * @param user
     * @param role
     * @return
     */
    @RequestMapping("validate")
    public String validate(User user, @RequestParam(required = false) String role, Map<String,Object> map){
        User existUser=loginService.findUser(user);
        if(existUser!=null) {
            existUser.setPassword("");
            map.put("user",existUser);
            return "redirect:"+path+"/home";
        }
        map.put("msg","用户名或密码错误");
        return "login";
    }

    /**
     * 考生注册
     * @param user
     * @param map
     * @return
     */
    @RequestMapping("register")
    public String register(User user,Map<String,Object> map){
        Integer i=loginService.registUser(user);
        if(i==0){
            map.put("msg","用户名信息输入错误！");
        }
        return "login";
    }

    /**
     * 后台向前端传值方式一
     *
     * 前端HTML页面需添加xmlns:th命名空间来使用后台的传值
     * @param map
     * @return
     */
    @RequestMapping("/test")
    public String test(Map<String,Object> map){
        map.put("hello","嘻嘻嘻");
        return "test";
    }

    /**
     * 后台向前端传值方式二
     *
     * 前端HTML页面需添加xmlns:th使用后台的传值
     * @param model
     * @return
     */
    @RequestMapping("test2")
    public String test2(Model model){
        model.addAttribute("hello","hahahha");
        return "test";
    }
}
