package com.myy.springbootrabbitmq.service.impl;

import com.myy.springbootrabbitmq.service.ReceiveService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("receiveService")
public class ReceiveServiceImpl implements ReceiveService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void receiveMessage() {
        String message = (String) amqpTemplate.receiveAndConvert("Boot-queue");
        System.out.println("接受的消息:" + message);
    }

    @Override
    @RabbitListener(queues = "Order-queue")
    public void autoReceiveMessage(String message) {
        System.out.println("接受的消息:" + message);
    }
}
