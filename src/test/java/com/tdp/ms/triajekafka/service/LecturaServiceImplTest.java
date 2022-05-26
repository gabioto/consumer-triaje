package com.tdp.ms.triajekafka.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.tdp.ms.triajekafka.service.impl.LecturaServiceImpl;



@ExtendWith (MockitoExtension.class)
public class LecturaServiceImplTest {
	@InjectMocks 
	LecturaServiceImpl lecturaServiceImpl;
	
	@Mock
	TdpTriageService tdpTriageService;
	
	@Mock
	TdpAveriaService tdpAveriaService;
	
	private static final String MESSAGE_TRIAJE_PENDIENTE = "MESSAGE_TRIAJE_PENDIENTE";
	private static final String MESSAGE_TRIAJE_LIQUIDADO = "MESSAGE_TRIAJE_LIQUIDADO";
	private static final String MESSAGE_OTHER_STATUS = "MESSAGE_OTHER_STATUS";
	private static final String MESSAGE_ERROR = "MESSAGE_ERROR";
	
	public static Map<String,String> ticketKafkaMap = new HashMap<>();
	@BeforeAll
	public static void SetUp() {
		String message_triaje_pendiente = "TRIAJE|24044946|18004257|PENDIENTE|CUARENTENA ATENTO|PENDIENTE|ASIGNADO|CLIENTES CRITICOS|TITULAR SOLICITA ATENCION DE UN TECNICO  966652835|966652835|966652835|966652835|HFC|35 Mbps|12466461|12466461|5476045|LINEA TARIFA PLANA|LINEA TARIFA PLANA - II|17/06/2020 11:12|17/06/2020 11:13||NO|PENDIENTE|PENDIENTE|DNI|22422946|SONIA ROSSELLY, VILLAORDUNA CRUZ|||jlchaveza@grupodelaware.com|966652835|||CHORRILLOS|LIMA|LIMA|CAL LA ENCANTADA 159 INT:301 UR :UR MARTIR JOSE OLAYA||1-996299511||17/06/2020|11:16:47|CUARENTENA ATEN|17/06/2020|11:21:48|CUARENTENA ATEN||||||||||||||||||||||||||||||||";
		String message_triaje_liquidado = "TRIAJE|24044946|18004257|LIQUIDADO|CUARENTENA ATENTO|PENDIENTE|ASIGNADO|CLIENTES CRITICOS|TITULAR SOLICITA ATENCION DE UN TECNICO  966652835|966652835|966652835|966652835|HFC|35 Mbps|12466461|12466461|5476045|LINEA TARIFA PLANA|LINEA TARIFA PLANA - II|17/06/2020 11:12|17/06/2020 11:13||NO|PENDIENTE|PENDIENTE|DNI|22422946|SONIA ROSSELLY, VILLAORDUNA CRUZ|||jlchaveza@grupodelaware.com|966652835|||CHORRILLOS|LIMA|LIMA|CAL LA ENCANTADA 159 INT:301 UR :UR MARTIR JOSE OLAYA||1-996299511||17/06/2020|11:16:47|CUARENTENA ATEN|17/06/2020|11:21:48|CUARENTENA ATEN||||||||||||||||||||||||||||||||";
		String message_other_status = "TRIAJE_OTHER|24044946|18004257||CUARENTENA ATENTO|PENDIENTE|ASIGNADO|CLIENTES CRITICOS|TITULAR SOLICITA ATENCION DE UN TECNICO  966652835|966652835|966652835|966652835|HFC|35 Mbps|12466461|12466461|5476045|LINEA TARIFA PLANA|LINEA TARIFA PLANA - II|17/06/2020 11:12|17/06/2020 11:13||NO|PENDIENTE|PENDIENTE|DNI|22422946|SONIA ROSSELLY, VILLAORDUNA CRUZ|||jlchaveza@grupodelaware.com|966652835|||CHORRILLOS|LIMA|LIMA|CAL LA ENCANTADA 159 INT:301 UR :UR MARTIR JOSE OLAYA||1-996299511||17/06/2020|11:16:47|CUARENTENA ATEN|17/06/2020|11:21:48|CUARENTENA ATEN||||||||||||||||||||||||||||||||";
		String message_error = "TRIAJE_OTHER|24044946|18004257||CUARENTENA ATENTO|PENDIENTE|ASIGNADO|CLIENTES CRITICOS|TITULAR SOLICITA ATENCION DE UN TECNICO  966652835|966652835|966652835|966652835|HFC|35 Mbps|12466461|12466461|5476045|LINEA TARIFA PLANA|LINEA TARIFA PLANA - II|17/06/2020 11:12|17/06/2020 11:13||NO|PENDIENTE|PENDIENTE|DNI|22422946|SONIA ROSSELLY, VILLAORDUNA CRUZ|";

		ticketKafkaMap.put(MESSAGE_TRIAJE_PENDIENTE, message_triaje_pendiente);
		ticketKafkaMap.put(MESSAGE_TRIAJE_LIQUIDADO, message_triaje_liquidado);
		ticketKafkaMap.put(MESSAGE_OTHER_STATUS, message_other_status);
		ticketKafkaMap.put(MESSAGE_ERROR, message_error);
	}
	
	@Test
	public void Lectura_ok() {
		when(tdpTriageService.insertTriage(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(true);
		doNothing().when(tdpAveriaService).insertProvisionTopic(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString());
		lecturaServiceImpl.lectura(ticketKafkaMap.get(MESSAGE_TRIAJE_PENDIENTE));
		lecturaServiceImpl.lectura(ticketKafkaMap.get(MESSAGE_OTHER_STATUS));
		lecturaServiceImpl.lectura(ticketKafkaMap.get(MESSAGE_TRIAJE_LIQUIDADO));
	}
	
	@Test
	public void Lectura_error() {
		//doNothing().when(tdpAveriaService).insertProvisionTopic(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString());
		lecturaServiceImpl.lectura(ticketKafkaMap.get(MESSAGE_ERROR));
		
	}
	
}
