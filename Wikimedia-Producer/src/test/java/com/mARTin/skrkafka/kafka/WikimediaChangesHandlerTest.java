package com.mARTin.skrkafka.kafka;

import com.launchdarkly.eventsource.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.junit.jupiter.*;
import org.springframework.kafka.core.*;
import org.springframework.kafka.test.context.*;
import org.springframework.test.annotation.*;

import java.net.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
@EmbeddedKafka
public class WikimediaChangesHandlerTest {

@Test
    void testOnMessage_whenIsMockedKafkaTamplate_handlerIsNotNull() throws Exception {

    String string = "Sending with our own simple KafkaProducer";
    String url = "https://stream.wikimedia.org/v2/stream/recentchange";
    MessageEvent messageEvent =new MessageEvent("eventName", string, "XXX", URI.create(url));
    String  topic = "spring.kafka.topic.name";

    KafkaTemplate<String, String> templateMock = mock(KafkaTemplate.class);
    WikimediaChangesHandler handler = new WikimediaChangesHandler(templateMock,topic);
    WikimediaChangesHandler handler1 = handler;

    handler1.onMessage("event",messageEvent);

    assertThat(handler1).isNotNull();

}
}
