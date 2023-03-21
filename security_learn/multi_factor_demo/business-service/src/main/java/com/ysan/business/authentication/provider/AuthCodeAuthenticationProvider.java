package com.ysan.business.authentication.provider;

import com.ysan.business.authentication.AuthCodeAuthentication;
import com.ysan.business.authentication.facade.AuthenticationServerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @description
 * @since 2023/3/15 17:02
 **/

@Component
public class AuthCodeAuthenticationProvider implements AuthenticationProvider {

    private AuthenticationServerFacade serverFacade;

    public AuthCodeAuthenticationProvider(AuthenticationServerFacade serverFacade){
        this.serverFacade  = serverFacade;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String code = String.valueOf(authentication.getCredentials());

        // 调用认证服务完成认证
        boolean result = serverFacade.checkAuthCode(username, code);

        if (result) {
            return new AuthCodeAuthentication(username, code);
        } else {
            throw new BadCredentialsException("Bad credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return AuthCodeAuthentication.class.isAssignableFrom(authentication);
    }
}
