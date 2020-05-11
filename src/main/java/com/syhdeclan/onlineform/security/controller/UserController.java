package com.syhdeclan.onlineform.security.controller;

import com.syhdeclan.onlineform.common.Code;
import com.syhdeclan.onlineform.common.JsonResult;
import com.syhdeclan.onlineform.common.WebException;
import com.syhdeclan.onlineform.security.entity.JwtUser;
import com.syhdeclan.onlineform.security.service.UserService;
import com.syhdeclan.onlineform.security.validate.sms.AliyunSmsSender;
import com.syhdeclan.onlineform.security.validate.sms.SmsCodeGenerator;
import com.syhdeclan.onlineform.security.validate.ValidateCodeGenerator;
import com.syhdeclan.onlineform.security.validate.sms.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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

    @Autowired
    private ValidateCodeGenerator smsCodeGenerator;

    @Autowired
    private SmsSender aliyunSmsSender;

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

    @GetMapping("/smsCode")
    public JsonResult getSmsCode(HttpServletRequest request){

        Map<String,Object> result = null;
        try {
            result = smsCodeGenerator.generate(request);
            aliyunSmsSender.send((String)result.get("phone"),(String)result.get("code"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebException(Code.SMS_SEND_ERROR);
        }
        result.remove("code");
        result.put("msg","发送成功");
        return JsonResult.success(result);
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
        return JsonResult.success(this.userService.checkEmailIsUsed(email));
    }

}
