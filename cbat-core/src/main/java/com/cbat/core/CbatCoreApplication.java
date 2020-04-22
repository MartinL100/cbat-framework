package com.cbat.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.cbat.usermanager"
        ,"com.cbat.exceptionhandler"
        , "com.cbat.core"})

@SpringBootApplication
public class CbatCoreApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(CbatCoreApplication.class, args);

    }
}
