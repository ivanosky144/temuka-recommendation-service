package com.app.config;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.exceptions.Neo4jException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.core.DatabaseSelection;
import org.springframework.data.neo4j.core.DatabaseSelectionProvider;
import org.springframework.data.neo4j.core.transaction.Neo4jTransactionManager;
import org.springframework.data.neo4j.core.Neo4jTemplate;

@Configuration
public class Neo4jConfig {

    @Value("${spring.data.neo4j.uri}")
    private String uri;

    @Value("${spring.data.neo4j.username}")
    private String username;

    @Value("${spring.data.neo4j.password}")
    private String password;

    @Value("${spring.data.neo4j.database}")
    private String database;

    @Bean
    public DatabaseSelectionProvider databaseSelectionProvider() {
        return () -> DatabaseSelection.byName(database);
    }

    @Bean
    public Neo4jTransactionManager transactionManager(Driver driver, DatabaseSelectionProvider databaseSelectionProvider) {
        return new Neo4jTransactionManager(driver, databaseSelectionProvider);
    }

    @Bean
    public Driver driver() {
        org.neo4j.driver.Config config = org.neo4j.driver.Config.builder().build();
        Driver driver = org.neo4j.driver.GraphDatabase.driver(uri, org.neo4j.driver.AuthTokens.basic(username, password), config);

        try (Session session = driver.session()) {
            session.run("RETURN 1");
            System.out.println("✅ Connected to Neo4j at " + uri);
        } catch (Neo4jException e) {
            System.err.println("❌ Failed to connect to Neo4j: " + e.getMessage());
        }

        return driver;
    }
}
