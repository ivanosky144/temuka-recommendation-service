package com.app.internal.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import com.app.internal.handler.ContentInteractionHandler;

@Component
public class ContentInteractionQueue {

    private final StringRedisTemplate redisTemplate;
    private final ContentInteractionHandler contentInteractionHandler;

    @Autowired
    public ContentInteractionQueue(StringRedisTemplate redisTemplate, ContentInteractionHandler contentInteractionHandler) {
        this.redisTemplate = redisTemplate;
        this.contentInteractionHandler = contentInteractionHandler;
    }

    @Bean
    public RedisMessageListenerContainer messageListenerContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisTemplate.getConnectionFactory());
        container.addMessageListener(
            new MessageListenerAdapter(this, "processContentInteractionMessage"),
            new ChannelTopic("contentInteractionChannel")
        );        
        return container;
    }

    public void processContentInteractionMessage(String message) {
        contentInteractionHandler.handleContentInteraction(null);
    }
}
