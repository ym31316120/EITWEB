package com.mageeyang.eit.controller;

import com.mageeyang.eit.core.util.BeanUtils;
import com.mageeyang.eit.service.InitService;
import com.mageeyang.eit.service.PriceRequestService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/1/6.
 */
@Service
public class TaskJob {

    public void InitPriceAndBluePrintPrice(){
        InitService.initPrice();
        InitService.initBluePrintPrice();
    }
}
