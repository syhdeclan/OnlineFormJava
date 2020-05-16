package com.syhdeclan.onlineform.security.validate.sms;

import com.syhdeclan.onlineform.security.config.SecurityProperties;
import com.syhdeclan.onlineform.security.validate.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author shenyvhao
 * @program onlineform
 * @description
 * @create 2020-05-10 19
 **/

@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private SecurityProperties securityProperties;

    /***
     验证码有效时间 5分钟
     */
//    private int expiration = 60;

    @Override
    public Map generate(HttpServletRequest request) {

        String code = RandomStringUtils.randomNumeric(6);
        String uuid = UUID.randomUUID().toString();

        // 保存
        stringRedisTemplate.opsForValue().set(uuid, code, securityProperties.getCode().getSmsExpiration(), TimeUnit.MINUTES);
        // 验证码信息
        Map<String,Object> result = new HashMap<String,Object>(2){{
            put("code", code);
            put("uuid", uuid);
        }};
        return result;
    }
}
