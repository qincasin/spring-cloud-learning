package com.qjx.sample.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: qinjiaxing
 * @Date: 2022/9/20 21:57
 * @Description:
 */
@Configuration
public class Dog {
    public Dog() {
        System.out.println("new Dog()");
    }

    @Bean
    public Mouse mouse(){
        return new Mouse();
    }
}
