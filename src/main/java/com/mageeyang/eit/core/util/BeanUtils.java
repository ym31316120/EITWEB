package com.mageeyang.eit.core.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * Created by Administrator on 2016/1/4.
 */
public class BeanUtils implements BeanFactoryAware {
    // SpringµÄbean¹¤³§
    private static BeanFactory beanFactory;
    @Override
    public void setBeanFactory(BeanFactory factory) throws BeansException {
        beanFactory=factory;
    }
    public static<T> T getBean(String beanName){
        return (T) beanFactory.getBean(beanName);
    }
}
