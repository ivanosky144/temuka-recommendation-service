package com.app.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDateTime;
import java.util.List;

public class Community {

    @Id
    private Long id;
    private String name;
    private String description;
    private Integer membersCount;
    private String logoPicture;
    
    @Relationship(type = "HAS_POST", direction = Relationship.Direction.OUTGOING)
    private List<Post> posts;
}
