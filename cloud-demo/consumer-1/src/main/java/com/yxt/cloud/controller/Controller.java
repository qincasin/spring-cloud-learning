package com.yxt.cloud.controller;

import com.yxt.cloud.client.Consumer2API;
import com.yxt.cloud.util.HttpUtils;
import org.apache.http.NoHttpResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
//    @Autowired
//    private Consumer2Client consumer2Client;
    @Autowired
    private Consumer2API consumer2API;

    @Autowired
    private HttpUtils httpUtils;
    @GetMapping("/test")
    public String test() throws NoHttpResponseException {
        consumer2API.getConsumer();
//        restPost();
        return "11";
    }

    private void restPost() {
        String url = "http://consumer-2/getConsumer";
        httpUtils.getData(url, headers -> headers.add("Connection", "keep-alive"), null, void.class);

    }
}
