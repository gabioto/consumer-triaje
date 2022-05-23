package com.tdp.ms.triajekafka.expose;

import com.tdp.ms.triajekafka.business.TriajekafkaService;
import com.tdp.ms.triajekafka.model.TriajekafkaRequest;
import com.tdp.ms.triajekafka.model.TriajekafkaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Class: TriajekafkaController. <br/>
 * <b>Copyright</b>: &copy; 2019 Telef&oacute;nica del Per&uacute;<br/>
 * <b>Company</b>: Telef&oacute;nica del Per&uacute;<br/>
 *
 * @author Telef&oacute;nica del Per&uacute; (TDP) <br/>
 *         <u>Service Provider</u>: Everis Per&uacute; SAC (EVE) <br/>
 *         <u>Developed by</u>: <br/>
 *         <ul>
 *         <li>Developer name</li>
 *         </ul>
 *         <u>Changes</u>:<br/>
 *         <ul>
 *         <li>YYYY-MM-DD Creaci&oacute;n del proyecto.</li>
 *         </ul>
 * @version 1.0
 */
@RestController
@RequestMapping("/triajekafka/v1/greeting")
public class TriajekafkaController {

    @Autowired
    private TriajekafkaService triajekafkaService;

    @GetMapping
    public Mono<TriajekafkaResponse> indexGet() {
        return Mono.justOrEmpty(this.triajekafkaService.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TriajekafkaResponse> indexPost(@RequestBody TriajekafkaRequest request) {
        return Mono.justOrEmpty(this.triajekafkaService.put(request.getName()));
    }

}
