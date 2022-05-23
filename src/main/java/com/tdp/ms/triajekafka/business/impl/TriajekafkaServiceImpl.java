package com.tdp.ms.triajekafka.business.impl;

import com.tdp.ms.triajekafka.business.TriajekafkaService;
import com.tdp.ms.triajekafka.model.TriajekafkaResponse;
import org.springframework.stereotype.Service;

/**
 * Class: TriajekafkaServiceImpl. <br/>
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
@Service
public class TriajekafkaServiceImpl implements TriajekafkaService {

    @Override
    public TriajekafkaResponse get() {
        return new TriajekafkaResponse("Hello world!");
    }

    @Override
    public TriajekafkaResponse put(String name) {
        return new TriajekafkaResponse(name + " created!");
    }

}
