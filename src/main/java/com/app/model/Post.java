package com.app.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDateTime;
import java.util.List;

public class Post {
    
    @Id
    private Long id;
    private String title;
    private String description;
    private Integer totalLikes;
    private Integer totalComments;

    @Relationship(type = "HAS_COMMENT", direction = Relationship.Direction.OUTGOING)
    private List<Comment> comments;
}
