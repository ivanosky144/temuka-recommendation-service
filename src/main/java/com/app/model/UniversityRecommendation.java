package com.app.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class UniversityRecommendation {

    @Id
    private Long id;
    private Long userId;
    private Long recommendedUniversityId;

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

    public Long getRecommendedUniversityId() {
        return recommendedUniversityId;
    }

    public void setRecommendedUniversityId(Long recommendedUniversityId) {
        this.recommendedUniversityId = recommendedUniversityId;
    }
}
