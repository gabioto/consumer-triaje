package com.tdp.ms.triajekafka.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.tdp.ms.triajekafka.external.AveriasApi;
import com.tdp.ms.triajekafka.service.TdpTriageService;

@Service
public class TdpTriageServiceImpl implements TdpTriageService {

	@Autowired
    private AveriasApi averiasApi;
	
	private static final Logger LOG = LoggerFactory.getLogger(TdpTriageServiceImpl.class);
	@Async
	@Override
	public Boolean insertTriage(String data, String status, String orderCode) {
		averiasApi.insertTriage(data, status, orderCode);		
		return true;
	}

}
