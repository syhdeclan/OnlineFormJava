package com.syhdeclan.onlineform.security.validate;

/**
 * @author shenyvhao
 * @program onlineform
 * @description
 * @create 2020-05-10 10
 **/


public class ValidateCodeProperties {

    String imageCodeUrl;

    String smsCodeUrl;

    int imageExpiration;

    int smsExpiration;


    public int getImageExpiration() {
        return imageExpiration;
    }

    public void setImageExpiration(int imageExpiration) {
        this.imageExpiration = imageExpiration;
    }

    public int getSmsExpiration() {
        return smsExpiration;
    }

    public void setSmsExpiration(int smsExpiration) {
        this.smsExpiration = smsExpiration;
    }

    public String getImageCodeUrl() {
        return imageCodeUrl;
    }

    public void setImageCodeUrl(String imageCodeUrl) {
        this.imageCodeUrl = imageCodeUrl;
    }

    public String getSmsCodeUrl() {
        return smsCodeUrl;
    }

    public void setSmsCodeUrl(String smsCodeUrl) {
        this.smsCodeUrl = smsCodeUrl;
    }
}
