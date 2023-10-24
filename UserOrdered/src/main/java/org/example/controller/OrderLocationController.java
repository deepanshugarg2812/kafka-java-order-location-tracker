package org.example.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.config.KafkaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderLocationController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = {KafkaConfig.TOPIC_NAME}, groupId = "group_id")
    public String getOrderLocation(String location) {
        System.out.println("message =>" +  location);
        return location;
    }
}
