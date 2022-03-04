package io.musimap.catalog.data.store.adapter.out.persistence.config;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;
import java.util.logging.Logger;

@Configuration
@EnableMongoRepositories(basePackages = "io.musimap.catalog.data.store.adapter.out.persistence")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${io.musimap.catalog.db.host}")
    private String host;

    @Value("${io.musimap.catalog.db.port}")
    private Integer port;

    @Value("${io.musimap.catalog.db.username}")
    private String username;

    @Value("${io.musimap.catalog.db.password}")
    private String password;

    @Value("${io.musimap.catalog.db.name}")
    private String database;

    private final Logger LOGGER = Logger.getLogger(this.getClass().getSimpleName());

    @Primary
    @Bean
    @Override
    public MongoClient mongoClient() {

        return MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder ->
                                builder.hosts(Arrays.asList(new ServerAddress(host, port)))).build());
    }

    private MongoCredential mongoCredentials() {
        return MongoCredential.createCredential(username, database, password.toCharArray());
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient(), getDatabaseName());
        mongoTemplate.setReadPreference(ReadPreference.secondaryPreferred());
        return mongoTemplate;
    }

    protected String getDatabaseName() {
        return database;
    }

    @Override
    public boolean autoIndexCreation() {
        return false;
    }

}