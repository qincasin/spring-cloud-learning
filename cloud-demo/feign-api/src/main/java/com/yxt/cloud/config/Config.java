package com.yxt.cloud.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @desc:
 * @author: xufen
 * @since: 2019/12/30-14:33
 * @version: v1.0
 */
@Configuration("Feign-APIConfig")
@EnableFeignClients("com.yxt")
public class Config {
//    /**
//     * 注入WebMvcRegistrations
//     * <p>
//     * 防止对Feign声明接口作二次注册
//     *
//     * @return
//     */
//    @Bean
//    @ConditionalOnClass(value = {WebMvcRegistrations.class, EnableFeignClients.class})
//    public WebMvcRegistrations feignWebRegistrations() {
//        return new WebMvcRegistrations() {
//            @Override
//            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
//                return new RequestMappingHandlerMapping() {
//                    @Override
//                    protected boolean isHandler(Class<?> beanType) {
//                        // 当使用EnableFeignClients时，SpringMVC防止对RequestMapping接口二次处理
//                        return super.isHandler(beanType) && !beanType.isInterface();
//                    }
//                };
//            }
//        };
//    }

}
