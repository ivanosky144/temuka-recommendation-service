package com.app.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Component
public class EducationActivityQueue {

    private final StringRedisTemplate redisTemplate;

    @Autowired
    public EducationActivityQueue(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Bean(name = "educationActivityMessageListenerContainer")
    public RedisMessageListenerContainer messageListenerContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisTemplate.getConnectionFactory());
        container.addMessageListener(
            new MessageListenerAdapter(this, "processMessage"),
            new ChannelTopic("educationActivityChannel")
        );
        System.out.println("✅ Education Activity Queue is running...");
        return container;
    }

    public void processMessage(String message) {
        // Basic logic for processing the message
        System.out.println("Received education activity message: " + message);
    }
}
