package com.tdp.ms.triajekafka.external;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.tdp.ms.triajekafka.util.properties.ExternalApi;

@ExtendWith (MockitoExtension.class)
public class AveriasApiTest {
	@Mock
	private static ExternalApi externalApi = new ExternalApi();
	@InjectMocks
	private AveriasApi averiasApi;
	
	@BeforeAll()
	private static void Set_Up() {
		externalApi.setFaultAuthorization("");
		externalApi.setFaultClientId("");
		externalApi.setFaultClientSecret("");
		externalApi.setFaultUrl("");
		externalApi.setInsertFaultFromTriaje("");
	}
	
	@Test
	void api_ok() {
		when(externalApi.getFaultUrl()).thenReturn("https://wa-trazabilidad-msfaults-cert.azurewebsites.net/");
		when(externalApi.getInsertFaultFromTriaje()).thenReturn("fault/insertFaultFromTriaje");
		when(externalApi.getFaultAuthorization()).thenReturn("");
		when(externalApi.getFaultClientId()).thenReturn("");
		when(externalApi.getFaultClientSecret()).thenReturn("");
		
		averiasApi.insertTriage("","","");
	}
	
	
}
