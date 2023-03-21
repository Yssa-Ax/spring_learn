package com.ysan.business.authentication.model;

import lombok.Data;

/**
 * @author Administrator
 * @description
 * @since 2023/3/15 13:09
 **/
@Data
public class User {
    private String username;
    private String password;
    private String code;

}
