package com.syhdeclan.onlineform.security.validate;

import com.alibaba.druid.util.StringUtils;
import com.syhdeclan.onlineform.common.Code;
import com.syhdeclan.onlineform.common.WebException;
import com.syhdeclan.onlineform.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * @author shenyvhao
 * @program OnlineForm
 * @description
 * @create 2020-05-08 21
 **/

public class ValidateCodeFilter extends OncePerRequestFilter {

    private StringRedisTemplate stringRedisTemplate;

    private AuthenticationFailureHandler userAuthenticationFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        if (StringUtils.equals("/login", httpServletRequest.getRequestURI())
                && StringUtils.equalsIgnoreCase(httpServletRequest.getMethod(), "post")) {
            try {
                String uuid = httpServletRequest.getParameter("uuid");
                String userCode = httpServletRequest.getParameter("code");
                String code = stringRedisTemplate.opsForValue().get(uuid);
                stringRedisTemplate.delete(uuid);
                if (StringUtils.isEmpty(code)) {
                    throw new ValidateException("验证码不存在或已过期");
                }
                if (StringUtils.isEmpty(userCode) || !userCode.equalsIgnoreCase(code)) {
                    throw new ValidateException("验证码错误");
                }
            } catch (ValidateException e) {
                e.printStackTrace();
                userAuthenticationFailureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                throw new WebException(Code.SERVER_ERROR);
            }

        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    public StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public AuthenticationFailureHandler getUserAuthenticationFailureHandler() {
        return userAuthenticationFailureHandler;
    }

    public void setUserAuthenticationFailureHandler(AuthenticationFailureHandler userAuthenticationFailureHandler) {
        this.userAuthenticationFailureHandler = userAuthenticationFailureHandler;
    }
}
