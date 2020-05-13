package com.syhdeclan.onlineform.security.validate.image;

import com.syhdeclan.onlineform.security.config.SecurityProperties;
import com.syhdeclan.onlineform.security.validate.ValidateCodeGenerator;
import com.wf.captcha.ArithmeticCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author shenyvhao
 * @program onlineform
 * @description
 * @create 2020-05-10 12
 **/


public class ImageCodeGenerator implements ValidateCodeGenerator {

    private StringRedisTemplate stringRedisTemplate;

    public StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }

    @Autowired
    private SecurityProperties securityProperties;

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /***
     验证码有效时间 5分钟
     */
//    private int expiration = 60;

    @Override
    public Map generate(HttpServletRequest request) {

        // 算术类型 https://gitee.com/whvse/EasyCaptcha

        int width = ServletRequestUtils.getIntParameter(request,"width",111);
        int height = ServletRequestUtils.getIntParameter(request,"height",36);

        ArithmeticCaptcha captcha = new ArithmeticCaptcha(width, height);
        // 几位数运算，默认是两位
        captcha.setLen(2);
        // 获取运算的结果
        String result = captcha.text();
        String uuid = UUID.randomUUID().toString();
        // 保存
        stringRedisTemplate.opsForValue().set(uuid, result, securityProperties.getCode().getImageExpiration(), TimeUnit.MINUTES);
        // 验证码信息
        Map<String,Object> imgResult = new HashMap<String,Object>(2){{
            put("img", captcha.toBase64());
            put("uuid", uuid);
        }};
        return imgResult;
    }
}
