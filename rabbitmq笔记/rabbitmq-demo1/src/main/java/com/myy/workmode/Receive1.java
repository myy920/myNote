package com.myy.workmode;


import com.alibaba.fastjson.JSON;
import com.myy.entity.Student;
import com.myy.util.ChannelUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

public class Receive1 {
    public static void main(String[] args) throws IOException {
        Channel channel = ChannelUtils.getChannel();
        channel.basicConsume("Queue:workmode", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                if (!envelope.isRedeliver()) {
                    Student student = (Student) JSON.parseObject(body, Student.class);
                    System.out.println(student);
                }
                channel.basicAck(envelope.getDeliveryTag(), true);
            }
        });
    }
}
