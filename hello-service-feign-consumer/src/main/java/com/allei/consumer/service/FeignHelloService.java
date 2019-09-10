package com.allei.consumer.service;


import com.allei.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author alleiming 2017/11/1 下午9:58
 */
@FeignClient(contextId = "FeignHelloService", value = "HELLO-SERVICE", fallback = FallbackHelloService.class)
public interface FeignHelloService extends HelloService {

}
