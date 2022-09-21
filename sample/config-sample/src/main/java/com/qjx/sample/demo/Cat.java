package com.qjx.sample.demo;

import com.qjx.sample.ConfigSampleApplication;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author: qinjiaxing
 * @Date: 2022/9/20 21:57
 * @Description:
 */

@Configuration
@AutoConfigureAfter(ConfigSampleApplication.class)
public class Cat implements ApplicationContextAware {
    private ConfigurableApplicationContext applicationContext;

    public Cat() {
        System.out.println("new Cat()");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext)applicationContext;
    }
}
