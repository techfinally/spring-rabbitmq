package com.techfinally.rabbitmq.controller;

import com.techfinally.rabbitmq.model.Mesage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author Tech Finally
 */
@Component
public class Consumer {

    @RabbitListener(queues = "${jsa.rabbitmq.queue}")
    public void recievedMessage(Mesage mail) {
        System.out.println("Recieved Message: " + mail.toString());
    }

}
