package com.app.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDateTime;
import java.util.List;

public class University {
    
    @Id
    private Long id;
    private String name;
    private String slug;
    private String logo;
    private String summary;

    @Relationship(type = "HAS_REVIEW", direction = Relationship.Direction.OUTGOING)
    private List<Review> reviews;

    @Relationship(type = "HAS_MAJOR", direction = Relationship.Direction.OUTGOING)
    private List<Major> majors;
}
