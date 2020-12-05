package com.myy.confirm.send_Confirm.async;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
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
            channel.exchangeDeclare("A-DirectExchangeName", "direct", true);
            channel.queueBind("C-queue", "A-DirectExchangeName", "bind-rout-key", null);

            //开启发送者确认模式
            channel.confirmSelect();
            //启用异步监听
            channel.addConfirmListener(new ConfirmListener() {
                /**
                 * 发送成功
                 * @param l : 当前编号
                 * @param b : 为true表示当前多条消息发送成功,为false表示当前一条消息发送成功
                 * @throws IOException
                 */
                @Override
                public void handleAck(long l, boolean b) throws IOException {
                    System.out.println("当前编号:" + l + "-----是否确认了编号小于等于当前编号的多条消息发送成功:" + b);
                }

                /**
                 * 发送失败
                 * @param l : 当前编号
                 * @param b : 为true表示当前多条消息发送失败,为false表示当前一条消息发送失败
                 * @throws IOException
                 */
                @Override
                public void handleNack(long l, boolean b) throws IOException {
                    System.out.println("当前编号" + l + "发送" + b);
                }
            });
            //发送消息
            String message = "Direct-exchange发送消息1";
            for (int i = 0; i < 10000; i++) {
                channel.basicPublish("A-DirectExchangeName", "bind-rout-key", null, message.getBytes("utf-8"));
            }

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

