package com.myy.receive.exchange.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service("service3")
public class Receive {

    @RabbitListener(queues = {"Queue:boot:fanout:queue1", "Queue:boot:fanout:queue2", "Queue:boot:fanout:queue3"})
    public void receive(String message){
        System.out.println(message);
    }
}
