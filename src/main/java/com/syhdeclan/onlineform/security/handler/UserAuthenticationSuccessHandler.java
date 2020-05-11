package com.syhdeclan.onlineform.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.syhdeclan.onlineform.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shenyvhao
 * @program OnlineForm
 * @description
 * @create 2020-05-08 11
 **/

@Component("userAuthenticationSuccessHandler")
public class UserAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //登录成功的处理，可能需要在Redis里面存一些东西

        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(JsonResult.success(authentication)));
    }
}
