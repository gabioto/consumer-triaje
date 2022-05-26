package com.tdp.ms.triajekafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class SpringMongoConfig extends AbstractMongoClientConfiguration {
	@Value("${spring.data.mongodb.uri}")
    private String mongodbUri;

	@Value("${spring.data.mongodb.database}")
    private String databaseName;
	
	@Override
	protected String getDatabaseName() {
		return databaseName;
	}

	@Override
	public MongoClient mongoClient() {
		
		ConnectionString connectionString = new ConnectionString(mongodbUri);
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.build();

		return MongoClients.create(mongoClientSettings);
	}

}