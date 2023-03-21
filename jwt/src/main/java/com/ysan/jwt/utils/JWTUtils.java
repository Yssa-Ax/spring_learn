package com.ysan.jwt.utils;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.RSA;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Calendar;
import java.util.Map;

/**
 * @author Administrator
 * @description
 * @since 2023/3/1 11:10
 **/
public class JWTUtils {
    // 签名密钥
    private static final String SECRET = "!DAR$";

    private static String RSA_PRIVATE_KEY = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKjzQ89akqiU+n6cOyEUZKIzH75s1aw6+mxAmfb7ON3j/P/QGm7ofz7uMFolnKRIMJ9p0MipO10ORoF631iJptZ+ac8r8730U9R6kBU5M+1FMsnCJ/0cDCD9en4IQ1Zx2LB+7EYMdoyWVNa6ux/jqX33aAcc4+my22XqRcN4eJFhAgMBAAECgYAokvt3Ab505Apge66rnBUq6vI1rjeGfEeF1eHj8aNPjqBE4zpl5kog190e2SeMQJYEwsnUVugdyf7eu56FydEaD+kHYh1B+M6OX5/AuCdSvo/jw1YFcp3CnjqZnrg1VSkPFI6zvgOK1w4Mkhazj+91hKNtHXh2mJoxbbq0pjSLEQJBAOAGgxq97zMGslk8HKG2UutWWut5WuuXR8LOJwWS3aIBxsUPQf/Jk2nLdLzUvXoGc8ITPgwAK0hJmTuoxkmtHl0CQQDBEGd8/XaQPIotMxwJEhtm6Wx1zzNEAQTzWJ/sOs7EpIC5Kt+BhWsegGC8tD59CoM0Wy6DtqOT0mN+1vwo1qbVAkBSX9KhaKml15aI3WOhysreohg4cZ0O98d5SBhtIj3ArmqKVzvrdBFyW0+Hh6pMTkcOW8j63K0NnZJsr3iJ6tA5AkANdzJwolERsFdG3ci3zT6CCAfbk68UsCmDO4wz8soXJw4fXCEorICTKQsWPlAZcpFCJpXw890m40azQxVlV8tdAkAbFOkbl92HIHGUkjJVX2RrSIHchfpOrEltc4VSETX4P4FTWtspTIxJWZLGlTiOnCC5qRSQPfqisCfRuUIfKfZ2\n";
    private static String RSA_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCo80PPWpKolPp+nDshFGSiMx++bNWsOvpsQJn2+zjd4/z/0Bpu6H8+7jBaJZykSDCfadDIqTtdDkaBet9YiabWfmnPK/O99FPUepAVOTPtRTLJwif9HAwg/Xp+CENWcdiwfuxGDHaMllTWursf46l992gHHOPpsttl6kXDeHiRYQIDAQAB\n";


    /**
     *
     * @param payload [token携带的信息]
     * @return java.lang.String token字符串
     * @since 2023/3/1 11:16
     * @author Administrator
     * @description 生成token
     */
    public static String getToken(Map<String, String> payload){
        // 指定token过期时间为1天
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);

        JWTCreator.Builder builder = JWT.create();
        // 构建payload
        payload.forEach((k, v) -> builder.withClaim(k, v));
        // 指定过期时间和签名算法
        String token = builder.withExpiresAt(calendar.getTime()).sign(Algorithm.HMAC256(SECRET));
        return token;
    }


    /**
     *
     * @param token [token字符串]
     * @return com.auth0.jwt.interfaces.DecodedJWT 解析后的token
     * @since 2023/3/1 11:17
     * @author Administrator
     * @description 解析token
     */
    public static DecodedJWT decode(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        return decodedJWT;
    }




    /**
     *
     * @param payload [token携带的信息]
     * @return java.lang.String token字符串
     * @since 2023/3/1 11:25
     * @author Administrator
     * @description 生成token
     */
    public static String getTokenRsa(Map<String, String> payload){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);

        JWTCreator.Builder builder = JWT.create();

        // 构建 payload
        payload.forEach((k, v) -> builder.withClaim(k, v));

        // 利用hutool创建RSA
        RSA rsa = new RSA(RSA_PRIVATE_KEY);

        // 获取私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) rsa.getPrivateKey();

        // 签名时传入私钥
        String token = builder.withExpiresAt(calendar.getTime()).sign(Algorithm.RSA256(null, privateKey));

        return token;
    }


    /**
     *
     * @param token [token字符串]
     * @return com.auth0.jwt.interfaces.DecodedJWT 解析后的token
     * @since 2023/3/1 11:39
     * @author Administrator
     * @description 解析token
     */
    public static DecodedJWT decodeRsa(String token){
        // 利用hutool 创建RSA
        RSA rsa = new RSA(null, RSA_PUBLIC_KEY);
        //获取RSA公钥
        RSAPublicKey publicKey = (RSAPublicKey) rsa.getPublicKey();
        // 验签时传入公钥
        JWTVerifier jwtVerifier = JWT.require(Algorithm.RSA256(publicKey, null)).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        return decodedJWT;
    }


}
