package com.app.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Component
public class ContentInteractionQueue {

    private final StringRedisTemplate redisTemplate;

    @Autowired
    public ContentInteractionQueue(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Bean(name = "contentInteractionMessageListenerContainer")
    public RedisMessageListenerContainer messageListenerContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisTemplate.getConnectionFactory());
        container.addMessageListener(
            new MessageListenerAdapter(this, "processMessage"),
            new ChannelTopic("contentInteractionChannel")
        );
        System.out.println("✅ Content Interaction Queue is running...");
        return container;
    }

    public void processMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
