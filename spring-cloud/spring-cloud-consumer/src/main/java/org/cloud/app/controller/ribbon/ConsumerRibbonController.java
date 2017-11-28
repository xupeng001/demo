package org.cloud.app.controller.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerRibbonController {
    @Autowired
    public RibbonService service;
    @Autowired
    public HelloService  helloService;

    @RequestMapping(value = "/sayInRibbon", method = RequestMethod.GET)
    public String add() {
        return service.sayHelloService();
    }

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }
}
