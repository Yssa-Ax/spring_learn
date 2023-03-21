package com.ysan.auth.repository;

import com.ysan.auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Administrator
 * @description
 * @since 2023/3/14 17:11
 **/
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUsername(String username);
}
