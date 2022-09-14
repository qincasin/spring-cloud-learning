/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yxt.cloud.nacosdiscovery;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@EnableDiscoveryClient
@Configuration
public class NacosDiscoveryConfiguration {
//    /**
//     * 注入WebMvcRegistrations
//     * <p>
//     * 防止对Feign声明接口作二次注册
//     *
//     * @return
//     */
//    @Bean
////    @ConditionalOnClass(value = {WebMvcRegistrations.class, EnableFeignClients.class})
//    @ConditionalOnClass(name = {"org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations", "org.springframework.cloud.openfeign.EnableFeignClients"})
//    public WebMvcRegistrations feignWebRegistrations() {
//        return new WebMvcRegistrations() {
//            @Override
//            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
//                return new RequestMappingHandlerMapping() {
//                    @Override
//                    protected boolean isHandler(Class<?> beanType) {
//                        System.out.println("111111111111111");
//                        // 当使用EnableFeignClients时，SpringMVC防止对RequestMapping接口二次处理
//                        return super.isHandler(beanType) && !beanType.isInterface();
//                    }
//                };
//            }
//        };
//    }
}
