package com.syhdeclan.onlineform.security.config;

import com.syhdeclan.onlineform.security.phone.SmsCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @author shenyvhao
 * @program onlineform
 * @description
 * @create 2020-05-16 17
 **/


@Component
public class SmsCodeFilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private AuthenticationFailureHandler userAuthenticationFailureHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {


        SmsCodeFilter smsCodeFilter = new SmsCodeFilter();
        smsCodeFilter.setStringRedisTemplate(stringRedisTemplate);
        smsCodeFilter.setUserAuthenticationFailureHandler(userAuthenticationFailureHandler);
        smsCodeFilter.setSecurityProperties(securityProperties);
        smsCodeFilter.afterPropertiesSet();

        http.addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
