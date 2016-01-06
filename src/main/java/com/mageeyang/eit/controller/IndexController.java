package com.mageeyang.eit.controller;

import com.mageeyang.eit.core.util.BeanUtils;
import com.mageeyang.eit.db.model.BlueprintpriceEntity;
import com.mageeyang.eit.db.model.InvmarketgroupsEntity;
import com.mageeyang.eit.db.model.InvtypesEntity;
import com.mageeyang.eit.db.model.PricehistoryEntity;
import com.mageeyang.eit.db.repository.BluePrintPriceRepository;
import com.mageeyang.eit.service.MarketGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/1/6.
 */
@Controller
public class IndexController {
    @Autowired
    private BluePrintPriceRepository bluePrintPriceRepository;

    @RequestMapping("/")
    public String index(ModelMap modelMap) {
        return "index";
    }

    @RequestMapping("bpMain")
    public String bpMain() {
        return "blueprintmain";
    }

    @RequestMapping("bpList")
    public String bpList(ModelMap modelMap) {
        MarketGroupService marketGroupService = BeanUtils.getBean("marketGroupService");
        ArrayList<InvmarketgroupsEntity> bluemarketgroups = new ArrayList<InvmarketgroupsEntity>();
        marketGroupService.getChildListListByParentId(bluemarketgroups, 205);
        ArrayList<Integer> marketgroupids = new ArrayList<Integer>();
        for (int i = 0; i < bluemarketgroups.size(); i++) {
            marketgroupids.add(bluemarketgroups.get(i).getMarketGroupId());
        }
        List<BlueprintpriceEntity> bluepricelist = findbydate("2016-01-06",1,marketgroupids);
        modelMap.addAttribute("bluepricelist", bluepricelist);
        return "blueprintlist";
    }

    @RequestMapping("bpdetailCart")
    public String bpdetailCart(ModelMap modelMap) {

        return "blueprintdetailcart";
    }

    public List<BlueprintpriceEntity> findbydate(String date,int type,ArrayList<Integer> marketgroupids) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = sdf.parse(date + " 00:00:00");
            endDate = sdf.parse(date + " 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return bluePrintPriceRepository.findByMarketgroupidIdAndPricedateBetween(type, marketgroupids,startDate, endDate);
    }
}
