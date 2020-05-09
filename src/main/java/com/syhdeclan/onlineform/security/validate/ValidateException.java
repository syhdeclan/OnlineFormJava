package com.syhdeclan.onlineform.security.validate;

import org.springframework.security.core.AuthenticationException;

/**
 * @author shenyvhao
 * @program OnlineForm
 * @description
 * @create 2020-05-08 22
 **/


public class ValidateException extends AuthenticationException {

    public ValidateException(String msg) {
        super(msg);
    }
}
