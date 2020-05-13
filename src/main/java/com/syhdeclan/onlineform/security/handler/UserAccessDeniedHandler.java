package com.syhdeclan.onlineform.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.syhdeclan.onlineform.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shenyvhao
 * @program onlineform
 * @description
 * @create 2020-05-13 10
 **/

@Component("userAccessDeniedHandler")
public class UserAccessDeniedHandler implements AccessDeniedHandler {

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {

        //登录失败的处理
        e.printStackTrace();
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(JsonResult.error(8, e.getMessage())));

    }
}
