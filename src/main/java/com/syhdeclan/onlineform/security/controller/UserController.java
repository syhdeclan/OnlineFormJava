package com.syhdeclan.onlineform.security.controller;

import com.syhdeclan.onlineform.common.Code;
import com.syhdeclan.onlineform.common.JsonResult;
import com.syhdeclan.onlineform.security.entity.JwtUser;
import com.syhdeclan.onlineform.security.service.UserService;
import com.wf.captcha.ArithmeticCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author shenyvhao
 * @program OnlineForm
 * @description
 * @create 2020-05-07 23
 **/

@RestController
public class UserController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserService userService;

    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public JsonResult requireAuthentication(){

        return JsonResult.error(Code.UNAUTHORIZED);
    }

    @GetMapping("/code")
    public JsonResult getCode(){
        //验证码有效时间 5分钟
        int expiration = 5;
        // 算术类型 https://gitee.com/whvse/EasyCaptcha
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(111, 36);
        // 几位数运算，默认是两位
        captcha.setLen(2);
        // 获取运算的结果
        String result = captcha.text();
        String uuid = UUID.randomUUID().toString();
        // 保存
        stringRedisTemplate.opsForValue().set(uuid, result, expiration, TimeUnit.MINUTES);
        // 验证码信息
        Map<String,Object> imgResult = new HashMap<String,Object>(2){{
            put("img", captcha.toBase64());
            put("uuid", uuid);
        }};
        return JsonResult.success(imgResult);
    }

    @PostMapping("/register")
    public JsonResult createUser(@RequestBody JwtUser user){

        return JsonResult.success(this.userService.createUser(user));

    }

    @GetMapping("/checkUsernameIsUsed")
    public JsonResult checkUsername(String username){
        return JsonResult.success(this.userService.checkUsernameIsUsed(username));
    }

    @GetMapping("/checkPhoneIsUsed")
    public JsonResult checkPhone(String phone){
        return JsonResult.success(this.userService.checkPhoneIsUsed(phone));
    }

    @GetMapping("/checkEmailIsUsed")
    public JsonResult checkEmail(String email){
        return JsonResult.success(this.userService.checkPhoneIsUsed(email));
    }

}
