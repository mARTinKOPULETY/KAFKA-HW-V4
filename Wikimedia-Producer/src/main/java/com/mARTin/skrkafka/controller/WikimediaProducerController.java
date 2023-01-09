package com.mARTin.skrkafka.controller;

import com.mARTin.skrkafka.kafka.*;
import org.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/producer")
public class WikimediaProducerController {
    private WikimediaChangesProducer wikimediaChangesProducer;

    public WikimediaProducerController(WikimediaChangesProducer wikimediaChangesProducer) {
        this.wikimediaChangesProducer = wikimediaChangesProducer;
    }
    @GetMapping("/suckin")
    public ResponseEntity<String> suckin(String message) throws InterruptedException {
        wikimediaChangesProducer.sendMessage(message);
        return ResponseEntity.ok("Suckin' data from Wikimedia has started....");
    }

}
