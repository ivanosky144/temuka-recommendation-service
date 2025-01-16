package com.app.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDateTime;
import java.util.List;

public class Major {
    
    @Id
    private Long id;
    private String name;
    private Integer rating;
    private Integer totalReviews;

    @Relationship(type = "HAS_REVIEW", direction = Relationship.Direction.OUTGOING)
    private List<MajorReview> reviews;
}
