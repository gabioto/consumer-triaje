package com.tdp.ms.triajekafka.service;

import static org.mockito.Mockito.doNothing;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tdp.ms.triajekafka.model.AveriaKafka;
import com.tdp.ms.triajekafka.repository.TdpAveriaRepository;
import com.tdp.ms.triajekafka.service.impl.TdpAveriaServiceImpl;
import com.tdp.ms.triajekafka.util.Constants;

@ExtendWith (MockitoExtension.class)
public class TdpAveriaServiceImplTest {
	public static AveriaKafka averiaKafka = new AveriaKafka();
	private static final String data = "WHATSAPP_REQUEST";
	private static final String dateKafka = "SMS_REQUEST";
	private static final String xaRequest = "XA_REQUEST";
	private static final String status = "STATUS";
	private static final String masive = "MASIVE";
	private static final String bandeja = "BANDEJA";
	private static final String motivo = "MOTIVO";
	private static final String idServicio = "ID_SERVICE";
	
	@Mock
	private TdpAveriaRepository tdpAveriaRepository;
	
	@InjectMocks
	private TdpAveriaServiceImpl tdpAveriaServiceImpl;
	
	@BeforeAll
	static void SetUp() {
		averiaKafka.setBandeja("bandeja");
		averiaKafka.setData("data");
		averiaKafka.setDateKafka("date_kafka");
		averiaKafka.setIdServicio("id");
		averiaKafka.setIdTriageKafka("idtriaje");
		averiaKafka.setMasive("masive");
		averiaKafka.setMotivo("motive");
		averiaKafka.setRegisterDate(LocalDateTime.now());
		averiaKafka.setSeq(112341834);
		averiaKafka.setStatus(Constants.STATUS_PENDIENTE+Constants.STATUS_LIQUIDADO);
		averiaKafka.setXaRequest("xa_34023");
		
		averiaKafka.getBandeja();
		averiaKafka.getData();
		averiaKafka.getDateKafka();
		averiaKafka.getIdServicio();
		averiaKafka.getIdTriageKafka();
		averiaKafka.getMasive();
		averiaKafka.getMotivo();
		averiaKafka.getRegisterDate();
		averiaKafka.getSeq();
		averiaKafka.getStatus();
		averiaKafka.getXaRequest();
	}
	
	@Test
	public void insert_ok() {
		doNothing().when(tdpAveriaRepository).insertTopic(ArgumentMatchers.any());
		tdpAveriaServiceImpl.insertProvisionTopic(data, dateKafka, xaRequest,status,masive,bandeja, motivo, idServicio);
	}
}
