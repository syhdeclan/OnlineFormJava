package com.syhdeclan.onlineform.security.validate;

import com.syhdeclan.onlineform.common.Code;
import com.syhdeclan.onlineform.common.WebException;
import com.syhdeclan.onlineform.security.config.SecurityProperties;
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

public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {

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
        urls.add("/login");
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
                String uuid = httpServletRequest.getParameter("uuid");
                String userCode = httpServletRequest.getParameter("code");
                //
                if (uuid == null || userCode == null){
                    throw new ValidateException("请求错误");
                }
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
