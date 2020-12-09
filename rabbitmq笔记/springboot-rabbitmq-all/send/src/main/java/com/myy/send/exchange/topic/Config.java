package com.myy.send.exchange.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("config4")
public class Config {

    @Bean("Queue:boot:topic:queue.aa")
    Queue queue1() {
        return new Queue("Queue:boot:topic:queue.aa", true, false, false);
    }

    @Bean("Queue:boot:topic:queue.aa.*")
    Queue queue2() {
        return new Queue("Queue:boot:topic:queue.aa.*", true, false, false);
    }

    @Bean("Queue:boot:topic:queue.aa.#")
    Queue queue3() {
        return new Queue("Queue:boot:topic:queue.aa.#", true, false, false);
    }

    @Bean("Exchange:boot:topic")
    TopicExchange topicExchange(){
        return new TopicExchange("Exchange:boot:topic",true,false);
    }
    @Bean("binding:topic:1")
    Binding binding1(@Qualifier("Queue:boot:topic:queue.aa") Queue queue,
                    @Qualifier("Exchange:boot:topic") TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("aa");
    }
    @Bean("binding:topic:2")
    Binding binding2(@Qualifier("Queue:boot:topic:queue.aa.*") Queue queue,
                    @Qualifier("Exchange:boot:topic") TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("aa.*");
    }
    @Bean("binding:topic:3")
    Binding binding3(@Qualifier("Queue:boot:topic:queue.aa.#") Queue queue,
                    @Qualifier("Exchange:boot:topic") TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("aa.#");
    }

}
