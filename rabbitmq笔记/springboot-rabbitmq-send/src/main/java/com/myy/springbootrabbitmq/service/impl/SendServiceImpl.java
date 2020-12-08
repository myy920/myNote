package com.myy.springbootrabbitmq.service.impl;

import com.myy.springbootrabbitmq.service.SendService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sendService")
public class SendServiceImpl implements SendService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send1(String message) {
        amqpTemplate.convertAndSend("Boot-directExchange", "boot-bindingKey", message);
    }
}
