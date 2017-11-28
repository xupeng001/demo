package org.cloud.app.controller.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "spring-cloud-provider", fallback = FeignConsumerCallBack.class)
public interface FeignConsumer {

    @RequestMapping(method = RequestMethod.GET, value = "/sayHello")
    String say(@RequestParam(value = "name") String name);
}
