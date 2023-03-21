package com.ysan.security.service;

import com.ysan.security.domain.User;
import com.ysan.security.repository.UserRepository;
import com.ysan.security.user.model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

/**
 * @author Administrator
 * @description
 * @since 2023/3/10 15:36
 **/
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> s = () -> new UsernameNotFoundException("Username" + username + "is invalid!");

        User u = userRepository.findUserByUsername(username).orElseThrow(s);
        return new CustomUserDetails(u);
    }
}
