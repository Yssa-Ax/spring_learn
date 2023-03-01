package com.ysan.jpa.repository.example8;

import com.ysan.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Administrator
 * @description
 * @since 2023/2/9 16:00
 **/
public interface MyRepository extends JpaRepository<User, Long> {
}
