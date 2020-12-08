package com.myy.springbootrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    /**
     * 创建一个队列
     *
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue("Boot-queue", true, false, false, null);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("Boot-directExchange", true, false);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("boot-bindingKey");
    }

}


