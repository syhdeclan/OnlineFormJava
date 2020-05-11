package com.syhdeclan.onlineform.security.phone;

import com.syhdeclan.onlineform.common.Code;
import com.syhdeclan.onlineform.common.WebException;
import com.syhdeclan.onlineform.security.config.SecurityProperties;
import com.syhdeclan.onlineform.security.validate.ValidateException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shenyvhao
 * @program OnlineForm
 * @description
 * @create 2020-05-08 21
 **/

public class SmsCodeFilter extends OncePerRequestFilter implements InitializingBean {

    private StringRedisTemplate stringRedisTemplate;

    private AuthenticationFailureHandler userAuthenticationFailureHandler;

    private Set<String> urls = new HashSet<>();

    private SecurityProperties securityProperties;

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        String[] configUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getCode().getUrl(),",");
        for (String configUrl :
                configUrls) {
            urls.add(configUrl);
        }
        urls.add("/api/smsLogin");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        boolean action = false;

        for (String url :
                urls) {
            if (pathMatcher.match(url, httpServletRequest.getRequestURI())) {
                action = true;
                break;
            }
        }
        
        if (action) {
            try {
                String phone = httpServletRequest.getParameter("phone");
                String userCode = httpServletRequest.getParameter("code");
                //
                if (phone == null || userCode == null){
                    throw new ValidateException("手机号或验证码不能为空");
                }
                String code = stringRedisTemplate.opsForValue().get(phone);
                if (StringUtils.isEmpty(code)) {
                    throw new ValidateException("验证码不存在或已过期");
                }
                if (StringUtils.isEmpty(userCode) || !userCode.equalsIgnoreCase(code)) {
                    throw new ValidateException("验证码错误");
                }
                stringRedisTemplate.delete(phone);
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

    public Set<String> getUrls() {
        return urls;
    }

    public void setUrls(Set<String> urls) {
        this.urls = urls;
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
