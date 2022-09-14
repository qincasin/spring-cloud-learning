package com.yxt.cloud.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author yangyanju
 */
public class SpringContextHolder implements ApplicationContextAware {

    private static final Logger LOG = LoggerFactory.getLogger(SpringContextHolder.class);

    private static ApplicationContext applicationContext = null;

    @SuppressWarnings("NullableProblems")
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext; // NOSONAR
    }

    public static ApplicationContext getApplicationContext() {
        assertContextInjected();
        return applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        assertContextInjected();

        if (clazz == null) {
            return null;
        }

        return applicationContext.getBean(clazz);
    }

    public static <T> T getBean(String name) {
        assertContextInjected();

        if (StringUtils.isEmpty(name)) {
            return null;
        }

        // noinspection unchecked
        return (T) applicationContext.getBean(name); // NOSONAR
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        assertContextInjected();

        if (StringUtils.isEmpty(name)) {
            return null;
        }

        if (clazz == null) {
            return null;
        }

        return applicationContext.getBean(name, clazz);
    }


    public static <T> Map<String, T> getBeans(Class<T> clazz) {
        assertContextInjected();

        if (clazz == null) {
            return null;
        }

        return applicationContext.getBeansOfType(clazz);
    }

    public static void publishEvent(ApplicationEvent event) {
        assertContextInjected();

        try {
            applicationContext.publishEvent(event);
        } catch (Exception ex) {
            LOG.error("publishEvent failed", ex);
        }
    }

    public static void publishEvent(Object event) {
        assertContextInjected();

        try {
            applicationContext.publishEvent(event);
        } catch (Exception ex) {
            LOG.error("publishEvent failed", ex);
        }
    }

    private static void assertContextInjected() {
        Assert.notNull(applicationContext, "SpringContextHolder does not inject.");
    }
}
