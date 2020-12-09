package com.myy.onlyQueue;


import com.rabbitmq.client.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class App {
    /*1.只是用队列*/

    /**
     * 向队列中发送消息
     *
     * @param
     */
    @Test
    public void test1() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.43.217");
        factory.setPort(5672);
        factory.setUsername("root");
        factory.setPassword("root");
        Connection connection = null;//声明连接
        Channel channel = null;//声明通道

        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            //queueDeclare(消息队列名称，是否持久化队列，是否只允许一个消费者监听，是否自动删除，为队列设置属性）
            channel.queueDeclare("myQueue", true, false, false, null);
            String message = "落霞与孤鹜齐飞，秋水共长天一色2";
            //basicPublish(交换机名称或为""不使用交换机，routingkey或为消息队列名称，消息属性信息通常为null，指定编码的message)
            channel.basicPublish("", "myQueue", null, message.getBytes("utf-8"));
            System.out.println("消息发送成功!");
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    /**
     * 接受消息
     */
    @Test
    public void test2() {
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
            channel.queueDeclare("myQueue", true, false, false, null);
            channel.basicConsume("myQueue", true, "", new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "utf-8");
                    System.out.println("接受的消息是:" + message);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    /*2.使用交换机*/

    /**
     * direct-exchange发送消息
     */
    @Test
    public void test3() {
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

            channel.queueDeclare("D-queue", true, false, false, null);
            channel.exchangeDeclare("DirectExchangeName", "direct", true);
            channel.queueBind("D-queue", "DirectExchangeName", "bind-rout-key", null);
            String message = "Direct-exchange发送消息4";
            channel.basicPublish("DirectExchangeName", "bind-rout-key", null, message.getBytes("utf-8"));
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

    @Test
    public void test4() {
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
            channel.queueDeclare("D-queue", true, false, false, null);
            channel.exchangeDeclare("DirectExchangeName", "direct", true);
            channel.queueBind("D-queue", "DirectExchangeName", "bind-rout-key", null);
            channel.basicConsume("D-queue", true, "", new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "utf-8");
                    System.out.println("direct-exc接受的消息是:" + message);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}



























