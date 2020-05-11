package com.syhdeclan.onlineform.security.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author shenyvhao
 * @program OnlineForm
 * @description 这个类的目的是为了让配置类生效
 * @create 2020-05-08 17
 **/


@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {


}
