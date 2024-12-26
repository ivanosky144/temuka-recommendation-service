package com.app.internal.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class PostRecommendation {

    @Id
    private Long id;
    private Long userId;
    private Long recommendedPostId;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRecommendedPostId() {
        return recommendedPostId;
    }

    public void setRecommendedPostId(Long recommendedPostId) {
        this.recommendedPostId = recommendedPostId;
    }
}
