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
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler userAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler userAuthenticationFailureHandler;

    @Autowired
    private AccessDeniedHandler userAccessDeniedHandler;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private UserDetailsService userService;

    @Autowired
    private DataSource datasource;

    @Autowired
    SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

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

        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setStringRedisTemplate(stringRedisTemplate);
        validateCodeFilter.setUserAuthenticationFailureHandler(userAuthenticationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        SmsCodeFilter smsCodeFilter = new SmsCodeFilter();
        smsCodeFilter.setStringRedisTemplate(stringRedisTemplate);
        smsCodeFilter.setUserAuthenticationFailureHandler(userAuthenticationFailureHandler);
        smsCodeFilter.setSecurityProperties(securityProperties);
        smsCodeFilter.afterPropertiesSet();


        http
                //添加验证码过滤器
                .addFilterBefore(smsCodeFilter,UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)

                .formLogin()
                    //如果没有登录，则会自动跳到这个接口
                    .loginPage("/api/authentication/require")
                    //执行登录的接口
                    .loginProcessingUrl("/api/login")
                    //执行成功的处理器
                    .successHandler(userAuthenticationSuccessHandler)
                    //执行失败的处理器
                    .failureHandler(userAuthenticationFailureHandler)
                .and()
                    .exceptionHandling().accessDeniedHandler(userAccessDeniedHandler)

                .and()
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
                .and().csrf().disable()
                .authenticationProvider(daoAuthenticationProvider())
                .apply(smsCodeAuthenticationSecurityConfig);
    }
}
