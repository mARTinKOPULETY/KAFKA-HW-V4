package com.mARTin.skrkafka;


import com.mARTin.skrkafka.entity.*;
import org.slf4j.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class KafkaDatabaseConsumer {
    private List<WikimediaData> list = new ArrayList();
    private static  final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    private  Long idCounter=1L;

    @KafkaListener(
            topics="${spring.kafka.topic.name}",
            groupId="myGroup")
    public  void  consume(String eventMessage){
        list.add(new WikimediaData(idCounter,eventMessage));
        LOGGER.info(String.format("Message recieved -> %s", eventMessage));
        idCounter++;
    }

    public List<WikimediaData> getList() {
        return list;
    }
    public List<WikimediaData> getFilteredList(){

        List<WikimediaData> filteredList= list
                .stream()
                .filter(language->language.getWikiEventData()
                        .contains("https://cs.wikipedia.org"))
                .collect(Collectors.toList());

        return filteredList;
    }



}
