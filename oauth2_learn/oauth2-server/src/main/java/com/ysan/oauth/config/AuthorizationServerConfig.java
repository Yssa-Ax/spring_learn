package com.ysan.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenGranter;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeTokenGranter;
import org.springframework.security.oauth2.provider.implicit.ImplicitTokenGranter;
import org.springframework.security.oauth2.provider.password.ResourceOwnerPasswordTokenGranter;
import org.springframework.security.oauth2.provider.refresh.RefreshTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.sql.DataSource;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @description 授权服务器配置
 * @since 2023/3/2 11:11
 **/
@Configuration
// 在实现类上加注解 标识这是一个授权服务器
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JksProperties jksProperties;

    @Autowired
    private AuthenticationManager authenticationManager;


    /**
     *
     * @param clients [null]
     * @return void
     * @since 2023/3/2 11:30
     * @author Administrator
     * @description 用来配置客户端详情服务(ClientDetailsService),允许客户端自己申请ClientID
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource);
    }

    
    /**
     * 
     * @param security [null] 
     * @return void
     * @since 2023/3/2 11:34
     * @author Administrator
     * @description 用来配置令牌端点的安全约束。允许ClientSecret明文方式保存并且可以通过表单提交
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("permitAll()").allowFormAuthenticationForClients().passwordEncoder(NoOpPasswordEncoder.getInstance());
    }


    
    /**
     * 
     * @param endpoints [null] 
     * @return void
     * @since 2023/3/2 11:55
     * @author Administrator
     * @description 用来配置令牌(token)的访问端点和令牌服务(tokenservices)
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        // 添加自定义 token增强
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), jwtTokenEnhancer()));
        // 初始化所有的TokenGranter, 并且类型为CompositeTokenGranter


    }



    /**
     *
     * @return org.springframework.security.oauth2.provider.token.TokenEnhancer
     * @since 2023/3/2 14:10
     * @author Administrator
     * @description 自定义的Token增强器，把更多信息加入Token中
     */
    @Bean
    public TokenEnhancer tokenEnhancer(){
        return new EnhanceTokenEnhancer();
    }



    /**
     *
     * @return org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
     * @since 2023/3/2 14:11
     * @author Administrator
     * @description 配置JWT令牌使用非对称加密方式来验证
     */
    @Bean
    protected JwtAccessTokenConverter jwtTokenEnhancer() {
        // 设置jwt的转换器
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();

        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(
                // 设置加密的加载文件
                new ClassPathResource(jksProperties.getName()),
                // 设置读取密钥文件的密码
                jksProperties.getStorePassword().toCharArray()
        );
        // 设置获取秘钥的密码
//        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(jksProperties.getAlias());
        // 设置获取秘钥的密码
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair("jwt");
        // 设置秘钥对象
        converter.setKeyPair(keyPair);
        return converter;
    }


    private List<TokenGranter> getDefaultTokenGranters(AuthorizationServerEndpointsConfigurer endpoints) {
        ClientDetailsService clientDetails = endpoints.getClientDetailsService();
        AuthorizationServerTokenServices tokenServices = endpoints.getTokenServices();
        AuthorizationCodeServices authorizationCodeServices = endpoints.getAuthorizationCodeServices();
        OAuth2RequestFactory requestFactory = endpoints.getOAuth2RequestFactory();

        List<TokenGranter> tokenGranters = new ArrayList<TokenGranter>();
        tokenGranters.add(new AuthorizationCodeTokenGranter(tokenServices, authorizationCodeServices, clientDetails, requestFactory));
        tokenGranters.add(new RefreshTokenGranter(tokenServices, clientDetails, requestFactory));
        ImplicitTokenGranter implicit = new ImplicitTokenGranter(tokenServices, clientDetails, requestFactory);
        tokenGranters.add(implicit);
        tokenGranters.add(new ClientCredentialsTokenGranter(tokenServices, clientDetails, requestFactory));

        if (authenticationManager != null) {
            tokenGranters.add(new ResourceOwnerPasswordTokenGranter(authenticationManager, tokenServices, clientDetails, requestFactory));
//            tokenGranters.add(new())
        }

        return tokenGranters;

    }
    
}
