package com.myy.send.exchange.direct.mode_1_n_1;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("config2")
public class Config {

    @Bean("Queue:boot:direct:model2:queue1")
    Queue queue1() {
        return new Queue("Queue:boot:direct:model2:queue1", true, false, false);
    }

    @Bean("Queue:boot:direct:model2:queue2")
    Queue queue2() {
        return new Queue("Queue:boot:direct:model2:queue2", true, false, false);
    }

    @Bean("Exchange:boot:direct:model2")
    DirectExchange directExchange() {
        return new DirectExchange("Exchange:boot:direct:model2", true, false);
    }

    @Bean("binding2")
    Binding binding2(@Qualifier("Queue:boot:direct:model2:queue1") Queue queue,
                    @Qualifier("Exchange:boot:direct:model2") DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("key:boot:direct:model2");
    }
    @Bean("binding3")
    Binding binding3(@Qualifier("Queue:boot:direct:model2:queue2") Queue queue,
                    @Qualifier("Exchange:boot:direct:model2") DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("key:boot:direct:model2");
    }
}
