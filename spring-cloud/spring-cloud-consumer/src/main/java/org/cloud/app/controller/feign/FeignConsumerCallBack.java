package org.cloud.app.controller.feign;

import org.springframework.stereotype.Component;

@Component
public class FeignConsumerCallBack implements FeignConsumer {

    @Override
    public String say(String name) {
        return "FailCallBack";
    }

}
