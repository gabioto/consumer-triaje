package com.tdp.ms.triajekafka.service.impl;

import java.util.regex.Pattern;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Service;

import com.tdp.ms.triajekafka.consumer.Receiver;
import com.tdp.ms.triajekafka.service.LecturaService;
import com.tdp.ms.triajekafka.service.TdpAveriaService;
import com.tdp.ms.triajekafka.service.TdpTriageService;
import com.tdp.ms.triajekafka.util.Constants;

@Service
public class LecturaServiceImpl implements LecturaService{

	private static final Logger log = LoggerFactory.getLogger(Receiver.class);
	@Autowired
	TdpTriageService tdpTriageService;
	
	@Autowired
	TdpAveriaService tdpAveriaService;
	
	@Override
	public void lectura(String message) {
		// TODO Auto-generated method stub
		String separador = Pattern.quote(Constants.BARRA_VERTICAL);
		String[] parts = message.split(separador);
	
		
	
		String activity_status = parts[3] == null ? "" : parts[3];
		String orderCode = parts[1] == null ? "" : parts[1];
	
		try { 
			insertTriageTopico(message, parts);
			if (parts[0].toString().equalsIgnoreCase("TRIAJE")) {
					if (activity_status.trim().equalsIgnoreCase(Constants.STATUS_PENDIENTE)
							|| activity_status.trim().equalsIgnoreCase(Constants.STATUS_LIQUIDADO)) {
						insertTriage(message, activity_status, orderCode);
					}
			}
		} catch (Exception e) {
			log.error(this.getClass().getName() + " - Exception: " + e.getMessage());
		}
	}

	@Consumes(MediaType.APPLICATION_JSON) 
	public void insertTriage(@RequestBody @Valid String data, String status, String orderCode) {
		tdpTriageService.insertTriage(data, status, orderCode);
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	public Boolean insertTriageTopico(String data, String[] dataSplit) {
		try {
			if (dataSplit[0].toString().equalsIgnoreCase("TRIAJE")) { 
				tdpAveriaService.insertProvisionTopic(data, "", dataSplit[1], dataSplit[3], dataSplit[22], dataSplit[40],
						dataSplit[7], dataSplit[16]);
			}
		
		} catch (Exception e) {
			throw e;
		}
		return true;
	}
}
