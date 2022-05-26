package com.tdp.ms.triajekafka.consumer;

import java.util.regex.Pattern;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.tdp.ms.triajekafka.service.LecturaService;
import com.tdp.ms.triajekafka.service.TdpAveriaService;
import com.tdp.ms.triajekafka.service.TdpTriageService;
import com.tdp.ms.triajekafka.service.impl.LecturaServiceImpl;
import com.tdp.ms.triajekafka.util.Constants;

@EnableAsync
@Component
public class Receiver {

	private static final Logger log = LoggerFactory.getLogger(Receiver.class);

	@Autowired
	LecturaServiceImpl lecturaServiceImpl;

	@KafkaListener(topics = "${application.topic.foo}")
	public void listen(@Payload String message) {
		log.info("received message='{}'", message);
		//message = "ATIS|279636471|2020-09-16|PE|PETICION PENDIENTE              |2020-09-16|2020-09-16|2021-01-06|AGG5730         |A980042         |MILAGROS DEL PILAR CORREA LOPEZ                                 |BAJA APC                                |17635545|00000-                                  |00000-                                  |00000-                                  |00000-                                  |LIMA                |LIMA                |SAN MARTIN DE PORRES|AV  ROSARIO DEL NORTE . CDR:5 MZ :Y1 LT :14 SCT:0|150135   ||ACTIVO    |-77.085131377709|-11.985717091446|                                        |                                        |                                                                                                    |HFC |N|624311100|930101455|";

		lecturaServiceImpl.lectura(message);
	}

}