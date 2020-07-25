package com.allei.service.contorller;

import com.allei.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String hello(@RequestBody User user) {
        log.info("====== welcome to HelloController ========");
        return "Hello " + user.getName() + ", " + user.getAge();
    }

}