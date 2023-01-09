package com.mARTin.skrkafka.controller;

import com.mARTin.skrkafka.*;
import com.mARTin.skrkafka.entity.*;
import org.apache.kafka.clients.producer.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/consumer")
public class WikimediaConsumerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    @Autowired
    private KafkaDatabaseConsumer kafkaDatabaseConsumer;

    @GetMapping
    public List<WikimediaData> sendData(){
        List<WikimediaData> list =  kafkaDatabaseConsumer.getFilteredList();
//        LOGGER.info(String.format("GET FILTERED LIST" + kafkaDatabaseConsumer.getFilteredList()));
     return list ;

    }

}
