package com.allei.service.contorller;

import com.allei.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
    private DiscoveryClient client;

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String hello(@RequestBody User user) {
		List<String> instance = client.getServices();
		try {
			TimeUnit.SECONDS.sleep(2l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("/hello3, host:" + instance + ", service_id:" + instance);
		return "Hello "+ user.getName() + ", " + user.getAge();
	}

}