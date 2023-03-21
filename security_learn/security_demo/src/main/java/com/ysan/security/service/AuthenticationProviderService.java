package com.ysan.security.service;

import com.ysan.security.user.model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @description
 * @since 2023/3/7 11:50
 **/
@Service
public class AuthenticationProviderService implements AuthenticationProvider {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;




    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // 根据用户名从数据中获取 CustomUserDetails
        CustomUserDetails user = customUserDetailsService.loadUserByUsername(username);

        // 根据所配置的密码加密算法分别验证用户秘密
        switch (user.getUser().getPasswordEncoderType()){
            case BCRYPT:
                return checkPassword(user, password, new BCryptPasswordEncoder());
            case SCRYPT:
                return checkPassword(user, password, new SCryptPasswordEncoder());
        }
        throw new BadCredentialsException("Bad credentials");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }


    private Authentication checkPassword(CustomUserDetails user, String rawPassword, PasswordEncoder encoder){
        if (encoder.matches(rawPassword, user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
        }else {
            throw new BadCredentialsException("Bad credentials");
        }
    }
}
