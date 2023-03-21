package com.ysan.jpa.service.impl;

import com.ysan.jpa.pojo.Event;
import com.ysan.jpa.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * @author Administrator
 * @description
 * @since 2023/2/7 10:14
 **/
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void add(Event event) {
        Event dateEvent = new Event( );
        entityManager.persist( dateEvent );
    }
}
