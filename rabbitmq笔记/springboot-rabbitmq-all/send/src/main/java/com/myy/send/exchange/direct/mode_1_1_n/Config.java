package com.myy.send.exchange.direct.mode_1_1_n;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 1-1-n
 */
@Configuration("config1")
public class Config {

    @Bean("Queue:boot:direct:model1")
    Queue queue() {
        return new Queue("Queue:boot:direct:model1", true, false, false);
    }

    @Bean("Exchange:boot:direct:model1")
    DirectExchange directExchange() {
        return new DirectExchange("Exchange:boot:direct:model1", true, false);
    }

    @Bean("binding1")
    Binding binding(@Qualifier("Queue:boot:direct:model1") Queue queue,
                    @Qualifier("Exchange:boot:direct:model1") DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("key:boot:direct:model1");
    }
}
