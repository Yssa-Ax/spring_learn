package com.ysan.jpa.repository.example9;

import com.ysan.jpa.entity.User;
import org.springframework.data.repository.Repository;

/**
 * @author Administrator
 * @description
 * @since 2023/2/9 16:12
 **/
public interface AmbiguousRepository extends Repository<User, Long> {
}
