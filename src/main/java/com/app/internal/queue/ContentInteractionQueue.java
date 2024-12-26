package com.app.internal.queue;

import com.app.internal.handler.ContentInteractionHandler;
import com.app.internal.model.Post;
import com.app.internal.model.Community;
import com.app.internal.model.User;
import com.app.internal.model.UserPreferredPost;
import com.app.internal.model.UserPreferredCommunity;
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
        String userId = "extracted_user_id";
        String postId = "extracted_post_id";
        String communityId = "extracted_community_id";
        
        User user = getUserById(userId);
        Post post = getPostById(postId);
        Community community = getCommunityById(communityId);

        processUserPreferredPost(user, post);
        processUserPreferredCommunity(user, community);

        contentInteractionHandler.handleContentInteraction(user, post, community);
    }

    private User getUserById(String userId) {
        return new User();
    }

    private Post getPostById(String postId) {
        return new Post();
    }

    private Community getCommunityById(String communityId) {
        return new Community();
    }

    private void processUserPreferredPost(User user, Post post) {
        UserPreferredPost userPreferredPost = new UserPreferredPost();
        userPreferredPost.setUserId(user.getId());
        userPreferredPost.setPostId(post.getId());
    }

    private void processUserPreferredCommunity(User user, Community community) {
        UserPreferredCommunity userPreferredCommunity = new UserPreferredCommunity();
        userPreferredCommunity.setUserId(user.getId());
        userPreferredCommunity.setCommunityId(community.getId());
    }
}
