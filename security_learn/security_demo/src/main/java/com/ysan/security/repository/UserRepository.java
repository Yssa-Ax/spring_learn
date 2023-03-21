package com.ysan.security.repository;

import com.ysan.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Administrator
 * @description
 * @since 2023/3/7 10:15
 **/
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUsername(String username);
}
