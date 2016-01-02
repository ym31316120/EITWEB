package com.mageeyang.eit.controller;

import com.mageeyang.eit.db.model.InvmarketgroupsEntity;
import com.mageeyang.eit.db.repository.MarketGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2016/1/2.
 */
@Controller
public class TestController {
    @Autowired
    private MarketGroupRepository marketGroupRepository;

    @RequestMapping("/test")
    public String test(ModelMap modelMap){
        // 找到user表里的所有记录
        List<InvmarketgroupsEntity> userList = marketGroupRepository.findAll();

        // 将所有记录传递给返回的jsp页面
        modelMap.addAttribute("userList", userList);

        // 返回 pages 目录下的 userManage.jsp 页面
        return "test";
    }
}
