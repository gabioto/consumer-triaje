package com.tdp.ms.triajekafka.service;

public interface TdpAveriaService {

	// void insertRegistry(CollAverias collAverias);
	void insertProvisionTopic(String data, String dateKafka, String xaRequest, String status, String masive,
			String bandeja, String motivo, String idServicio);

}
