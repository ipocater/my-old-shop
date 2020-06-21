package com.ipoca.my.shop.commons.context;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public final class SpringContext implements ApplicationContextAware, DisposableBean {

    private static Logger logger = LoggerFactory.getLogger(SpringContext.class);

    private static ApplicationContext applicationContext;

    public static <T> T getBean(Class<T> clazz){
//        assertContextInjected();
        return applicationContext.getBean(clazz);
    }

    public static <T> T getBean(String beanId){
//        assertContextInjected();
        return (T) applicationContext.getBean(beanId);
    }

    public void destroy() throws Exception {
        logger.debug("清空applicationContext");
        applicationContext = null;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContext.applicationContext = applicationContext;
    }

    private static void assertContextInjected(){
        Validate.validState(applicationContext == null, "还没有在spring-contextx.xml中配置SpringContext对象！");
    }
}
