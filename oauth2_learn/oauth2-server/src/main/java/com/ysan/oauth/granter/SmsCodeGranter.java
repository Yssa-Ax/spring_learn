package com.ysan.oauth.granter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Administrator
 * @description
 * @since 2023/3/2 14:29
 **/

@Slf4j
public class SmsCodeGranter extends AbstractTokenGranter {

    private static final String GRANT_TYPE = "sms_code";

    protected final AuthenticationManager authenticationManager;


    protected SmsCodeGranter(AuthenticationManager authenticationManager,AuthorizationServerTokenServices tokenServices, ClientDetailsService clientDetailsService, OAuth2RequestFactory requestFactory, String grantType) {
        super(tokenServices, clientDetailsService, requestFactory, grantType);
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {
        Map<String, String> parameters = new LinkedHashMap<>(tokenRequest.getRequestParameters());
        String telePhone = parameters.get("telePhone");
        String code = parameters.get("code");

        // 根据传入的手机号从redis中拿code，比较code是否相等。
        if (!code.equals("123123")){
            throw new InvalidGrantException("短信验证码填写错误。");
        }

        // 根据手机号码查询用户信息：更具实际情况操作 这里只做演示没有数据库访问操作。
        // 模拟查询出来的user
        String user = "ysan";
        if (user == null){
            throw new InvalidGrantException("手机号码填写错误。");
        }

//        Authentication userAuth = new TelePhon

        return null;
    }
}
