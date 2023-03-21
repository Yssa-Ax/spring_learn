package com.ysan.auth.service.impl;

import com.ysan.auth.domain.AuthCode;
import com.ysan.auth.domain.User;
import com.ysan.auth.repository.AuthCodeRepository;
import com.ysan.auth.repository.UserRepository;
import com.ysan.auth.service.UserService;
import com.ysan.auth.utils.GenerateCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Administrator
 * @description
 * @since 2023/3/14 17:07
 **/

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthCodeRepository authCodeRepository;


    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void auth(User user) {
        Optional<User> o = userRepository.findUserByUsername(user.getUsername());
        if (o.isPresent()){
            User u = o.get();
            // 完成用户密码匹配之后的刷新认证码流程
            if (passwordEncoder.matches(user.getPassword(), u.getPassword())) {
                generateOrRenewAutoCode(u);
            } else {
                throw new BadCredentialsException("Bad credentials.");
            }
        } else {
            throw new BadCredentialsException("Bad credentials.");
        }
    }


    @Override
    public boolean check(AuthCode authCodeToValidate) {
        Optional<AuthCode> authCode = authCodeRepository.findAuthCodeByUsername(authCodeToValidate.getUsername());
        if (authCode.isPresent()){
            AuthCode auth = authCode.get();
            if (authCodeToValidate.getCode().equals(auth.getCode())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void generateOrRenewAutoCode(User u) {
        String generateCode = GenerateCodeUtil.generateCode();
        Optional<AuthCode> authCode = authCodeRepository.findAuthCodeByUsername(u.getUsername());
        if (authCode.isPresent()) { // 如果存在认证码，则刷新该认证码
            AuthCode code = authCode.get();
            code.setCode(generateCode);
        } else { // 没有找到认证码，则生成并保存一个新的认证码
            AuthCode code = new AuthCode();
            code.setUsername(u.getUsername());
            code.setCode(generateCode);
            authCodeRepository.save(code);
        }
    }
}
