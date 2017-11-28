package org.cloud.app.controller.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignConsumerController {
    @Autowired
    public FeignConsumer feignConsumer;

    @RequestMapping(value = "/sayInFeign", method = RequestMethod.GET)
    public String add() {
        return feignConsumer.say("jack");
    }

}
