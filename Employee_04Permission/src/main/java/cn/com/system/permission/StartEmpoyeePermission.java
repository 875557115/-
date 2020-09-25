package cn.com.system.permission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"cn.com.system.permission.controller",
                               "cn.com.system.permission.service",
                               "cn.com.system.permission.config"})
public class StartEmpoyeePermission {
    public static void main(String[] args) {
        SpringApplication.run(StartEmpoyeePermission.class, args);
    }
}
