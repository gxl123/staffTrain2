package com.xk.staff;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.xk.staff.repository")
public class StaffApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(StaffApplication2.class, args);
    }

}
