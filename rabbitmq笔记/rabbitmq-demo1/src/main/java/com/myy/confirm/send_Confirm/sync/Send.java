package com.myy.confirm.send_Confirm.sync;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.43.217");
        factory.setPort(5672);
        factory.setUsername("root");
        factory.setPassword("root");
        Connection connection = null;
        Channel channel = null;

        try {
            connection = factory.newConnection();
            channel = connection.createChannel();

            channel.queueDeclare("C-queue", true, false, false, null);
            channel.exchangeDeclare("C-DirectExchangeName", "direct", true);
            channel.queueBind("C-queue", "C-DirectExchangeName", "bind-rout-key", null);
            String message = "Direct-exchange发送消息1";
            //开启发送者确认模式
            channel.confirmSelect();
            //发送消息
            channel.basicPublish("C-DirectExchangeName", "bind-rout-key", null, message.getBytes("utf-8"));
            /**
             * 可使用循环再次发送
             * channel.waitForConfirms(): 确认单个消息是否发送成功
             * channel.waitForConfirmsOrDie(): 确认多个消息是否发送成功
             */

            boolean flag = channel.waitForConfirms();
            System.out.println("发送消息成功:" + flag);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (channel != null) channel.close();
                if (connection != null) connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }
}
