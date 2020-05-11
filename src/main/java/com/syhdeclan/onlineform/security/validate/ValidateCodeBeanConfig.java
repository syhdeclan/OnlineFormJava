package com.syhdeclan.onlineform.security.validate;

import com.syhdeclan.onlineform.security.config.SecurityProperties;
import com.syhdeclan.onlineform.security.validate.image.ImageCodeGenerator;
import com.syhdeclan.onlineform.security.validate.sms.AliyunSmsSender;
import com.syhdeclan.onlineform.security.validate.sms.SmsCodeGenerator;
import com.syhdeclan.onlineform.security.validate.sms.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author shenyvhao
 * @program onlineform
 * @description
 * @create 2020-05-10 12
 **/

@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator(){
        ImageCodeGenerator imageCodeGenerator = new ImageCodeGenerator();
        imageCodeGenerator.setStringRedisTemplate(stringRedisTemplate);
        return imageCodeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(SmsSender.class)
    public SmsSender smsSender(){
        return new AliyunSmsSender();
    }

}
