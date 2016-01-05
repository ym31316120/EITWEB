package com.mageeyang.eit.controller;

import com.mageeyang.eit.core.cache.EitConfigInfo;
import com.mageeyang.eit.db.model.InvmarketgroupsEntity;
import com.mageeyang.eit.db.model.InvtypesEntity;
import com.mageeyang.eit.db.model.PricehistoryEntity;
import com.mageeyang.eit.db.repository.InvTypesRepository;
import com.mageeyang.eit.db.repository.MarketGroupRepository;
import com.mageeyang.eit.core.util.BeanUtils;
import com.mageeyang.eit.db.repository.PricehistoryRepository;
import com.mageeyang.eit.service.BluePrintService;
import com.mageeyang.eit.service.InitService;
import com.mageeyang.eit.service.MarketGroupService;
import com.mageeyang.eit.service.PriceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/1/2.
 */
@Controller
public class TestController {

    public static final String ACTIONPATH = "WEB-INF/classes/config/priceGroupId.json";
    @Autowired
    private MarketGroupRepository marketGroupRepository;

    @Autowired
    private InvTypesRepository invTypesRepository;

    @Autowired
    private PricehistoryRepository pricehistoryRepository;

    @RequestMapping("test")
    public String test(ModelMap modelMap){
        // 找到user表里的所有记录
        List<InvtypesEntity> userList = new ArrayList<InvtypesEntity>();
        userList = invTypesRepository.findBymarketGroupId(1857);

        BluePrintService bluePrintService = BeanUtils.getBean("bluePrintService");

        System.out.println(bluePrintService.findByTypeIdAndActivityId(683,1).toString());



//        MarketGroupService t = BeanUtils.getBean("marketGroupService");
//        t.getChildListListByParentId(userList,1861);
       // System.out.println(EitConfigInfo.getPrimitiveList().toString());
        // 将所有记录传递给返回的jsp页面
        modelMap.addAttribute("userList", userList);



//


        //测试HttpUtil服务
//        HttpUtil httpUtil = new HttpUtil(10000,"172.20.182.207",808);
//        String url = "http://api.eve-central.com/api/marketstat/json?typeid=34,35&usesystem=30000142";
//        String url1 = "http://api.eve-central.com/api/marketstat/json?typeid=36,37&usesystem=30000142";
//        System.out.println(httpUtil.getJsonArray(url).toString());
//        System.out.println("-----------------------------");
//        System.out.println(httpUtil.getJsonArray(url1).toString());
//        httpUtil.close();

        // 返回 pages 目录下的 userManage.jsp 页面
        return "test";
    }

    private void getMarketGroupList(List<InvmarketgroupsEntity> marketGroupList,int parentGroupID){
        List<InvmarketgroupsEntity> marketList = marketGroupRepository.findByparentGroupId(parentGroupID);
        if(marketList!=null&&marketList.size()>0){
            for(int i=0;i<marketList.size();i++){
                InvmarketgroupsEntity invmarketgroupsEntity = marketList.get(i);
                marketGroupList.add(invmarketgroupsEntity);
                this.getMarketGroupList(marketGroupList, invmarketgroupsEntity.getMarketGroupId());
            }
        }
    }


}
