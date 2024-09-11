package com.socialmedia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    private static final String TOPIC = "user-post-notifications";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendNotification(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
