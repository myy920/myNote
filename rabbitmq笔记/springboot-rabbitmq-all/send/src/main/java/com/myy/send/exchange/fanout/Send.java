package com.myy.send.exchange.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("send3")
@RequestMapping("/fanout")
public class Send {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "/model1", produces = "text/application;charset=utf-8")
    public String model1(Integer n) {
        String message = "欲穷千里目,更上一层楼!";
        for (int i = 0; i < n; i++) {
            amqpTemplate.convertAndSend("Exchange:boot:fanout", "", message);
        }
        return "成功添加" + n + "条消息!";
    }
}
