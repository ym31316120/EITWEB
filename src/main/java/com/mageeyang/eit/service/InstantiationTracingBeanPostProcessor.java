package com.mageeyang.eit.service;

import com.mageeyang.eit.core.util.BeanUtils;
import com.mageeyang.eit.db.model.InvmarketgroupsEntity;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/4.
 */
public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() == null){
            //判断是否是root节点，如果是则执行初始化信息操作
            //下方是初始化需要获取的原材料价格的typeid的列表，方便定时获取价格任务的读取
            InitService.initEitConfig();

            //初始化蓝图信息
            InitService.initBluePrintInfo();


            //初始化价格数据
//            InitService.initPrice();

            //初始化蓝图价格数据
//            InitService.initBluePrintPrice();

//            PriceRequestService priceRequestService = BeanUtils.getBean("priceRequestService");
//            priceRequestService.getPrice();
        }
    }
}
