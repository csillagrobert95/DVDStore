package com.admin.dvdstore.producer;

import com.admin.dvdstore.dvd.DVDEntry;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Robi on 11/21/2018.
 */

@Component
public class DVDProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${jsa.rabbitmq.exchange}")
    private String exchange;

    @Value("${jsa.rabbitmq.routingkey}")
    private String routingKey;

    public void produceDVDEntry(DVDEntry dvdEntry){
        amqpTemplate.convertAndSend(exchange, routingKey, dvdEntry);
        System.out.println("Send msg = " + dvdEntry.toString());
    }
}
