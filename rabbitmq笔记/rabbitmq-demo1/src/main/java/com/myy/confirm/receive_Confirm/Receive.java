package com.myy.confirm.receive_Confirm;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Receive {

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

            channel.basicConsume("C-queue", false, new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    if (envelope.isRedeliver()) {
                        //消息的防重放处理
                    } else {
                        System.out.println(new String(body, "utf-8"));
                        //获取当前channel
                        Channel c = this.getChannel();
                        //获取当前消息编号
                        long tag = envelope.getDeliveryTag();
                        /**
                         * 该方法应该放在最后执行
                         * 从队列中移除消息
                         * 参数1--tag:当前消息编号
                         * 参数2: true表示移除多个消息(编号小于等于当前编号的消息)
                         *       false表示移除当前编号的消息
                         */
                        c.basicAck(tag, true);
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
