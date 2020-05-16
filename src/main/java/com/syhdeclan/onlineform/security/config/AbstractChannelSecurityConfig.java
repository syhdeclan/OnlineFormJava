package com.syhdeclan.onlineform.security.config;

import com.syhdeclan.onlineform.security.handler.UserAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author shenyvhao
 * @program onlineform
 * @description
 * @create 2020-05-16 17
 **/


public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler userAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler userAuthenticationFailureHandler;

    @Autowired
    private AccessDeniedHandler userAccessDeniedHandler;

    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception{

        //登录密码相关的一些配置
        http
                .formLogin()
                //如果没有登录，则会自动跳到这个接口
                .loginPage("/api/authentication/require")
                //执行登录的接口
                .loginProcessingUrl("/api/login")
                //执行成功的处理器
                .successHandler(userAuthenticationSuccessHandler)
                //执行失败的处理器
                .failureHandler(userAuthenticationFailureHandler)
                .and()
                //403配置
                .exceptionHandling().accessDeniedHandler(userAccessDeniedHandler);

    }

}
