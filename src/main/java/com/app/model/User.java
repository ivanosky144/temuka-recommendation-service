package com.app.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDateTime;
import java.util.List;

public class User {
    
    @Id
    private Long id;
    private String username;
    private String displayname;
    private String email;
    private String password;
    private String profilePicture;
    private Integer socialPoint;

    @Relationship(type = "FOLLOWS", direction = Relationship.Direction.OUTGOING)
    private List<User> followings;

    @Relationship(type = "HAS_COMMENT", direction = Relationship.Direction.OUTGOING)
    private List<Comment> comments;

    @Relationship(type = "IS_MEMBER_OF", direction = Relationship.Direction.INCOMING)
    private List<Community> communities;

    @Relationship(type = "HAS_POST", direction = Relationship.Direction.OUTGOING)
    private List<Post> posts;
}
