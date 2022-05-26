package com.tdp.ms.triajekafka.consumer;

import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.util.ReflectionTestUtils;


public class ReceiverConfigTest {
	@InjectMocks
	private static ReceiverConfig kafkaReceiverConfig = new ReceiverConfig();


	@BeforeAll
	public static void mensaje() throws IOException {
		ReflectionTestUtils.setField(kafkaReceiverConfig, "bootstrapServers", "abc");
		ReflectionTestUtils.setField(kafkaReceiverConfig, "groupId", "cde");
		ReflectionTestUtils.setField(kafkaReceiverConfig, "autoOffsetReset", "fgh");
	}

	
	@Test
	void consumerFactory2() {
		
		kafkaReceiverConfig.consumerFactory();
		kafkaReceiverConfig.kafkaListenerContainerFactory();

	}
}
