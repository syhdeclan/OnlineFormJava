package com.syhdeclan.onlineform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author syh
 */
@SpringBootApplication
@EnableSwagger2
public class OnlineformApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineformApplication.class, args);
    }

}
