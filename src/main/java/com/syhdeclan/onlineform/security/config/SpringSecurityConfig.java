package com.syhdeclan.onlineform.security.config;

import com.syhdeclan.onlineform.security.phone.SmsCodeAuthenticationSecurityConfig;
import com.syhdeclan.onlineform.security.phone.SmsCodeFilter;
import com.syhdeclan.onlineform.security.validate.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author shenyvhao
 * @program OnlineForm
 * @description
 * @create 2020-05-07 16
 **/

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends AbstractChannelSecurityConfig {


    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private UserDetailsService userService;

    @Autowired
    private DataSource datasource;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private SmsCodeFilterConfig smsCodeFilterConfig;

    @Autowired
    private ImageCodeFilterConfig imageCodeFilterConfig;

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(datasource);
        return tokenRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userService);
        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        applyPasswordAuthenticationConfig(http);




        http
                //添加图片验证码过滤器
                .apply(imageCodeFilterConfig)
                .and()
                //添加短信验证码过滤器
                .apply(smsCodeFilterConfig)
                .and()

                //添加短信验证码验证机制
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                //添加用户名密码验证机制
                .authenticationProvider(daoAuthenticationProvider())


//浏览器特有配置
                //记住我
                .rememberMe()
                    .tokenRepository(persistentTokenRepository())
                    .tokenValiditySeconds(securityProperties.getRememberMeSeconds())
                    .userDetailsService(userService)

                // 防止iframe 造成跨域
                .and()
                    .headers()
                    .frameOptions()
                    .disable()

                //下方是url权限控制
                .and()
                    .authorizeRequests()
                    //指定url，放行
                    // 静态资源等等
                    .antMatchers(
                            HttpMethod.GET,
                            "/*.html",
                            "/**/*.html",
                            "/**/*.css",
                            "/**/*.js",
                            "/webSocket/**"
                    ).permitAll()
                    // swagger 文档
                    .antMatchers("/swagger-ui.html").permitAll()
                    .antMatchers("/swagger-resources/**").permitAll()
                    .antMatchers("/webjars/**").permitAll()
                    .antMatchers("/*/api-docs").permitAll()
                    // 文件
                    .antMatchers("/avatar/**").permitAll()
                    .antMatchers("/file/**").permitAll()
                    // 阿里巴巴 druid
                    .antMatchers("/druid/**").permitAll()
                    //登录请求
                    .antMatchers("/api/authentication/require","/api/login","/api/smsLogin","/api/code","/api/smsCode").permitAll()
                    // 放行OPTIONS请求
                    .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                    //任意url
//                    .anyRequest()
    //                //需要认证
//                    .authenticated()
                    //关闭csrf以允许Druid
                .and().csrf().disable();
    }
}
