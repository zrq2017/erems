package com.zrq.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zrq on 2018-4-21.
 */
@Controller
@RequestMapping("/admin")
public class AdminUrlController {
    @RequestMapping(value = {"","index"})
    public String index(){return "/admin/index";}

    @RequestMapping("panel-tabs")
    public String panelTabs(){return "/admin/panel-tabs";}

    @RequestMapping("notification")
    public String notification(){return "/admin/notification";}

    @RequestMapping("progress")
    public String progress(){return "/admin/progress";}

    @RequestMapping("buttons")
    public String buttons(){return "/admin/buttons";}

    @RequestMapping("icons")
    public String icons(){return "/admin/icons";}

    @RequestMapping("wizard")
    public String wizard(){return "/admin/wizard";}

    @RequestMapping("typography")
    public String typography(){return "/admin/typography";}

    @RequestMapping("grid")
    public String grid(){return "/admin/grid";}
}
