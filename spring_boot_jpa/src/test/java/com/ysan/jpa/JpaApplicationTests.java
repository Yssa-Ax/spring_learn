package com.ysan.jpa;

import com.ysan.jpa.pojo.Event;
import com.ysan.jpa.service.EventService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;


@SpringBootTest
class JpaApplicationTests {

    @Autowired
    private EventService eventService;


    @Test
    void contextLoads() {
        Event dateEvent = new Event( );
        eventService.add( dateEvent );
    }

}
