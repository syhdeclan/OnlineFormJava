package com.syhdeclan.onlineform.security.validate.sms;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.syhdeclan.onlineform.common.Code;
import com.syhdeclan.onlineform.common.WebException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author shenyvhao
 * @program eladmin
 * @description
 * @create 2020-02-26 16
 **/


@Component
public class AliyunSmsSender implements SmsSender {

    @Value("${smsCode.regionId}")
    private String regionId;
    @Value("${smsCode.accessKeyId}")
    private String accessKeyId;
    @Value("${smsCode.secret}")
    private String secret;
    @Value("${smsCode.domain}")
    private String domain;
    @Value("${smsCode.version}")
    private String version;
    @Value("${smsCode.action}")
    private String action;
    @Value("${smsCode.SignName}")
    private String SignName;
    @Value("${smsCode.TemplateCode}")
    private String TemplateCode;

    @Override
    public void send(String phone, String code) {

        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, secret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain(domain);
        request.setVersion(version);
        request.setAction(action);
        request.putQueryParameter("RegionId", regionId);
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", SignName);
        request.putQueryParameter("TemplateCode", TemplateCode);
        request.putQueryParameter("TemplateParam", code);
        try {
            CommonResponse response = client.getCommonResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
            throw new WebException(Code.SMS_SEND_ERROR);
        } catch (ClientException e) {
            e.printStackTrace();
            throw new WebException(Code.SMS_SEND_ERROR);
        }

    }
}



