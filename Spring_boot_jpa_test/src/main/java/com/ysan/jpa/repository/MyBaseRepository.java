package com.ysan.jpa.repository;

import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * @author Administrator
 * @description
 * @since 2023/2/9 15:11
 **/
public interface MyBaseRepository<T, ID> extends Repository<T, ID> {
    Optional<T> findById(ID id);

    <S extends T> S save(S entity);
}
