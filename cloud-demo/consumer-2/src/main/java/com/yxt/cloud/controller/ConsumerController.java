package com.yxt.cloud.controller;

import com.yxt.cloud.client.Consumer2API;
import org.apache.http.NoHttpResponseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class ConsumerController implements Consumer2API{
    public String getConsumer() throws NoHttpResponseException{

        long start = System.currentTimeMillis();
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (Exception e) {

        }
//        throw new NoHttpResponseException("11111");
        System.out.println("cost: " + ((System.currentTimeMillis() - start) / 1000.0));
        return "123456";
    }

}
