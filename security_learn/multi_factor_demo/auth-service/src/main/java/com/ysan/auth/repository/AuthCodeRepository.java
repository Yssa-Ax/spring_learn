package com.ysan.auth.repository;

import com.ysan.auth.domain.AuthCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Administrator
 * @description
 * @since 2023/3/14 17:12
 **/
public interface AuthCodeRepository extends JpaRepository<AuthCode, Integer> {
    Optional<AuthCode> findAuthCodeByUsername(String username);
}
