package org.cloud.app.controller.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String sayHelloService() {
        return restTemplate.getForEntity("http://spring-cloud-provider/sayHello?name=jackman", String.class).getBody();
    }

    public String fallback() {
        return "fallback";/* something useful */
    }
}
