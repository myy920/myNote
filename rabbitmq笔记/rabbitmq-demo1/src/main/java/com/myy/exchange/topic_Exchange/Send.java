package com.myy.exchange.topic_Exchange;

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

            channel.exchangeDeclare("Topic-Exchange", "topic", true);
            String message = "Topic-exchange发送消息5";
            channel.basicPublish("Topic-Exchange", "aa.bb", null, message.getBytes("utf-8"));
            System.out.println("发送消息成功!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
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
