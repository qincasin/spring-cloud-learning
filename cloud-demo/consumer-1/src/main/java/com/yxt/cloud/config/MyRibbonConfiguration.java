//package com.yxt.cloud.config;
//
//import com.netflix.client.config.CommonClientConfigKey;
//import com.netflix.client.config.DefaultClientConfigImpl;
//import com.netflix.client.config.IClientConfig;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.boot.autoconfigure.AutoConfigureBefore;
//import org.springframework.cloud.netflix.ribbon.RibbonClientSpecification;
//import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
////@Configuration
//public class MyRibbonConfiguration implements InitializingBean{
//    @Resource
//    private SpringClientFactory springClientFactory;
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        List<RibbonClientSpecification> cfgs = new ArrayList<>();
//        RibbonClientSpecification configuration = new RibbonClientSpecification();
//        // 针对哪个服务提供者配置---consumer-2
//        configuration.setName("consumer-2");
//        // 注册的配置类
//        configuration.setConfiguration(new Class[]{RibbonClientCfg.class});
//        cfgs.add(configuration);
//        springClientFactory.setConfigurations(cfgs);
//    }
//
//    /**
//     * 因为Ribbon是在第一次调用接口时才会创建ApplicationContext，
//     * 所以我们在应用程序的Spring容器初始化阶段获取SpringClientFactory并为其添加自定义配置类能够生效。
//     *
//     * RibbonClientCfg声明在RibbonClientConfiguration之前生效，
//     * 这样RibbonClientConfiguration就不会向容器中注册IClientConfig了。
//     */
////    @AutoConfigureBefore(MyRibbonConfiguration.class)
//    public static class RibbonClientCfg{
//        @Bean
//        public IClientConfig ribbonClientConfig() {
//            DefaultClientConfigImpl config = new DefaultClientConfigImpl();
//            config.setClientName("consumer-2");
//            config.set(CommonClientConfigKey.MaxAutoRetries, 5);
//            config.setProperty(CommonClientConfigKey.MaxAutoRetriesNextServer, 0);
//            config.set(CommonClientConfigKey.ConnectTimeout, 1000);
//            config.set(CommonClientConfigKey.ReadTimeout, 3500);
//            return config;
//        }
//    }
//}
