package com.tdp.ms.triajekafka.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.tdp.ms.triajekafka.model.AveriaKafka;
import com.tdp.ms.triajekafka.repository.TdpAveriaRepository;
import com.tdp.ms.triajekafka.service.TdpAveriaService;

@Service
public class TdpAveriaServiceImpl implements TdpAveriaService {

	@Autowired
	private TdpAveriaRepository tdpAveriaRepository;

	@Async
	@Override
	public void insertProvisionTopic(String data, String dateKafka, String xaRequest, String status, String masive,
			String bandeja, String motivo, String idServicio) {

		AveriaKafka averiaKafka = new AveriaKafka();
		averiaKafka.setData(data);
		averiaKafka.setDateKafka(dateKafka);
		averiaKafka.setXaRequest(xaRequest);
		averiaKafka.setStatus(status);
		averiaKafka.setMasive(masive);
		averiaKafka.setBandeja(bandeja);
		averiaKafka.setMotivo(motivo);
		averiaKafka.setIdServicio(idServicio);
		
		tdpAveriaRepository.insertTopic(averiaKafka);
		// TODO Auto-generated method stub

	}

}
