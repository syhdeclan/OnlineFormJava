package com.syhdeclan.onlineform.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.syhdeclan.onlineform.common.Code;
import com.syhdeclan.onlineform.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
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

@Component("userAuthenticationFailureHandler")
public class UserAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        //登录失败的处理
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(JsonResult.error(6,e.getMessage())));

    }
}
