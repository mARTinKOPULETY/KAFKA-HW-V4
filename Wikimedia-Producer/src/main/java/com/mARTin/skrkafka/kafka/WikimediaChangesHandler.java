package com.mARTin.skrkafka.kafka;

import com.launchdarkly.eventsource.*;
import org.jetbrains.annotations.*;
import org.slf4j.Logger;
import org.slf4j.*;
import org.springframework.kafka.core.*;
import org.springframework.stereotype.*;

@Component
public class WikimediaChangesHandler implements EventHandler {
    private static  final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesHandler.class);
    private KafkaTemplate<String, String> kafkaTemplate;
    private  String topic;

    public WikimediaChangesHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }
    @Override
    public void onMessage(String event, @NotNull MessageEvent messageEvent) throws Exception {
        LOGGER.info(String.format("event data -> %s \n topic: %s", messageEvent.getData(), topic));
        kafkaTemplate.send(topic, messageEvent.getData());
    }

    @Override
    public void onOpen() throws Exception {
    }

    @Override
    public void onClosed() throws Exception {
    }

    @Override
    public void onComment(String comment) throws Exception {
    }

    @Override
    public void onError(Throwable t) {
    }

}
