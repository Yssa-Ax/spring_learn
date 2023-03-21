package com.ysan.jwt;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Calendar;
import java.util.HashMap;

@SpringBootTest
class JwtApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    public void testGenerateToken() {
        // 指定token过期时间为10秒
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 30);

        String token = JWT.create()
                .withHeader(new HashMap<>())     // Header
                .withClaim("userId", 21)   // Payload
                .withClaim("userName", "baobao")
                .withExpiresAt(calendar.getTime())  // 过期时间
                .sign(Algorithm.HMAC256("!34ADAS"));// 签名用的secret

        System.out.println(token);
    }



    @Test
    public void testResolveToken(){
        // 创建解析对象，使用算法和secret要与token时保持一致
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("!34ADAS")).build();
        // 解析指定的token
        DecodedJWT decodedJWT = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6ImJhb2JhbyIsImV4cCI6MTY3NzYzOTk2OSwidXNlcklkIjoyMX0.JRvbyhooD4BX7xUaqRI3u2wM52Xi-LSVslkER4UlDaA");
        // 获取解析后的token的payload信息
        Claim userId = decodedJWT.getClaim("userId");
        Claim userName = decodedJWT.getClaim("userName");
        System.out.println(userId.asInt());
        System.out.println(userName.asString());
        // 输出超时时间
        System.out.println(decodedJWT.getExpiresAt());
    }


    @Test
    public void huTool() {
        RSA rsa = new RSA(null,"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCblUli2JAIY/TOV9dOIhi6l4ZVHCp0WNhog9aIGhHRSN63eeQV+qsV1WMewTZkBgh+x9KSTQ1il1HlbZX/b/S7JKTmUGGN3sMxBoD2xl3NvlE46JCcNuPPzhwiJLATAvkxhlNsDHU3yuBjb51CVl4cThp/1KquPG0O6eirO1qE6QIDAQAB\n");
        RSAPublicKey publicKey = (RSAPublicKey) rsa.getPublicKey();
        System.out.println(JSONUtil.toJsonStr(publicKey));


    }

    @Test
    public void rsaPriPub(){
        // 用hutool RSA 可以生成公钥密钥
        RSA rsa = new RSA();
        System.out.println(rsa.getPublicKeyBase64());
        System.out.println(rsa.getPrivateKeyBase64());
    }

}
