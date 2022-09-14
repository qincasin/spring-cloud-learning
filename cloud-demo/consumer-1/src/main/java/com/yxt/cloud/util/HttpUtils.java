package com.yxt.cloud.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.function.Consumer;

/**
 * HttpUtils
 *
 * @author by geyan
 * @Date 2021/12/28 1:21 下午
 */
@Component
public class HttpUtils {
    @Autowired
    private RestTemplate restTemplate;


    /**
     * post data
     * @param url
     * @param headConsumer
     * @param postBody
     * @param responseType
     * @param <T>
     * @param <B>
     * @return
     */
    public <T, B> T postData(String url, Consumer<HttpHeaders> headConsumer,
                                    B postBody, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (headConsumer != null) {
            headConsumer.accept(headers);
        }
        ResponseEntity<T> resp = restTemplate.postForEntity(url, new HttpEntity(postBody, headers), responseType);
        if (resp.getStatusCode().is2xxSuccessful()) {
            return resp.getBody();
        }
        return null;
    }

    public  <T, B> T getData(String url, Consumer<HttpHeaders> headConsumer,
            B body, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (headConsumer != null) {
            headConsumer.accept(headers);
        }
        ResponseEntity<T> resp = restTemplate.exchange(url, HttpMethod.GET,new HttpEntity(body, headers), responseType);
        if (resp.getStatusCode().is2xxSuccessful()) {
            return resp.getBody();
        }
        return null;
    }


    /**
     * url with path /
     * @param url
     * @return
     */
    public static String urlWithPath(String url) {
        if (url.charAt(url.length() - 1) == '/') {
            return url;
        } else {
            return url + "/";
        }
    }
}
