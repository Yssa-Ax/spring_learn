package com.ysan.oauth.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @description 自定义token增强器，作用可以在jwt中添加自定义信息
 * @since 2023/3/2 13:24
 **/
public class EnhanceTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Authentication userAuthentication = oAuth2Authentication.getUserAuthentication();
        if (userAuthentication != null){
            Object principal = userAuthentication.getPrincipal();
            // 把用户标识以userDetails这个key加入到JWT的额外信息中去
            Map<String, Object> additionalInfo = new HashMap<String, Object>();
            additionalInfo.put("userDetails", principal);
            additionalInfo.put("ysan", "ysan");
            ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        }
        return oAuth2AccessToken;
    }
}
