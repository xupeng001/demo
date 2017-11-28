package org.cloud.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @Value("${from}")
    private String form;

    @RequestMapping("/")
    public String home() {
        System.out.println(form);
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        //        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }

}
