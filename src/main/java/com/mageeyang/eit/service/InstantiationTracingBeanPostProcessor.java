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
            //root application context û��parent���������ϴ�.
            //��ʼ����Ҫ��ȡ�ĸ���ԭ���ϼ۸��TYPEID���б�
            InitService.initEitConfig();

//            PriceRequestService priceRequestService = BeanUtils.getBean("priceRequestService");
//            priceRequestService.getPrice();
        }
    }
}
