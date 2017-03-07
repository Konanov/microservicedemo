package com.konanov.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by user01 on 3/7/17.
 */

@SpringBootApplication
@EnableFeignClients
public class ApiServiceApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ApiServiceApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
    }
}
