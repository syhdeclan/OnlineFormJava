package com.syhdeclan.onlineform.security.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author shenyvhao
 * @program OnlineForm
 * @description
 * @create 2020-05-09 11
 **/

@Data
public class AuthUser {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String uuid;

    private String code;

}
