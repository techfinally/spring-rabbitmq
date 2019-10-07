package com.techfinally.rabbitmq.service;

import com.techfinally.rabbitmq.model.Mesage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tech Finally
 */
@Service
public class MesageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${jsa.rabbitmq.exchange}")
    private String EXCHANGE;

    @Value("${jsa.rabbitmq.routingkey}")
    private String ROUTING_KEY;

    public void sendMessage(Mesage msg) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, msg);
    }

}
