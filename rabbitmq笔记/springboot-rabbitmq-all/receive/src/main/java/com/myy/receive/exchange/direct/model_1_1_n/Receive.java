package com.myy.receive.exchange.direct.model_1_1_n;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service("service1")
public class Receive {
    //一个对象中方法多次调用
    @RabbitListener(queues = "Queue:boot:direct:model1")
    public void receive1(String message){
        System.out.println("1-->"+message);
    }

    @RabbitListener(queues = "Queue:boot:direct:model1")
    public void receive2(String message){
        System.out.println("2-->"+message);
    }
    @RabbitListener(queues = "Queue:boot:direct:model1")
    public void receive3(String message){
        System.out.println("3-->"+message);
    }
}
