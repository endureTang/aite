/*
 * Copyright(c) 2015 cycon.com.cn All rights reserved.
 * distributed with this file and available online at
 * http://www.cycon.com.cn/
 */
package com.nj.core.base.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @author tangqian
 */
@Service
public class BeanFactoryUtils implements BeanFactoryAware {
    
    private static BeanFactory beanFactory;
    
    @SuppressWarnings("static-access")
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
    
    public static BeanFactory getFactory() {
        return beanFactory;
    }
}
