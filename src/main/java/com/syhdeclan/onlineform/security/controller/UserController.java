package com.syhdeclan.onlineform.security.controller;

import com.syhdeclan.onlineform.common.Code;
import com.syhdeclan.onlineform.common.JsonResult;
import com.syhdeclan.onlineform.security.entity.JwtUser;
import com.syhdeclan.onlineform.security.service.UserService;
import com.syhdeclan.onlineform.security.validate.ImageCodeGenerator;
import com.syhdeclan.onlineform.security.validate.ValidateCodeGenerator;
import com.wf.captcha.ArithmeticCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;

    /**
     * 需要授权时返回数据的接口
     * @return
     */
    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public JsonResult requireAuthentication(){

        return JsonResult.error(Code.UNAUTHORIZED);
    }

    @GetMapping("/code")
    public JsonResult getCode(HttpServletRequest request){
        return JsonResult.success(imageCodeGenerator.generate(request));
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
