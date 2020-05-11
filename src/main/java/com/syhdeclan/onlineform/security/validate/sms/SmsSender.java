package com.syhdeclan.onlineform.security.validate.sms;

public interface SmsSender {

    void send(String phone, String code);

}
