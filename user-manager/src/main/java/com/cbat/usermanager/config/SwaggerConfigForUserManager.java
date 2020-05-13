package com.cbat.usermanager.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.ArrayList;
@Configuration
public class SwaggerConfigForUserManager {
    @Value("${swagger.isEnable}")
    private Boolean isEnable;
    @Bean
    public Docket getDocketForUserManager(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .groupName("用户管理模块")
                .enable(isEnable)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cbat.usermanager.controller"))
                .build()
                ;
    }

    private ApiInfo getApiInfo(){
        return new ApiInfo("Api 文档中心",
                "项目接口集合",
                "1.0",
                "www.spingdata.cn",
                new Contact("martingcong", "martingcong", "martingcong"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
