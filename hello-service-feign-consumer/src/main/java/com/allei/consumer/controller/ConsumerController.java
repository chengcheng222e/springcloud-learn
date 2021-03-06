package com.allei.consumer.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.allei.consumer.service.FeignHelloService;
import com.allei.dto.User;

/**
 * @author alleiming 2017/12/1 下午9:59
 */
@RequestMapping("/feign")
@RestController
public class ConsumerController {
    //
    //    @Autowired
    //    LocalHelloService helloService;

    @Resource
    private FeignHelloService helloService;

    @RequestMapping(value = "/helloUser", method = RequestMethod.GET)
    public String helloUser() {
        return helloService.hello(new User("mingli", 18));
    }

}
