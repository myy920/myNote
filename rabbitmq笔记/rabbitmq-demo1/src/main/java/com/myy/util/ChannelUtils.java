package com.myy.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ChannelUtils {

    private static Channel channel;
    private static Connection connection;

    static {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.43.217");
        factory.setPort(5672);
        factory.setUsername("root");
        factory.setPassword("root");
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static Channel getChannel() {
        return channel;
    }

    public static void close() {
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
