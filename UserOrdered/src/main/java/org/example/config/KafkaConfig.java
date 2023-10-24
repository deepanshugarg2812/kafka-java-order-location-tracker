package org.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaConfig {
    public static final String TOPIC_NAME = "location-order";

    public NewTopic getTopic() {
        return TopicBuilder.name(TOPIC_NAME).partitions(10).replicas(2).build();
    }
}
