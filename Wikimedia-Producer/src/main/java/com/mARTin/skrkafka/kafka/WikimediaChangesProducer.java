package com.mARTin.skrkafka.kafka;

import com.launchdarkly.eventsource.*;
import org.apache.kafka.clients.producer.*;
import org.slf4j.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.*;
import org.springframework.stereotype.*;

import java.net.*;
@Service
public class WikimediaChangesProducer {
    @Value("${spring.kafka.topic.name}")
    private String topicName;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate;
    public  WikimediaChangesProducer (KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message)throws InterruptedException {
            // to read realtime  stream data  from wikimdia ,  use event source
            EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topicName);
            String url = "https://stream.wikimedia.org/v2/stream/recentchange";
            EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
            EventSource eventSource = builder.build();

            eventSource.start();
            Thread.sleep(15_000);
            eventSource.close();

            LOGGER.info(String.format("\"Suckin' data from Wikimedia has been finished."));
        }
    }


