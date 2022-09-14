package com.yxt.cloud.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//@FeignClient("consumer-2")
public interface Consumer2Client {
    @GetMapping("/getConsumer")
    String getConsumer();
}
