package com.mARTin.skrkafka.controller;


import com.mARTin.skrkafka.kafka.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.kafka.core.*;
import org.springframework.test.context.*;
import org.springframework.test.web.servlet.*;
import org.springframework.web.context.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@ContextConfiguration(classes=WikimediaProducerController.class)
public class WikimediaControllerTest {



    @Autowired
     private MockMvc mockMvc;

    @Test
     public void testWikimediaProducerController_suckin_shouldSendMessage() throws Exception {
        String expectedMessage="Suckin' data from Wikimedia has started....";

        ResultActions resultActions =  mockMvc.perform(get("/api/v1/producer/suckin"))
                .andDo(print())
                .andExpect(status().isOk()) ;

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        assertEquals(expectedMessage,contentAsString);

    }


}
