package com.allei.service.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with springcloud-learn
 *
 * @description:
 * @author: chenyuan
 * @date: 2019/9/9
 * @time: 3:36 PM
 */
@Endpoint(id = "oss")
public class MyEndpoint {

    @ReadOperation
    public Map<String, Object> invoke() {
        Map<String, Object> result = new HashMap<>(16);
        result.put("size", 100);
        Map info = new HashMap();
        info.put("userName", "chenyuan001");
        info.put("age", 30);
        result.put("info", info);
        return result;
    }
}
