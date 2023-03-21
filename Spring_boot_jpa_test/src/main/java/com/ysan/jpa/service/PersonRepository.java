package com.ysan.jpa.service;

import com.ysan.jpa.entity.EmailAddress;
import com.ysan.jpa.entity.Person;
import com.ysan.jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author Administrator
 * @description
 * @since 2023/2/9 10:51
 **/
interface PersonRepository extends CrudRepository<Person, Long>, CustomizedUserRepository {

    List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);

    // Enables the distinct flag for the query
    List<Person> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
    List<Person> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);

    // Enabling ignoring case for an individual property
    List<Person> findByLastnameIgnoreCase(String lastname);
    // Enabling ignoring case for all suitable properties
    List<Person> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);

    // Enabling static ORDER BY for a query
    List<Person> findByLastnameOrderByFirstnameAsc(String lastname);
    List<Person> findByLastnameOrderByFirstnameDesc(String lastname);

    Page<User> findByLastname1(String lastname, Pageable pageable);

    Slice<User> findByLastname2(String lastname, Pageable pageable);

    List<User> findByLastname3(String lastname, Sort sort);

    List<User> findByLastname4(String lastname, Pageable pageable);


}


