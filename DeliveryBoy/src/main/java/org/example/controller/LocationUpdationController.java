package org.example.controller;

import org.example.config.KafkaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationUpdationController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @GetMapping(value = "/update")
    public void updateLocation(@RequestParam Double latitude, @RequestParam Double longitude) {
        kafkaTemplate.send(KafkaConfig.TOPIC_NAME, latitude + "," + longitude);
        System.out.println("Message sent");
    }
}
