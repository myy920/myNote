package com.myy.send.exchange.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;

@RestController("send4")
@RequestMapping("/topic")
public class Send {

    @Autowired
    private RabbitTemplate amqpTemplate;

    @RequestMapping(value = "/model1", produces = "text/application;charset=utf-8")
    public String model1(Integer n) throws NoSuchFieldException, IllegalAccessException {
        String message = "落霞与孤鹜齐飞,秋水共长天一色!";
        for (int i = 0; i < n; i++) {
            amqpTemplate.convertAndSend("Exchange:boot:topic", "aa", message);
        }
        Field publisherConfirms = RabbitTemplate.class.getDeclaredField("publisherConfirms");
        if (publisherConfirms.getBoolean(amqpTemplate)){
            return "true";
        }else {
            return "false";
        }
        //return "成功添加" + n + "条消息!";
    }

    @RequestMapping(value = "/model2", produces = "text/application;charset=utf-8")
    public String model2(Integer n) {
        String message = "落霞与孤鹜齐飞,秋水共长天一色!";
        for (int i = 0; i < n; i++) {
            amqpTemplate.convertAndSend("Exchange:boot:topic", "aa.*", message);
        }
        return "成功添加" + n + "条消息!";
    }

    @RequestMapping(value = "/model3", produces = "text/application;charset=utf-8")
    public String model3(Integer n) {
        String message = "落霞与孤鹜齐飞,秋水共长天一色!";
        for (int i = 0; i < n; i++) {
            amqpTemplate.convertAndSend("Exchange:boot:topic", "aa.#", message);
        }
        return "成功添加" + n + "条消息!";
    }
}
