package org.cloud.app.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHello {
    private final Logger    logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/api-b/sayHello", method = RequestMethod.GET)
    public String sayHello(@RequestParam String name) throws InterruptedException {
        ServiceInstance instance = client.getLocalServiceInstance();
        Thread.sleep(5000);
        String r = "hello," + name;
        String string = "/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:"
                + r;
        logger.info(string);
        return string;
    }

}
