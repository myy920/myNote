package com.myy.receive.exchange.direct.model_1_n_1;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service("service")
public class Receive {

    @RabbitListener(queues = "Queue:boot:direct:model2:queue1")
    public void receive1(String message){
        System.out.println("1--->"+message);
    }
    @RabbitListener(queues = "Queue:boot:direct:model2:queue2")
    public void receive2(String message){
        System.out.println("2--->"+message);
    }
}
