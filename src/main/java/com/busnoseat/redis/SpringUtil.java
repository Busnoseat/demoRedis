package com.busnoseat.redis;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * The type SpringUtil.
 *
 * @author xubo
 * @Description:
 * @Date 2017/4/24
 */

public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext context;

    public SpringUtil() {
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static <T> T getBean(String name) throws BeansException {
        return (T) context.getBean(name);
    }

    public static <T> T getBean(Class<T> clz) throws BeansException {
        Object result = context.getBean(clz);
        return (T) result;
    }

    public static boolean containsBean(String name) {
        return context.containsBean(name);
    }

    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return context.isSingleton(name);
    }

    public static Class<?> getType(String name) throws NoSuchBeanDefinitionException {
        return context.getType(name);
    }

    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
        return context.getAliases(name);
    }
}