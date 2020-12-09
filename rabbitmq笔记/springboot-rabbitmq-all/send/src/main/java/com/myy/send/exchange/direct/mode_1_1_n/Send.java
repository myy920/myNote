package com.myy.send.exchange.direct.mode_1_1_n;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("send1")
@RequestMapping("/direct")
public class Send {

    @Autowired
    private AmqpTemplate amqpTemplate;
    private String message = "不经一番彻骨寒,怎得梅花扑鼻香!";


    @RequestMapping(value = "/model1",produces = "text/plain;charset=UTF-8")
    public String model1(Integer n) {
        for (int i = 0; i < n; i++) {
            amqpTemplate.convertAndSend("Exchange:boot:direct:model1","key:boot:direct:model1",message);
        }
        return "成功发送"+n+"条信息!";
    }
}
