package com.myy.workmode;

import com.alibaba.fastjson.JSON;
import com.myy.entity.Student;
import com.myy.util.ChannelUtils;
import com.rabbitmq.client.Channel;

import java.io.IOException;


public class Send {
    public static void main(String[] args) {
        Channel channel = ChannelUtils.getChannel();
        try {
            channel.queueDeclare("Queue:workmode", true, false, false, null);
            channel.exchangeDeclare("Exchange:workmode", "fanout", false);
            channel.queueBind("Queue:workmode", "Exchange:workmode", "");
            channel.confirmSelect();
            for (int i = 0; i < 5; i++) {
                do {
                    Student student = new Student(1, "小明", '男');
                    byte[] bytes = JSON.toJSONBytes(student);
                    channel.basicPublish("Exchange:workmode", "", null, bytes);
                } while (!channel.waitForConfirms());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            ChannelUtils.close();
        }
    }
}
