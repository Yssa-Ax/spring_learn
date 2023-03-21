package com.ysan.jpa.repository.example9;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Administrator
 * @description
 * @since 2023/2/9 16:13
 **/
@NoRepositoryBean
public interface MyBaseRepository<T, ID> extends CrudRepository<T, ID> {
}
