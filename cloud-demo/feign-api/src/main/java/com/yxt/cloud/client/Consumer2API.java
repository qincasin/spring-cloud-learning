package com.yxt.cloud.client;

import org.apache.http.NoHttpResponseException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("consumer-2")
@RequestMapping("/test")
public interface Consumer2API {
    @GetMapping("/getConsumer")
    String getConsumer() throws NoHttpResponseException;
}
