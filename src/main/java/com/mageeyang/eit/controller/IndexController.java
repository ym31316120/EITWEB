package com.mageeyang.eit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/1/6.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(ModelMap modelMap){
        return "index";
    }
}
