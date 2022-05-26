package com.tdp.ms.triajekafka.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.tdp.ms.triajekafka.model.AveriaKafka;
import com.tdp.ms.triajekafka.repository.TdpAveriaRepository;



@Repository
public class TdpAveriaRepositoryImpl implements TdpAveriaRepository {

	private final MongoOperations mongoOperations;
	
	@Autowired
    public TdpAveriaRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
	
	

	@Override
	public void insertTopic(AveriaKafka averiaKafka) {
		this.mongoOperations.insert(averiaKafka);

	}

}
