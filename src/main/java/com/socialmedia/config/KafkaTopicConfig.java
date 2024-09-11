package com.socialmedia.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

	@Bean
    public NewTopic userPostNotificationsTopic() {
        return new NewTopic("user-post-notifications", 1, (short) 1);
    }
}
