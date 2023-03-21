package com.ysan.jwt.utils;

import cn.hutool.crypto.asymmetric.RSA;
import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;

/**
 * @author Administrator
 * @description
 * @since 2023/3/1 13:36
 **/
public class JJWTUtils {
    // token时效： 24小时
    public static final long EXPIRE = 1000 * 60 * 60 * 24;

    // 签名哈希的密钥，对于不同的加密算法来说含义不同
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";

    private static String RSA_PRIVATE_KEY = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKjzQ89akqiU+n6cOyEUZKIzH75s1aw6+mxAmfb7ON3j/P/QGm7ofz7uMFolnKRIMJ9p0MipO10ORoF631iJptZ+ac8r8730U9R6kBU5M+1FMsnCJ/0cDCD9en4IQ1Zx2LB+7EYMdoyWVNa6ux/jqX33aAcc4+my22XqRcN4eJFhAgMBAAECgYAokvt3Ab505Apge66rnBUq6vI1rjeGfEeF1eHj8aNPjqBE4zpl5kog190e2SeMQJYEwsnUVugdyf7eu56FydEaD+kHYh1B+M6OX5/AuCdSvo/jw1YFcp3CnjqZnrg1VSkPFI6zvgOK1w4Mkhazj+91hKNtHXh2mJoxbbq0pjSLEQJBAOAGgxq97zMGslk8HKG2UutWWut5WuuXR8LOJwWS3aIBxsUPQf/Jk2nLdLzUvXoGc8ITPgwAK0hJmTuoxkmtHl0CQQDBEGd8/XaQPIotMxwJEhtm6Wx1zzNEAQTzWJ/sOs7EpIC5Kt+BhWsegGC8tD59CoM0Wy6DtqOT0mN+1vwo1qbVAkBSX9KhaKml15aI3WOhysreohg4cZ0O98d5SBhtIj3ArmqKVzvrdBFyW0+Hh6pMTkcOW8j63K0NnZJsr3iJ6tA5AkANdzJwolERsFdG3ci3zT6CCAfbk68UsCmDO4wz8soXJw4fXCEorICTKQsWPlAZcpFCJpXw890m40azQxVlV8tdAkAbFOkbl92HIHGUkjJVX2RrSIHchfpOrEltc4VSETX4P4FTWtspTIxJWZLGlTiOnCC5qRSQPfqisCfRuUIfKfZ2\n";
    private static String RSA_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCo80PPWpKolPp+nDshFGSiMx++bNWsOvpsQJn2+zjd4/z/0Bpu6H8+7jBaJZykSDCfadDIqTtdDkaBet9YiabWfmnPK/O99FPUepAVOTPtRTLJwif9HAwg/Xp+CENWcdiwfuxGDHaMllTWursf46l992gHHOPpsttl6kXDeHiRYQIDAQAB\n";

    
    /**
     * 
     * @param id [用户id]
     * @param nickname [用户名称]
     * @return java.lang.String
     * @since 2023/3/1 13:38
     * @author Administrator
     * @description 根据用户id和昵称生成token
     */
    public static String getJJwtToken(String id, String nickname) {
        String token = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setSubject("baobao-user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("id", id)
                .claim("nickname", nickname)
                .signWith(SignatureAlgorithm.ES256, APP_SECRET) // HS256算法实际上就是MD5加盐值，此事APP_SECRET就代表盐值
                .compact();
        return token;
    }



    /**
     *
     * @param token [token字符串]
     * @return boolean
     * @since 2023/3/1 13:42
     * @author Administrator
     * @description token有效返回true,否则返回false
     */
    public static boolean checkToken(String token){
        if (StringUtils.isEmpty(token)) return false;

        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }



    /**
     *
     * @param request [Http请求对象]
     * @return boolean 有效返回true，否则返回false
     * @since 2023/3/1 13:46
     * @author Administrator
     * @description 判断token是否存在与有效
     */
    public static boolean checkToken(HttpServletRequest request){
        try {
            // 从http请求头中获取token字符串
            String token = request.getHeader("token");
            if (StringUtils.isEmpty(token)) return false;
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     *
     * @param request [Http请求对象]
     * @return java.lang.String
     * @since 2023/3/1 13:50
     * @author Administrator
     * @description 根据token获取会员id
     */
    public static String getMemberIdByJwtToken(HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        return (String)body.get("id");
    }


    /**
     *
     * @param request [Http请求对象]
     * @return java.lang.String
     * @since 2023/3/1 13:50
     * @author Administrator
     * @description 根据token获取信息
     */
    public static Claims getJwtToken(HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) return null;
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        return body;
    }


    public static Claims getJwtToken(String token){
        if (StringUtils.isEmpty(token)) return null;
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        return body;
    }


    /**
     *
     * @param id [用户id]
     * @param nickname [用户昵称]
     * @return java.lang.String
     * @since 2023/3/1 13:58
     * @author Administrator 用户昵称
     * @description 根据用户id和昵称生成token
     */
    public static String getJJwtTokenRsa(String id, String nickname){
        // 利用hutool创建RSA
        RSA rsa = new RSA(RSA_PRIVATE_KEY, null);
        RSAPrivateKey privateKey = (RSAPrivateKey) rsa.getPrivateKey();

        String token = Jwts.builder()
                .setSubject("baobao-user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("id", id)
                .claim("nickname", nickname)
                .signWith(SignatureAlgorithm.RS256, privateKey) // 签名指定私钥
                .compact();

        return token;
    }


    /**
     *
     * @param jwtToken [token字符串]
     * @return io.jsonwebtoken.Jws<io.jsonwebtoken.Claims>
     * @since 2023/3/1 14:07
     * @author Administrator
     * @description 判断token是否存在与有效
     */
    public static Jws<Claims> decodeRsa(String jwtToken){
        RSA rsa = new RSA(null, RSA_PUBLIC_KEY);
        RSAPublicKey publicKey = (RSAPublicKey) rsa.getPublicKey();
        // 验签指定公钥
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(jwtToken);
        return claimsJws;
    }
}
