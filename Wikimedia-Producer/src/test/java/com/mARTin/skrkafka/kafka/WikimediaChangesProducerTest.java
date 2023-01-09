package com.mARTin.skrkafka.kafka;

import com.launchdarkly.eventsource.*;
import com.mARTin.skrkafka.*;
import com.mARTin.skrkafka.entity.*;
import org.apache.kafka.clients.producer.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.core.*;
import org.springframework.kafka.test.context.*;
import org.springframework.test.annotation.*;
import org.springframework.test.context.*;
import java.net.*;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DirtiesContext
@EmbeddedKafka
public class WikimediaChangesProducerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducerTest.class);
    @Value("${spring.kafka.topic.name}")
    private String topic;
    KafkaTemplate<String, String> kafkaTemplate;
    @InjectMocks
    WikimediaChangesProducer producer = new WikimediaChangesProducer(kafkaTemplate);

    @Mock
    WikimediaChangesHandler handler = new WikimediaChangesHandler(kafkaTemplate, topic);

    @Mock
    KafkaDatabaseConsumer consumer = new KafkaDatabaseConsumer();
/*    @Test
    void  testSendMessage_shouldProduceData()throws Exception {
        List<WikimediaData> list = new ArrayList();
        String eventName= "eventName";
        String string = "Sending with our own simple KafkaProducer";
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";

        MessageEvent messageEvent =new MessageEvent("d", string, "c",URI.create(url));
        System.out.println("XXX\nXXX\nXXX\nXXX\nXxx\n"+messageEvent);
        System.out.println( messageEvent.getData());
        EventHandler eventHandler =  wikimediaChangesHandler;

//        when(handler.onMessage(topic, messageEvent)).thenReturn(messageEvent);
//        wikimediaChangesProducer.sendMessage(string);
      wikimediaChangesHandler.onMessage(topic, messageEvent);

//        assertThat(kafkaDatabaseConsumer.getList().toString(), containsString(string));

    }*/
/*
    @Test
    void testovatko() throws Exception {
        String eventName= "eventName";
        String string = "Sending with our own simple KafkaProducer";
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";

        MessageEvent messageEvent =new MessageEvent("d", string, "c",URI.create(url));
//      WikimediaChangesHandler handler =mock(WikimediaChangesHandler.class);
        producer = mock(WikimediaChangesProducer.class);
      verify(producer, times(1)).sendMessage(string);

//        lenient().doNothing().when(wikimediaChangesProducer).sendMessage(string);


//        assertEquals(expectedHandler.toString(),eventHandler.toString());
//        System.out.println("SDFGHJKLPOIUYRTYUIUYTRTYUI" + eventHandler);
//        String  message= "xxx";
//        wikimediaChangesProducer.sendMessage(message);
    }*/
    @Test
    void testSendMessage_whenProducerIsCalled_producerIsNotNull() throws InterruptedException {
        String message = "ABCD";
        WikimediaChangesProducer producer1 = producer;

        producer1.sendMessage(message);

        assertThat(producer1).isNotNull();
    }
    @Test
    void testSendMessage_whenEventHandlerIsCalled_eventHandlerIsNotNull()  {
        EventHandler mockEventHandler = mock(EventHandler.class);

        assertThat( mockEventHandler).isNotNull();
    }

}
