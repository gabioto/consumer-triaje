package com.tdp.ms.triajekafka.util.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "external.api")
public class ExternalApi {

	String faultUrl;
	String insertFaultFromTriaje;
	String faultClientId;
	String faultClientSecret;
	String faultAuthorization;
}
