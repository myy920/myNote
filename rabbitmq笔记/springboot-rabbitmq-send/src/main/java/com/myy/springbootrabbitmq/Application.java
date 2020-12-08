package com.myy.springbootrabbitmq;

import com.myy.springbootrabbitmq.service.SendService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(Application.class, args);
    }


}
