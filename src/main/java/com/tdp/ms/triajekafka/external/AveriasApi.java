package com.tdp.ms.triajekafka.external;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.tdp.ms.triajekafka.dto.ResponseTriage;
import com.tdp.ms.triajekafka.util.properties.ExternalApi;

@Component
public class AveriasApi {
	
	@Autowired
	private ExternalApi externalApi;
	
	private static final Logger log = LoggerFactory.getLogger(AveriasApi.class);
	final Gson gson = new Gson();
	
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseTriage insertTriage(String data, String status, String orderCode) {
		Client client = Client.create();
		 
		// Para Dev
		WebResource webResource = client.resource(externalApi.getFaultUrl() + externalApi.getInsertFaultFromTriaje()); //System.getenv("TDP_URL_PROVISION_INSERT_ORDER")

		JsonObject request = new JsonObject();
		JsonObject header = new JsonObject();
		JsonObject body = new JsonObject();

		header.addProperty("appName", "APP_FAULT");
		header.addProperty("user", "USER_KAFKA");
		header.addProperty("operation", "OPER_FAULT_UPDATE_FROM_TRIAJE");

		body.addProperty("data", data);
		body.addProperty("status", status);
		body.addProperty("orderCode", orderCode);

		request.add("header", header);
		request.add("body", body);

		String json = gson.toJson(request);		
		String output="";
		try {
			ClientResponse clientResponse = webResource.accept(new String[] { "application/json" })
					.header("Content-type", "application/json").// PARA DEV
					header("Authorization", externalApi.getFaultAuthorization()).// PARA PROD //System.getenv("TDP_PROVISION_AUTHORIZATION")
					header("X-IBM-Client-Id", externalApi.getFaultClientId()). //System.getenv("TDP_IBM_PROVISION_CLIENT_ID")
					header("X-IBM-Client-Secret", externalApi.getFaultClientSecret()).post(ClientResponse.class, json); //System.getenv("TDP_IBM_PROVISION_CLIENT_PWD")
			output = (String) clientResponse.getEntity(String.class);
		} catch (HttpClientErrorException ex) {	
			log.error(this.getClass().getName() + " - Exception: " + ex.getMessage());			

		} catch (Exception ex) {
			log.error(this.getClass().getName() + " - Exception: " + ex.getMessage());
		}
		return gson.fromJson(output, ResponseTriage.class);
	}
	
}