package com.myy.send.exchange.direct.mode_1_n_1;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("send2")
@RequestMapping("/direct")
public class Send {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "/model2",produces = "text/plain;charset=UTF-8")
    public String model2(Integer n){
        String message = "两岸猿声啼不住,轻舟已过万重山!";
        for (int i = 0; i < n; i++) {
            amqpTemplate.convertAndSend("Exchange:boot:direct:model2","key:boot:direct:model2",message);
        }

        return "成功添加"+n+"条消息!";
    }
}
