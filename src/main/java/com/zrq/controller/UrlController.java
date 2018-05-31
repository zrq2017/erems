package com.zrq.controller;

import com.zrq.entity.User;
import com.zrq.service.LoginService;
import com.zrq.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    private final ResourceLoader resourceLoader;

    //初始化资源加载器
    @Autowired
    public UrlController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
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
//            if(existUser.getPerimage()!=null) {
//                String tempPath = filePath+existUser.getPerimage();
//                existUser.setPerimage(tempPath);
//            }
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
     * 上传图片
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("uploadUserPhoto")
    public String uploadUserPhoto(@RequestParam("file")MultipartFile file,HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);
//        String filePath = request.getSession().getServletContext().getRealPath("/");
        try {
            System.out.println("getRealPath-->" + filePath+fileName);
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            Integer id=((User)request.getSession().getAttribute("user")).getId();
            Integer x=loginService.saveUserImage(fileName,id);
            if(x>0){
                User newUser=loginService.findUserById(id);
                request.getSession().setAttribute("user",newUser);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        //返回json
        return "my-info";
    }
    @RequestMapping(method = RequestMethod.GET, value = "show-image/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename) {

        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + filePath+filename));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
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
