package com.app.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDateTime;
import java.util.List;

@Node
public class Comment {
    
    @Id
    private Long id;
    private Long userId;
    private Long postId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Relationship(type = "HAS_REPLY", direction = Relationship.Direction.OUTGOING)
    private List<Comment> replies;

    @Relationship(type = "PARENT", direction = Relationship.Direction.INCOMING)
    private Comment parent;
}
