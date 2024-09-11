package com.socialmedia.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(topics = "user-post-notifications", groupId = "socialmedia-group")
    public void consume(String message) {
        System.out.println("Received notification: " + message);
        // Logic to send the notification to the user (e.g., WebSocket, email, etc.)
    }
}
