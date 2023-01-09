package com.mARTin.skrkafka.controller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit.jupiter.*;
import org.springframework.test.context.web.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.web.context.*;

//@ContextConfiguration(classes=WikimediaProducerController.class)
/*@AutoConfigureMockMvc
@SpringBootTest(classes=WikimediaProducerController.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)*/



public class WikimediaControllerIntegrationTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Test
    void contextLoads(){

    }



}
