package com.app.internal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
}
