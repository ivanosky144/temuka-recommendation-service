package com.app.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class CommunityRecommendation {

    @Id
    private Long id;
    private Long userId;
    private Long recommendedCommunityId;

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

    public Long getRecommendedCommunityId() {
        return recommendedCommunityId;
    }

    public void setRecommendedCommunityId(Long recommendedCommunityId) {
        this.recommendedCommunityId = recommendedCommunityId;
    }
}
