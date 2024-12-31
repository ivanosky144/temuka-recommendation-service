package com.app.handler;

import com.app.model.Post;
import com.app.model.User;
import com.app.model.Community;
import com.app.queue.ContentInteractionQueue;
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
