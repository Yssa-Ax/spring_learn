package com.ysan.business.authentication.provider;

import com.ysan.business.authentication.UsernamePasswordAuthentication;
import com.ysan.business.authentication.facade.AuthenticationServerFacade;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


/**
 * @author Administrator
 * @description
 * @since 2023/3/15 13:38
 **/

@Component
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    private AuthenticationServerFacade serverFacade;

    public UsernamePasswordAuthenticationProvider(AuthenticationServerFacade serverFacade){
        this.serverFacade  = serverFacade;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());

        // 调用认证服务完成认证
        serverFacade.checkPassword(username, password);
        return new UsernamePasswordAuthenticationToken(username, password);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthentication.class.isAssignableFrom(authentication);
    }
}
