package com.syhdeclan.onlineform.security.config;

import com.syhdeclan.onlineform.security.validate.ValidateCodeProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shenyvhao
 * @program OnlineForm
 * @description
 * @create 2020-05-08 16
 **/

@ConfigurationProperties(prefix = "onlineform.security")
public class SecurityProperties {

    private ValidateCodeProperties code;

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }

    //需要get set 方法
}
