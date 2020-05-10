package com.syhdeclan.onlineform.security.validate;

import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author shenyvhao
 * @program onlineform
 * @description
 * @create 2020-05-10 11
 **/


public interface ValidateCodeGenerator {

    Map generate(HttpServletRequest request);

}
