package com.tdp.ms.triajekafka.expose;

import com.tdp.genesis.core.constants.HttpHeadersKey;
import com.tdp.ms.triajekafka.model.TriajekafkaRequest;
import com.tdp.ms.triajekafka.model.TriajekafkaResponse;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;


@SpringBootTest
@AutoConfigureWebTestClient(timeout = "20000")
public class TriajekafkaControllerTest {

    private static final String POST = "post";
    private static final String GENESIS = "genesis";
    private static final String UUID = "550e8400-e29b-41d4-a716-446655440000";

    @Autowired
    private WebTestClient webClient;

    private static Map<String, TriajekafkaResponse> triajekafkaResponseMap = new HashMap<>();
    private static Map<String, TriajekafkaRequest> triajekafkaRequestMap = new HashMap<>();

    @BeforeAll
    public static void setUp() {
        triajekafkaResponseMap.put("get", new TriajekafkaResponse("Hello world!"));
        triajekafkaResponseMap.put(POST, new TriajekafkaResponse("User created!"));
        triajekafkaRequestMap.put(POST, new TriajekafkaRequest("User"));
        triajekafkaRequestMap.put("empty", new TriajekafkaRequest(""));
    }

    @Test
    public void indexGetTest() {
        this.webClient.get()
            .uri("/triajekafka/v1/greeting")
            .accept(MediaType.APPLICATION_JSON)
            .header(HttpHeadersKey.UNICA_SERVICE_ID,UUID)
            .header(HttpHeadersKey.UNICA_APPLICATION,GENESIS)
            .header(HttpHeadersKey.UNICA_PID,UUID)
            .header(HttpHeadersKey.UNICA_USER,GENESIS)
            .header("ClientId","12122322")
            .exchange()
            .expectStatus().isOk()
            .expectBody(TriajekafkaResponse.class)
            .isEqualTo(triajekafkaResponseMap.get("get"));
    }

    @Test
    public void indexPostTest() {
        this.webClient.post()
            .uri("/triajekafka/v1/greeting")
            .accept(MediaType.APPLICATION_JSON)
            .header(HttpHeadersKey.UNICA_SERVICE_ID,UUID)
            .header(HttpHeadersKey.UNICA_APPLICATION,GENESIS)
            .header(HttpHeadersKey.UNICA_PID,UUID)
            .header(HttpHeadersKey.UNICA_USER,GENESIS)
            .body(BodyInserters.fromValue(triajekafkaRequestMap.get(POST)))
            .exchange()
            .expectStatus().isEqualTo(HttpStatus.CREATED)
            .expectBody(TriajekafkaResponse.class)
            .isEqualTo(triajekafkaResponseMap.get(POST));
    }

}
