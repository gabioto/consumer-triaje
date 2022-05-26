package com.tdp.ms.triajekafka.consumer;

import static org.mockito.Mockito.doNothing;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tdp.ms.triajekafka.service.impl.LecturaServiceImpl;


@ExtendWith(MockitoExtension.class)
public class ReceiverTest {
	@InjectMocks
	private Receiver receiverKafkaListener;

	@Mock
	private LecturaServiceImpl lecturaServiceImpl;
	
	
	@Test
	public void listenFirstOK() throws Exception {
		
		doNothing().when(lecturaServiceImpl).lectura(ArgumentMatchers.anyString());

		receiverKafkaListener.listen("Prueba1");
	}
	
	
}
