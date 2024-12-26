package com.app.internal.handler;

import com.app.internal.model.Post;
import com.app.internal.model.User;
import com.app.internal.model.Community;
import com.app.internal.queue.ContentInteractionQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContentInteractionHandler {

    @Autowired
    private ContentInteractionQueue contentInteractionQueue;

    public void handleContentInteraction(User user, Post post, Community community) {
        System.out.println("Processing Content Interaction for User: " + user.getId());
    }
}
