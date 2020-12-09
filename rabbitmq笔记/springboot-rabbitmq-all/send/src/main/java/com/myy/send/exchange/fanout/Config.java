package com.myy.send.exchange.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("config3")
public class Config {

    @Bean("Queue:boot:fanout:queue1")
    Queue queue1() {
        return new Queue("Queue:boot:fanout:queue1", true, false, false);
    }

    @Bean("Queue:boot:fanout:queue2")
    Queue queue2() {
        return new Queue("Queue:boot:fanout:queue2", true, false, false);
    }

    @Bean("Queue:boot:fanout:queue3")
    Queue queue3() {
        return new Queue("Queue:boot:fanout:queue3", true, false, false);
    }

    @Bean("Exchange:boot:fanout")
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("Exchange:boot:fanout", true, false);
    }

    @Bean("binding4")
    Binding binding1(@Qualifier("Queue:boot:fanout:queue1") Queue queue,
                     @Qualifier("Exchange:boot:fanout") FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean("binding5")
    Binding binding2(@Qualifier("Queue:boot:fanout:queue2") Queue queue,
                     @Qualifier("Exchange:boot:fanout") FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean("binding6")
    Binding binding3(@Qualifier("Queue:boot:fanout:queue3") Queue queue,
                     @Qualifier("Exchange:boot:fanout") FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
}
