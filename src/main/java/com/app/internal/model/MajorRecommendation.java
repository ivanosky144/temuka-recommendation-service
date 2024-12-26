package com.app.internal.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class MajorRecommendation {

    @Id
    private Long id;
    private Long userId;
    private Long recommendedMajorId;

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

    public Long getRecommendedMajorId() {
        return recommendedMajorId;
    }

    public void setRecommendedMajorId(Long recommendedMajorId) {
        this.recommendedMajorId = recommendedMajorId;
    }
}
