package com.qjx.sample;

import com.qjx.sample.demo.Cat;
import com.qjx.sample.demo.Dog;
import com.qjx.sample.demo.Mouse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author qinjiaxing
 */
@SpringBootApplication
@Import({Dog.class, Cat.class})
public class ConfigSampleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(ConfigSampleApplication.class, args);
        System.out.println(application.getBean(Mouse.class));
        System.out.println(application.getBean(Cat.class));
        System.out.println(application.getBean(Dog.class));
        application.close();

    }
}
