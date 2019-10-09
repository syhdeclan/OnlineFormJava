//package com.syhdeclan.onlineform.common;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@EnableSwagger2
//@Configuration
//public class SwaggerConfig {
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                // 自行修改为自己的包路径
//                .apis(RequestHandlerSelectors.basePackage("com.syhdeclan.onlineform.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("表单管理")
//                .description("syh的在线表单管理文档")
//                //服务条款网址
//                .termsOfServiceUrl("http://www.syhtio.cn/")
//                .version("1.0")
//                .contact(new Contact("STioPlato", "http://www.syhtio.cn/", "syhdeclan@163.com"))
//                .build();
//    }
//
//}
