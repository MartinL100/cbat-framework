package com.cbat.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MonitorApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MonitorApplication.class, args);

    }
}
