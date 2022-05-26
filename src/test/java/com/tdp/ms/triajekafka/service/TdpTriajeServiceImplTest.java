package com.tdp.ms.triajekafka.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tdp.ms.triajekafka.dto.Header;
import com.tdp.ms.triajekafka.dto.ResponseTriage;
import com.tdp.ms.triajekafka.external.AveriasApi;
import com.tdp.ms.triajekafka.service.impl.TdpTriageServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TdpTriajeServiceImplTest {
	@Mock
    private AveriasApi averiasApi;
	
	@InjectMocks
	private TdpTriageServiceImpl tdpTriajeServiceImpl;
	
	private static ResponseTriage responseTriaje = new ResponseTriage();
	private static  String data = "DATA";
	private static  String status = "STATUS";
	private static  String orderCode = "ORDER_CODE";
	
	@BeforeAll
	public static void SetUp()  throws IOException{
		Header header = new Header();
		header.setAppName("");
		header.setDateTime("");
		header.setMessage("");
		header.setOperation("");
		header.setResultCode("");
		header.getAppName();
		header.getDateTime();
		header.getMessage();
		header.getOperation();
		header.getResultCode();
		responseTriaje.setContent("");
		responseTriaje.setHeader(header);
		responseTriaje.getContent();
		responseTriaje.getHeader();
	
	}
	
	@Test
	void insert_ok() {
		when(averiasApi.insertTriage(ArgumentMatchers.anyString(),ArgumentMatchers.anyString(),ArgumentMatchers.anyString())).thenReturn(responseTriaje);
		//when(averiasApi.insertTriage("","","")).thenReturn(responseTriaje);
		Boolean rpta = tdpTriajeServiceImpl.insertTriage(data,status,orderCode);
		//assertEquals(rpta, true);
		
	}
	
}
