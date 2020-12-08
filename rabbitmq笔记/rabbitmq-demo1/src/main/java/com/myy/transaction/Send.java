package com.myy.transaction;

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

            channel.queueDeclare("Transaction-queue", true, false, false, null);
            channel.exchangeDeclare("T-DirectExchangeName", "direct", true);
            channel.queueBind("Transaction-queue", "T-DirectExchangeName", "bind-rout-key", null);
            String message1 = "Transaction-message1";
            String message2 = "Transaction-message2";
            //开启事务
            channel.txSelect();
            channel.basicPublish("T-DirectExchangeName", "bind-rout-key", null, message1.getBytes("utf-8"));
            channel.basicPublish("T-DirectExchangeName", "bind-rout-key", null, message2.getBytes("utf-8"));
            //提交事务
            channel.txCommit();
            System.out.println("发送消息成功!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (Exception e) {
            try {
                channel.txRollback();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
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
