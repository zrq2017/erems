package com.zrq.controller;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by zrq on 2018-5-2.
 */
public class BaseController {
    //默认路径
    @Value("${server.servlet.path}")
    protected String path;
    @Value("${image.path}")
    protected String filePath;

}
