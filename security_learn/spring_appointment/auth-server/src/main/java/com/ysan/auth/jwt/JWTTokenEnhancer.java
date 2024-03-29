package com.ysan.auth.jwt;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @description
 * @since 2023/3/20 11:54
 **/
public class JWTTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String, Object> systemInfo = new HashMap<String, Object>();
        systemInfo.put("system", "Appointment System");
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(systemInfo);
        return oAuth2AccessToken;
    }
}
