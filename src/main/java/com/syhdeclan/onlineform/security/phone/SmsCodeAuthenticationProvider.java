package com.syhdeclan.onlineform.security.phone;

import com.syhdeclan.onlineform.common.Code;
import com.syhdeclan.onlineform.common.WebException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author shenyvhao
 * @program onlineform
 * @description
 * @create 2020-05-10 23
 **/


public class SmsCodeAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        SmsCodeAuthenticationToken authenticationToken = (SmsCodeAuthenticationToken) authentication;

        UserDetails user = userDetailsService.loadUserByUsername((String)authentication.getPrincipal());

        if (user == null) {
//            throw new WebException(Code.SMS_SEND_ERROR);
            throw new InternalAuthenticationServiceException("无法获取用户信息");
        }
        SmsCodeAuthenticationToken authenticationResult = new SmsCodeAuthenticationToken(user, user.getAuthorities());

        authenticationResult.setDetails(authenticationToken.getDetails());

        return authenticationResult;
    }

    /**
     * 判断一下传进来的东西是不是 smscodeAuthenticationtoken类型的
     * 是的话调用AuthenticationManager的时候就能调用这个类来验证了
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        //判断class类型是否相同
        return SmsCodeAuthenticationToken.class.isAssignableFrom(aClass);
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
