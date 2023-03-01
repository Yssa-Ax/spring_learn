package com.ysan.jpa.client;

import com.ysan.jpa.entity.Person;
import com.ysan.jpa.service.PersonRepository;

import java.util.List;

/**
 * @author Administrator
 * @description
 * @since 2023/2/9 11:16
 **/
public class SomeClient {
    private final PersonRepository repository;

    SomeClient(PersonRepository repository) {
        this.repository = repository;
    }

    void doSomething() {
        List<Person> matthews = repository.findByLastName("Matthews");
    }
}
