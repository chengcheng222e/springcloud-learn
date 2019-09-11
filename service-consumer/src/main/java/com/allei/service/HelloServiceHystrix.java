package com.allei.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author alleiming 2017/12/23 上午12:03
 */
@Service
public class HelloServiceHystrix {

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello(){
        RestTemplate restTemplate = new RestTemplate();
        String resp = restTemplate.getForEntity("http://localhost:8082/hello", String.class).getBody();
        return resp;
    }

    public String helloFallback(){
        return "error";
    }
}
