package com.tdp.ms.triajekafka.repository.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoOperations;

import com.tdp.ms.triajekafka.model.AveriaKafka;

@ExtendWith(MockitoExtension.class)
public class TdpAveriaRepositoryImplTest {

	@Mock
	MongoOperations mongoOperations;
	
	@InjectMocks
	TdpAveriaRepositoryImpl tdpAveriaRepositoryImpl;
	
	@Test
	void insert_ok() {
		this.mongoOperations = mongoOperations;
		tdpAveriaRepositoryImpl.insertTopic(new AveriaKafka());
	}
	 
}
