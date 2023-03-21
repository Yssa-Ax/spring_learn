package com.ysan.jpa.repository.example8;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Administrator
 * @description
 * @since 2023/2/9 16:05
 **/
@NoRepositoryBean
public interface MyBaseRepository<T, ID> extends JpaRepository<T, ID> {
}
