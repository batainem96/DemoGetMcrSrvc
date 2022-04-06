package com.demo.mcrsrvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class AppConfig {

    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://demoUser:splatCat21!@3.144.70.206:27017");
    }

    public @Bean
    MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "employees");
    }
}